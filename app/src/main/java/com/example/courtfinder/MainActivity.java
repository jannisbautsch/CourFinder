package com.example.courtfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;

    public class MainActivity extends AppCompatActivity {

        public final static String MAPBOX_TOKEN = "pk.eyJ1IjoiY291cnRmaW5kZXIiLCJhIjoiY2wzOHdyYWNzMDQ5aDNicjN4Y3R5dWUxbSJ9.0xzUWgVgW6Cv5HmTaPn4ZA";

        MapView mapView;
        MapboxMap map;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Mapbox.getInstance(this, MAPBOX_TOKEN);

            setContentView(R.layout.activity_main);
            initViews();
            initPermissions();
        }

        protected void initViews() {
            mapView = findViewById(R.id.map);

        }

        protected void initPermissions() {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                updateLocation();
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                }
            }
        }

        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (requestCode == 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                updateLocation();
            }
        }

        protected void updateLocation() {
            mapView.getMapAsync(this::onMapReady);
        }

        protected void onMapReady(MapboxMap map) {
            this.map = map;
            map.setStyle(Style.MAPBOX_STREETS, this::onMapStyleReady);
        }

        @SuppressLint("MissingPermission") // permissions are already checked in initPermissions
        protected void onMapStyleReady(Style style) {
            LocationComponent locationComponent = map.getLocationComponent();
            locationComponent.activateLocationComponent(LocationComponentActivationOptions.builder(this, style).build());
            locationComponent.setLocationComponentEnabled(true);
            locationComponent.setCameraMode(CameraMode.TRACKING);
            locationComponent.setRenderMode(RenderMode.COMPASS);

        }

        @Override
        protected void onStart() {
            super.onStart();
            mapView.onStart();
        }

        @Override
        protected void onResume() {
            super.onResume();
            mapView.onResume();
        }

        @Override
        protected void onPause() {
            super.onPause();
            mapView.onPause();
        }

        @Override
        protected void onStop() {
            super.onStop();
            mapView.onStop();
        }

        @Override
        protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            mapView.onSaveInstanceState(outState);
        }

        @Override
        public void onLowMemory() {
            super.onLowMemory();
            mapView.onLowMemory();
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            mapView.onDestroy();
        }
    }


