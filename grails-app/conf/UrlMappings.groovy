class UrlMappings {

    static mappings = {

//        "/restapi/$id"(controller: "review", parseRequest: true){
//            action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
//        }

        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
    }
}
