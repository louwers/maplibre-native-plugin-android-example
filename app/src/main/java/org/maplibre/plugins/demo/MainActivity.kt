package org.maplibre.plugins.demo

import android.app.Activity
import android.os.Bundle
import android.util.Log
import org.maplibre.android.MapLibre
import org.maplibre.android.camera.CameraUpdateFactory
import org.maplibre.android.geometry.LatLng
import org.maplibre.android.maps.MapView
import org.maplibre.android.maps.Style
import org.maplibre.plugins.ngon.NgonLayer

class MainActivity : Activity() {
    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapLibre.getInstance(this)
        NgonLayer.register()

        mapView = MapView(this)
        setContentView(mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync { map ->
            if (savedInstanceState == null) {
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(0.0, 0.0), 11.3))
            }
            // Plugin layers currently use style JSON rather than a Java Layer peer.
            map.setStyle(Style.Builder().fromUri("asset://ngon.json")) {
                Log.i("PluginDemo", "Published SDK loaded the ngon plugin style")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        mapView.onPause()
        super.onPause()
    }

    override fun onStop() {
        mapView.onStop()
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        mapView.onDestroy()
        super.onDestroy()
    }
}
