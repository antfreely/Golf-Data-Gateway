rootProject.name = "golf-data-gateway"

pluginManagement {
    val springBootPluginVersion: String by settings
    val springDependencyManagementPluginVersion: String by settings

    plugins {
        id("org.springframework.boot") version springBootPluginVersion
        id("io.spring.dependency-management") version springDependencyManagementPluginVersion
    }
}
