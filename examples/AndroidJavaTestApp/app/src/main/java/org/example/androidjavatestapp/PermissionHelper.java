package org.example.androidjavatestapp;

import android.content.pm.PackageManager;
import android.os.Build;

import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;

import java.util.ArrayList;

public class PermissionHelper {
    private static ActivityResultLauncher<String> requestPermissionLauncher;

    public static void checkPermissions(ComponentActivity activity, Consumer<Boolean> completed) {
        ArrayList<String> permissions = getPermissions();

        Runnable checkNext = () -> {
            boolean done = true;
            while (!permissions.isEmpty()) {
                String permission = permissions.remove(0);
                if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissionLauncher.launch(permission);
                    done = false;
                    break;
                }
            }
            if (done) {
                completed.accept(true);
            }
        };

        requestPermissionLauncher = activity.registerForActivityResult(
                new ActivityResultContracts.RequestPermission(),
                isGranted -> {
                    if (isGranted) {
                        checkNext.run();
                    } else {
                        completed.accept(false);
                    }
                }
        );

        // Start permission checking
        checkNext.run();
    }

    private static ArrayList<String> getPermissions()  {
        ArrayList<String> permissions = new ArrayList<>();

        permissions.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(android.Manifest.permission.ACCESS_COARSE_LOCATION);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) { //31
            permissions.add(android.Manifest.permission.BLUETOOTH_SCAN);
        } else {
            permissions.add(android.Manifest.permission.BLUETOOTH);
            permissions.add(android.Manifest.permission.BLUETOOTH_ADMIN);
        }

        return permissions;
    }
}