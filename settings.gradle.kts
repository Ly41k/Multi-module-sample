rootProject.name = "Multi-modulesample"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

include(":composeApp")
include(":common:feature:api")
include(":common:feature:data")
include(":common:feature:presentation")
include(":common:feature:compose")
include(":common:core")
include(":common:feature:domain")
include(":common:umbrella")
include(":common:splash:compose")