plugins {
    id("application")
    id("com.github.ben-manes.versions") version "0.52.0"
    id("checkstyle")
    id("jacoco")
    id("org.sonarqube") version "6.2.0.5505"
}

application {
    mainClass.set("hexlet.code.App")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.5")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.1")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        showStandardStreams = true
    }
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }

sonar {
    properties {
        property("sonar.projectKey", "GishebetMaksim_java-project-71")
        property("sonar.organization", "gishebetmaksim")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
