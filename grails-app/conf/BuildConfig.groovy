grails.project.work.dir = 'target'

// for backwards-compatibility, the docs are checked into gh-pages branch
grails.project.docs.output.dir = 'docs/manual'

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()
        mavenCentral()
        mavenRepo "https://repo.grails.org/grails/plugins"
    }

    dependencies {

        compile 'net.java.dev.jets3t:jets3t:0.9.0'

        build 'org.apache.httpcomponents:httpclient:4.3.4'
        runtime 'org.apache.httpcomponents:httpclient:4.3.4'
        // httpcore 4.3.2 is a dependency of httpclient 4.3.4
        build 'org.apache.httpcomponents:httpcore:4.3.2'
        runtime 'org.apache.httpcomponents:httpcore:4.3.2'

        compile 'javax.mail:mail:1.4.1'
        compile 'commons-logging:commons-logging:1.1.1'
        compile 'org.codehaus.jackson:jackson-core-asl:1.7.2'

        compile 'com.amazonaws:aws-java-sdk:1.9.13', {
            excludes 'stax-api', 'jackson-core-asl', 'httpclient', 'commons-logging'
        }
    }

    plugins {
        // this version of the release plugin requires grails 2.3.x
        build(":release:3.1.1",
              ":rest-client-builder:2.1.1") {
            export = false
        }
    }
}
