class RestApiUrlMappings {

    static mappings = {
//        "/restapi"(controller: "review", parseRequest: true){
//            action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
//        }

        "/api/*/$id?"(controller: 'restApi'){
            action = [GET: "show", PUT: "update", POST: "save"]
        }
    }
}
