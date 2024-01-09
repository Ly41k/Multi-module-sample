plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
}

kotlin{

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_17.toString()
            }
        }
    }

    sourceSets{
        commonMain.dependencies {
            implementation(projects.common.api)
            implementation(projects.common.core)
            implementation(libs.kodein)
        }
    }
}

android {
    namespace = "org.example.multimodulesample.data"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

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