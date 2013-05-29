
import org.codehaus.groovy.grails.commons.GrailsClassUtils as GCU

class RestApiForDomainsGrailsPlugin {
    //repository id
    def groupId = 'minnehaha'
    // the plugin version
    def version = "0.1-SNAPSHOT"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.1 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def title = "Rest Api For Domains Plugin" // Headline display name of the plugin
    def author = "Your name"
    def authorEmail = ""
    def description = '''\
Brief summary/description of the plugin.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/rest-api-for-domains"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
//    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Location of the plugin's issue tracker.
//    def issueManagement = [ system: "JIRA", url: "http://jira.grails.org/browse/GPMYPLUGIN" ]

    // Online location of the plugin's browseable source code.
//    def scm = [ url: "http://svn.codehaus.org/grails-plugins/" ]

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before
    }

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }

    def doWithDynamicMethods = { ctx ->
//        // TODO Implement registering dynamic methods to classes (optional)
//        def service = ctx.nodeDriverProxyService
//        application.domainClasses.each{ cClass ->
//            def isCached = GCU.getStaticPropertyValue(cClass.clazz, "isCached")
//            if(isCached){
//                cClass.metaClass.afterUpdate = { ->
//                    delegate.log.warn "domain is being cached id: $delegate.id with version $delegate.version"
//                    service.registerUpdate(delegate.id, delegate.version)
//                }
//
//            }
//        }
    }
//            def isCached = GCU.getStaticPropertyValue(cClass.clazz, "isCached")
//            if(isCached){
////                cClass.metaClass.afterUpdate = { domainIns ->
////                    log.warn("domain is being cached: ${domainIns.id} with version ${domainIns.version}");
////                    //        nodeDriverProxyService.registerUpdate(id, this.version)
////                }
//                cClass.metaClass.afterUpdate = { ->
//                    log.warn("domain is being cached: with version ");
//                    //        nodeDriverProxyService.registerUpdate(id, this.version)
//                }
//
////    def afterUpdate = {
//////        log.warn "${id} is toast by"
////        nodeDriverProxyService.registerUpdate(id, this.version)
////    }
//            }


        def doWithApplicationContext = { applicationContext ->
            // TODO Implement post initialization spring config (optional)
        }

        def onChange = { event ->
            // TODO Implement code that is executed when any artefact that this plugin is
            // watching is modified and reloaded. The event contains: event.source,
            // event.application, event.manager, event.ctx, and event.plugin.
        }

        def onConfigChange = { event ->
            // TODO Implement code that is executed when the project configuration changes.
            // The event is the same as for 'onChange'.
        }

        def onShutdown = { event ->
            // TODO Implement code that is executed when the application shuts down (optional)
        }
    }
