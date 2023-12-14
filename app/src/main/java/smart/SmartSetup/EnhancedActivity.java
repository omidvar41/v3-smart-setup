package smart.SmartSetup;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.util.DisplayMetrics;

/**
 * Created by Roholah on 30/06/2017.
 */

public class EnhancedActivity extends Activity {
    public final int MY_REQUEST_CODE = 1;



    private void chackMyPermistion() {
        if (ContextCompat.checkSelfPermission(EnhancedActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(EnhancedActivity.this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION
                            }, MY_REQUEST_CODE);


        } else if (ContextCompat.checkSelfPermission(EnhancedActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(EnhancedActivity.this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION
                            }, MY_REQUEST_CODE);


        }
        else if (ContextCompat.checkSelfPermission(EnhancedActivity.this,
                Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                ActivityCompat.requestPermissions(EnhancedActivity.this,
                        new String[]{Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT
                                }, MY_REQUEST_CODE);
            }


        }    else if (ContextCompat.checkSelfPermission(EnhancedActivity.this,
                Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                ActivityCompat.requestPermissions(EnhancedActivity.this,
                        new String[]{Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT
                        }, MY_REQUEST_CODE);
            }


        }
        else {

            G.currentClassName = getClass().getSimpleName();
            G.displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(G.displayMetrics);
            G.screenWidth = G.displayMetrics.widthPixels;
            G.screenHeight = G.displayMetrics.heightPixels;

            //our code

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_REQUEST_CODE:
                if (grantResults.length >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED
                       ) {

                } else {

                    //our code
                    G.currentClassName = getClass().getSimpleName();
                    G.displayMetrics = new DisplayMetrics();
                    getWindowManager().getDefaultDisplay().getMetrics(G.displayMetrics);
                    G.screenWidth = G.displayMetrics.widthPixels;
                    G.screenHeight = G.displayMetrics.heightPixels;

                break;
            }
            default:


                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        G.currentActivity=this;
        G.currentClassName=getClass().getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT>=23){
            chackMyPermistion();


        }else{

        }

        G.currentClassName = getClass().getSimpleName();
        G.displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(G.displayMetrics);
        G.screenWidth = G.displayMetrics.widthPixels;
        G.screenHeight = G.displayMetrics.heightPixels;
        //our code
    }
    }

