plugins {
    application
    java
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

group = "com.imgarena"
version = "0.0.1-SNAPSHOT"

val lombokVersion: String by project

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

tasks {
    named<Test>("test") {
        useJUnitPlatform()
    }
}

dependencies {
    annotationProcessor("org.projectlombok", "lombok")
    compileOnly("org.projectlombok", "lombok")
    runtimeOnly("com.h2database", "h2")

    implementation("org.projectlombok", "lombok", lombokVersion)
    implementation("org.springframework.boot", "spring-boot-starter")
    implementation("org.springframework.boot", "spring-boot-starter-web")
    implementation("org.springframework.boot", "spring-boot-starter-data-jpa")

    testAnnotationProcessor("org.projectlombok", "lombok")
    testCompileOnly("org.projectlombok", "lombok")

    testImplementation("org.assertj", "assertj-core")
    testImplementation("org.mockito", "mockito-inline")
    testImplementation("org.springframework.boot", "spring-boot-starter-test")
}
