package Managers;

import android.Manifest;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;

import java.util.Arrays;

/**
 * Created by lafer on 05-12-16.
 */

public class CheckManager extends Activity {
    private Activity _activity;
    private static final int MY_PERMISSIONS_REQUEST_FINE_LOCATION = 1;
    private static final int MY_PERMISSIONS_REQUEST_COARSE_LOCATION = 2;
    private Boolean[] authorisations;

    public CheckManager(Activity activity) {
        _activity = activity;
        authorisations = new Boolean[2];
        Arrays.fill(authorisations, false);
    }

    public void askPermissions() {
        ActivityCompat.requestPermissions(_activity,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                MY_PERMISSIONS_REQUEST_FINE_LOCATION);

        /*ActivityCompat.requestPermissions(_activity,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                MY_PERMISSIONS_REQUEST_FINE_LOCATION);*/
        return;
    }


    public boolean hasPermissions() {
       /* if(ContextCompat.checkSelfPermission(_activity.getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PermissionChecker.PERMISSION_GRANTED)
            authorisations[0] = true;*/
        if(ContextCompat.checkSelfPermission(_activity.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PermissionChecker.PERMISSION_GRANTED)
            authorisations[1] = true;
        return (authorisations[1]);
    }
}

