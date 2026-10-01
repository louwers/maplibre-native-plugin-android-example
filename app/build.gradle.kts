plugins {
    id("com.android.application")
}

android {
    namespace = "org.maplibre.plugins.demo"
    compileSdk = 35

    defaultConfig {
        applicationId = "org.maplibre.plugins.demo"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(project(":ngon-layer"))
    implementation("org.maplibre.gl:android-sdk:${rootProject.extra["maplibreVersion"]}")
}
