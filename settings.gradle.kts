rootProject.name = "golf-data-gateway"

pluginManagement {
    // Plugin versions from gradle.properties
    val springBootPluginVersion: String by settings
    val springDependencyManagementPluginVersion: String by settings

    plugins {
        id("org.springframework.boot") version springBootPluginVersion
        id("io.spring.dependency-management") version springDependencyManagementPluginVersion
    }
}
