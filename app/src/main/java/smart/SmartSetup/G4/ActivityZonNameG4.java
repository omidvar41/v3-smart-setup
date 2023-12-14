package smart.SmartSetup.G4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.ArrayList;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.G4.Edit.ActivityEditZonNameG4;
import smart.SmartSetup.MG4.view_descip;
import smart.SmartSetup.R;

/**
 * Created by Roholah on 30/06/2017.
 */

public class ActivityZonNameG4 extends EnhancedActivity {
    public  static ActivityZonNameG4 activityZonNameG4;
    static TextView txtZon1;
    static TextView txtZon2;
    static TextView txtZon3;
    static TextView txtZon4;

    LinearLayout layZon1;
    LinearLayout    layZon2;
    LinearLayout    layZon3;
    LinearLayout    layZon4;
    ArrayList<view_descip> view_descips=new ArrayList<>();

    Handler handler1;
    ImageView blicon;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g4_activity_zon_name);
activityZonNameG4=this;
        txtZon1 = (TextView) findViewById(R.id.txtZon1);
        txtZon2 = (TextView) findViewById(R.id.txtZon2);
        txtZon3 = (TextView) findViewById(R.id.txtZon3);
        txtZon4 = (TextView) findViewById(R.id.txtZon4);

        layZon1 = (LinearLayout) findViewById(R.id.layZon1);
        layZon2 = (LinearLayout) findViewById(R.id.layZon2);
        layZon3 = (LinearLayout) findViewById(R.id.layZon3);
        layZon4 = (LinearLayout) findViewById(R.id.layZon4);

        blicon=(ImageView)findViewById(R.id.bluIcon);

        ActivityMain main=new ActivityMain();
        /*
        ActivityMain.ZonName[0]="";
        ActivityMain.ZonName[1]="";
        ActivityMain.ZonName[2]="";
        ActivityMain.ZonName[3]="";
        */
        main.SendBt("Zon?");






        handler1 = new Handler();
        handler1.postDelayed(new Runnable(){
            public void run(){

                handler1.postDelayed(this, 1000);

                if (G.connected == false) {
                    blicon.setImageResource(R.drawable.blutose_disable);


                }
                if (G.connected == true) {
                    blicon.setImageResource(R.drawable.blutose_enable);
                }



                txtZon1.setText(ActivityMain.ZonName[0]);
                txtZon2.setText(ActivityMain.ZonName[1]);
                txtZon3.setText(ActivityMain.ZonName[2]);
                txtZon4.setText(ActivityMain.ZonName[3]);



            }
        }, 0);





        layZon1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditZonNameG4.class);
                intent.putExtra("ZON", "1");
                setIntent(intent,txtZon1);
                G.currentActivity.startActivity(intent);
            }
        });

        layZon2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditZonNameG4.class);
                intent.putExtra("ZON", "2");
                setIntent(intent,txtZon2);
                G.currentActivity.startActivity(intent);
            }
        });

        layZon3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditZonNameG4.class);
                intent.putExtra("ZON", "3");
                setIntent(intent,txtZon3);
                G.currentActivity.startActivity(intent);
            }
        });

        layZon4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditZonNameG4.class);
                intent.putExtra("ZON", "4");
                setIntent(intent,txtZon4);
                G.currentActivity.startActivity(intent);
            }
        });






        layZon1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layZon1);
                return true;
            }
        });

        layZon2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layZon2);
                return true;
            }
        });


        layZon3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layZon3);
                return true;
            }
        });


        layZon4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layZon4);
                return true;
            }
        });



    }

    public void setviewHelp(View view){
        TapTargetView.showFor(this,                 // `this` is an Activity
                TapTarget.forView(view, "توضیح","نام محل نصب زون مربوطه را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:درب سالن")

                        // All options below are optional
                        .outerCircleColor(R.color.blue)      // Specify a color for the outer circle
                        .outerCircleAlpha(0.96f)            // Specify the alpha amount for the outer circle
                        .targetCircleColor(R.color.white)   // Specify a color for the target circle
                        .titleTextSize(20)                  // Specify the size (in sp) of the title text
                        .titleTextColor(R.color.white)      // Specify the color of the title text
                        .descriptionTextSize(15)            // Specify the size (in sp) of the description text
                        .descriptionTextColor(R.color.red)  // Specify the color of the description text
                        .textColor(R.color.black)            // Specify a color for both the title and description text
                        .textTypeface(Typeface.SANS_SERIF)  // Specify a typeface for the text
                        .dimColor(R.color.black)// If set, will dim behind the view with 30% opacity of the given color
                        .drawShadow(true)               // Whether to draw a drop shadow or not
                        .cancelable(true)                  // Whether tapping outside the outer circle dismisses the view

                        .tintTarget(true)                   // Whether to tint the target view's color
                        .transparentTarget(true)           // Specify whether the target is transparent (displays the content underneath)
                        // Specify a custom drawable to draw as the target
                        .targetRadius(30)// Specify the target radius (in dp)
                ,  new TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
                    @Override
                    public void onTargetClick(TapTargetView view) {
                        super.onTargetClick(view);      // This call is optional





                    }



                });
    }
    public void setIntent(Intent intent,TextView textView){
        if (!textView.getText().toString().equals("Empty")) {
            intent.putExtra("desc", textView.getText().toString());
        }

    }
    private void hellpZonNameDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(G.currentActivity);
        builder.setTitle("توضیح");
        builder.setMessage("نام محل نصب زون مربوطه را اینجا وارد کنید" + "\n" + "(حداکثر 10 حرف)" + "\n" + "مثال: درب سالن");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }

    @Override
    protected void onDestroy() {
        handler1.removeCallbacksAndMessages(null);
        finish();
        super.onDestroy();
    }
    @Override
    public void onBackPressed() {
        handler1.removeCallbacksAndMessages(null);
        finish();
        super.onBackPressed();
    }
}
