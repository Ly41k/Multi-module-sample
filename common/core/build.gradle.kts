import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_17.toString()
            }
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)

            api(libs.coroutines.core)
            api(libs.ktor.core)
            api(libs.kodein)

            implementation(libs.ktor.json)
            implementation(libs.ktor.serialization)
            implementation(libs.ktor.negotiation)
            implementation(libs.ktor.serialization)
            implementation(libs.ktor.kotlinx.json)
            implementation(libs.ktor.logging)

            implementation(libs.kviewmodel.core)
        }

        androidMain.dependencies {
            implementation(libs.ktor.android)
            implementation(libs.androidx.core)
        }

        iosMain.dependencies {
            implementation(libs.ktor.ios)
        }
    }
}

android {
    namespace = "org.example.multimodulesample.core"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of(JavaVersion.VERSION_17.toString()))
        }
    }
}
