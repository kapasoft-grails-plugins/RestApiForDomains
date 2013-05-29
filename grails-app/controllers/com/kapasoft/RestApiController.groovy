package com.kapasoft

import grails.converters.JSON

class RestApiController {

    def notifierService
    //HTTP GET with JSON data
    def show(){
        String className = 'com.minnehahalofts.app.' + domainName(request.forwardURI)
        def result = null
        Class clazz = grailsApplication.getDomainClass(className)?.clazz

        if (!clazz){
            errorMissingDomain(className)
            return
        }

//      def queryForDomain = clazz.createCriteria()
        if(params.id){
//            result = queryForDomain.list{
//                like('title',params.title)
//            }
            result = clazz.get(params.id)
        }else{
            result = clazz.list()
        }
        if (result){
            render result as JSON
        }else{
            errorMissingInstance(params.id)
        }
    }

    //HTTP PUT with JSON data
    def update() {
        String className = 'com.minnehahalofts.app.' + domainName(request.forwardURI)
        Class clazz = grailsApplication.getDomainClass(className)?.clazz

        if (!clazz){
            errorMissingDomain(className)
            return
        }

        def review = clazz.get(params?.id)

        if (!review){
            errorMissingInstance(params.id)
            return
        }

        //binding request.JSON into save() seems to have issues
        request.JSON.each() { key, value ->
            if (!review.hasProperty(key)){//check to see if property exist to avoid
               return render(contentType: "text/json"){
                    [
                            error: "property - $key doesn't exist for domain $className"
                    ]
                }
            }
            review."$key" = value
        }

        if (!review.save()){
            render(contentType: "text/json"){
                def errors = array{
                    for (e in review.errors.allErrors){
                        error field: e.field
                        error message: e.defaultMessage
                    }
                }
            }
        }else{
            def responseSome = [
                    'status' : 'ok'
            ]
            render responseSome as JSON
        }
    }

    //HTTP POST with JSON data
    def save() {
        String className = 'com.minnehahalofts.app.' + domainName(request.forwardURI)
        Class clazz = grailsApplication.getDomainClass(className)?.clazz

        if (!clazz){
            errorMissingDomain(className)
            return
        }

        def review = clazz.newInstance(request.JSON)
        if (!review.save()){
            render(contentType: "text/json"){
                def errors = array{
                    for (e in review.errors.allErrors){
                        error field: e.field
                        error message: e.defaultMessage
                    }
                }
            }
        }else{
            render review as JSON
            notifierService.registerRequest(review)
        }

    }

    //responce with error when instance by the particular id is missing
    private def errorMissingInstance(id){
        render(contentType: 'application/json'){
            [
                    'error' : "domain by the id: $id does not exist"
            ]
        }
    }

    //respond with error when domain by className is not found
   private def errorMissingDomain(domainName){
        render(contentType: 'application/json'){
            [
                    'error' : "domain by the class name: $domainName does not exist"
            ]
        }
    }

    //substract domain class from the relative url of current request
    private String domainName(url){
        int start = url.indexOf('api/') + 4
        String subUrl = url.getAt(start..-1)
        int end =  subUrl.indexOf('/') - 1
        subUrl.getAt(0..end).capitalize()
    }

}

