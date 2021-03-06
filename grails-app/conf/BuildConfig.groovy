grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
//        grailsCentral()
        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.18'
//        test ":spock:0.7"
    }

    plugins {
        //for grails ver above 2.3 the release 3.0.0 plugin is available
        build ':release:2.2.1', ':rest-client-builder:1.0.3', {
            export = false
        }

        build(":tomcat:$grailsVersion",
                ":release:2.0.3",
                ":rest-client-builder:1.0.2") {
            export = false
        }

        test ":spock:0.7"
    }

    /*****Spock Config*****/
    grails.project.dependency.resolution = {
        repositories {
            grailsCentral()
            grailsPlugins()
            mavenRepo "http://m2repo.spockframework.org/snapshots"
            grailsLocal()
            mavenLocal()
            mavenCentral()
        }
        plugins {
            test ":spock:0.7"
        }
    }
}
