package smart.SmartSetup;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;


import org.json.JSONObject;

import smart.SmartSetup.MGZ8.ActivityRemoteNameMGZ8;


/**
 * Created by Roholah on 30/06/2017.
 */

public class G extends Application {
    public static Context context;
    public static int ResultCodeDefaultNameDevice = -10;
    public static Typeface type  ;
    public static Activity currentActivity;

    public static String         currentClassName;
    public static String         versionNameMainSoftWareDevice = "1";
    public static String         versionNameSubSoftWareDevice = "1";
    public static String         versionNameMainHardWareDevice = "1";
    public static String         versionNameSubHardWareDevice = "1";
    public static int            screenWidth  = 320;
    public static int            screenHeight = 480;
    public static DisplayMetrics displayMetrics;
    public static LayoutInflater inflater;

    public static boolean        connected    = false;
    public static String         btAdres;
    public static String         N_Pass       = "1234";
    public static String         Pass;

    @Override
    public void onCreate() {
        super.onCreate();




  context=getApplicationContext();

          type = Typeface.createFromAsset(getAssets(),"iran_yekan_bold.ttf");


        inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        SharedPreferences shared=getSharedPreferences("Prefs",MODE_PRIVATE);
        SharedPreferences.Editor editor=shared.edit();
                    btAdres=(shared.getString("strBtAdres",""));


    }
}
