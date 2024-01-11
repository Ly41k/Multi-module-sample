plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinMultiplatform)
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

            implementation(projects.common.core)
            implementation(projects.common.splash.compose)
            implementation(projects.common.feature.compose)
            implementation(projects.common.feature.data)
            implementation(projects.common.feature.domain)

            implementation(libs.odyssey.core)
            implementation(libs.odyssey.compose)
        }
    }
}

android {
    namespace = "org.example.multimodulesample.umbrella"
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
