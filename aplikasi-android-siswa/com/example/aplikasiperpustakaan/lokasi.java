package com.example.aplikasiperpustakaan;

import android.location.Location;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class lokasi extends AppCompatActivity {
    private FusedLocationProviderClient locationProviderClient;
    WebView webviewlokasi;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_lokasi);
        this.webviewlokasi = (WebView) findViewById(R.id.webviewpetalokasi);
        this.locationProviderClient = LocationServices.getFusedLocationProviderClient(getApplicationContext());
        getLocation();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != 10) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            getLocation();
        } else {
            Toast.makeText(getApplicationContext(), "Izin Lokasi Tidak Di Izinkan", 0).show();
        }
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.locationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                public void onSuccess(Location location) {
                    if (location != null) {
                        String latit = String.valueOf(location.getLatitude());
                        String longit = String.valueOf(location.getLongitude());
                        lokasi.this.webviewlokasi.setWebChromeClient(new WebChromeClient());
                        lokasi.this.webviewlokasi.getSettings().setJavaScriptEnabled(true);
                        lokasi.this.webviewlokasi.loadUrl("https://www.google.com/maps?saddr=" + latit + "," + longit + "&daddr=" + Informasiwisata.lat + "," + Informasiwisata.longi);
                        return;
                    }
                    Toast.makeText(lokasi.this.getApplicationContext(), "Lokasi Tidak Aktif", 0).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception e) {
                    Toast.makeText(lokasi.this.getApplicationContext(), e.getLocalizedMessage(), 0).show();
                }
            });
        } else {
            requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 10);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        Informasiwisata.lat = "";
        Informasiwisata.longi = "";
    }
}
