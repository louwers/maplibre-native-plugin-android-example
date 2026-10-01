package org.maplibre.plugins.ngon

object NgonLayer {
    init {
        // Registered callbacks live for the process lifetime. Keep this library loaded.
        System.loadLibrary("ngon-plugin")
    }

    /** Call after MapLibre.getInstance() and before loading a style with type "ngon". */
    @JvmStatic
    fun register() {
        // This published android-sdk uses Vulkan and loads its host as libmaplibre.so.
        registerNative("libmaplibre.so")
    }

    @JvmStatic
    private external fun registerNative(libraryName: String)
}
