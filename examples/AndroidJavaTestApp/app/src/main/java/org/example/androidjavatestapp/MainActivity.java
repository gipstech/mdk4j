package org.example.androidjavatestapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.gipstech.mdk.GiPStech4j;
import com.gipstech.mdk.SpatialManager4j;
import com.gipstech.mdk.spatial.Place4j;

public class MainActivity extends AppCompatActivity {
    public static String DEV_KEY = ""; // Set your development key here
    public static String BUILDING_ID = ""; // Set your building ID here

    Place4j target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        PermissionHelper.checkPermissions(this, (isGranted) -> {
            if (isGranted) {
                new Thread(() -> {
                    boolean retValue = GiPStech4j.init(DEV_KEY, this);
                    Log.d("INIT", "INITED: " + retValue);

                    target = SpatialManager4j.requestBuilding(BUILDING_ID, true);
                    target.startLocalization(new MyLocationListener(target));
                }).start();
            } else {
                Toast.makeText(this, "This app requires all permissions", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (target != null) {
            target.stopLocalization();
        }
    }
}