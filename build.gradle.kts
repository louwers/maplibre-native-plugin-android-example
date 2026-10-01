plugins {
    id("com.android.application") version "9.1.1" apply false
    id("com.android.library") version "9.1.1" apply false
}

// The same published SDK supplies the app runtime and the plugin's Prefab C header.
extra["maplibreVersion"] = "13.6.1-pre935d410353da9d701ad42c97f2e0c300c8d408b8"
