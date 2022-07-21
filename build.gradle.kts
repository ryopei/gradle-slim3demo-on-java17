plugins {
    id("java")
    id("com.google.cloud.tools.appengine") version "2.4.4"
}

group = "org.slim3.slim3demo"
version = "1.0-SNAPSHOT"

val slim3Version = "1.0.16"

repositories {
    mavenCentral()
    maven("https://maven.seasar.org/maven2")
}

dependencies {
    implementation(fileTree("lib"))

    implementation("javax.jdo:jdo-api:3.0.1")
    implementation("com.google.appengine:appengine-api-1.0-sdk:2.0.4")
    compileOnly("javax.servlet:javax.servlet-api:3.1.0")

    implementation("org.slim3:slim3:${slim3Version}")
    annotationProcessor(files("slim3.lib/slim3-gen-jsr269-1.0.17-SNAPSHOT.jar"))
}

appengine {
    deploy {
        projectId = "gradle-slim3demo-on-java17"
        version = "GCLOUD_CONFIG"
        stopPreviousVersion = true
        promote = true
    }
}

sourceSets {
    main {
        java.srcDir("src/test/java")
    }
}

ant.importBuild("build.xml")