plugins {
    java
    id "org.sonarqube" version "2.6"
}
group = "com.tavisca.workshops"
//version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "com.tavisca.workshops.tdd.Merchant"
    }
}

dependencies {
//    testCompile("junit", "junit", "4.12")
    
    implementation("org.json:json:20180813")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.0")
    
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.register<Test>("hidden-tests")

tasks.named<Test>("test") {
    dependsOn("cleanTest")
    useJUnitPlatform {
        includeEngines("junit-jupiter")
        excludeTags("hidden")
    }

    testLogging {
        showExceptions = true
        events("passed", "skipped", "failed")
    }
}


tasks.named<Test>("hidden-tests") {
    useJUnitPlatform {
        includeEngines("junit-jupiter")
        includeTags("hidden")
    }

    testLogging {
        showExceptions = true
        events("passed", "skipped", "failed")
    }
}