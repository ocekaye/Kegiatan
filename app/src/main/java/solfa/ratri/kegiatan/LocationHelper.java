package solfa.ratri.kegiatan;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by Hinata on 12/10/2016.
 */
public class LocationHelper {
    private static final String APP_LOCATION = "location";
    private static final String APP_LAT = "lat";
    private static final String APP_LONG = "long";
    public static final int LOCATION_REQUEST_CODE = 00045;
    public static void getLocation(Activity activity){
        if (ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            GPSTracker gps = new GPSTracker(activity);
            if(gps.canGetLocation()){
                SharedPreferences loginInfo = activity.getSharedPreferences(APP_LOCATION, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = loginInfo.edit();
                editor.putString(APP_LAT, ""+gps.getLatitude());
                editor.putString(APP_LONG, ""+gps.getLongitude());
                editor.commit();
            }else{
                gps.showSettingsAlert();
            }
        }else System.out.println("no permision");
    }

    public static void grantLocationPermition(Activity activity){
        if (ContextCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION)
                !=  PackageManager.PERMISSION_GRANTED){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        LOCATION_REQUEST_CODE);
            } else getLocation(activity);
        } else {
            getLocation(activity);
        }
    }

    public static String getLongLat(Activity activity){
        SharedPreferences loginInfo = activity.getSharedPreferences(APP_LOCATION, Context.MODE_PRIVATE);
        String longlat = loginInfo.getString(APP_LAT, "")+", "+loginInfo.getString(APP_LONG, "");
        return longlat;
    }
}
