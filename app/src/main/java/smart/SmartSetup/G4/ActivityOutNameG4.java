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

import smart.SmartSetup.G4.Edit.ActivityEditOutNameG4;
import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.BluetoothSPPConnection;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MG4.view_descip;
import smart.SmartSetup.R;

/**
 * Created by Roholah on 30/06/2017.
 */

public class ActivityOutNameG4 extends EnhancedActivity {
    public static ActivityOutNameG4 activityOutNameG4;
    static TextView textOutName1;
    static TextView textOutName2;
    static TextView textOutName3;
    static TextView textOutName4;
BluetoothSPPConnection mBluetoothSPPConnection;
    LinearLayout layOutName1;
    LinearLayout    layOutName2;
    LinearLayout    layOutName3;
    LinearLayout    layOutName4;
    ArrayList<view_descip> view_descips=new ArrayList<>();

    Handler handler1;
    ImageView blicnin;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.g4_activity_out_name);
        activityOutNameG4=this;

        textOutName1 = (TextView) findViewById(R.id.textOutName1);
        textOutName2 = (TextView) findViewById(R.id.textOutName2);
        textOutName3 = (TextView) findViewById(R.id.textOutName3);
        textOutName4 = (TextView) findViewById(R.id.textOutName4);

        layOutName1 = (LinearLayout) findViewById(R.id.layOutName1);
        layOutName2 = (LinearLayout) findViewById(R.id.layOutName2);
        layOutName3 = (LinearLayout) findViewById(R.id.layOutName3);
        layOutName4 = (LinearLayout) findViewById(R.id.layOutName4);
blicnin=(ImageView)findViewById(R.id.bluIcon);

        ///......................................................................................

        ActivityMain main=new ActivityMain();
        main.SendBt("Out?");




        handler1 = new Handler();
        handler1.postDelayed(new Runnable(){
            public void run(){

                handler1.postDelayed(this, 1000);
textOutName1.setText(ActivityMain.OutName[0]);
textOutName2.setText(ActivityMain.OutName[1]);
textOutName3.setText(ActivityMain.OutName[2]);
textOutName4.setText(ActivityMain.OutName[3]);


                if (G.connected == false) {
                    blicnin.setImageResource(R.drawable.blutose_disable);


                }
                if (G.connected == true) {
                    blicnin.setImageResource(R.drawable.blutose_enable);
                }




            }
        }, 0);






















        layOutName1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditOutNameG4.class);
                intent.putExtra("OUT", "1");
                setIntent(intent,textOutName1);
                G.currentActivity.startActivity(intent);
            }
        });

        layOutName2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditOutNameG4.class);
                intent.putExtra("OUT", "2");
                setIntent(intent,textOutName2);
                G.currentActivity.startActivity(intent);
            }
        });

        layOutName3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditOutNameG4.class);
                intent.putExtra("OUT", "3");
                setIntent(intent,textOutName3);
                G.currentActivity.startActivity(intent);
            }
        });

        layOutName4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditOutNameG4.class);
                intent.putExtra("OUT", "4");
                setIntent(intent,textOutName4);
                G.currentActivity.startActivity(intent);
            }
        });

        view_descips.add(new view_descip(layOutName1,"توضیح","نام دستگاهی که توسط خروجی مورد نظر کنترل  میشود را در اینجا وارد کنید\nحداکثر 10 حرف \nمثال:دربازکن"));
        view_descips.add(new view_descip(layOutName2,"توضیح","نام دستگاهی که توسط خروجی مورد نظر کنترل  میشود را در اینجا وارد کنید\nحداکثر 10 حرف \nمثال:پمپ آب"));
        view_descips.add(new view_descip(layOutName3,"توضیح","نام دستگاهی که توسط خروجی مورد نظر کنترل  میشود را در اینجا وارد کنید\nحداکثر 10 حرف \nمثال:فن"));
        view_descips.add(new view_descip(layOutName4,"توضیح","نام دستگاهی که توسط خروجی مورد نظر کنترل  میشود را در اینجا وارد کنید\nحداکثر 10 حرف \nمثال:لامپ"));
        layOutName1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(0));
                return true;
            }
        });

        layOutName2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(1));
                return true;
            }
        });


        layOutName3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(2));
                return true;
            }
        });


        layOutName4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(3));
                return true;
            }
        });


    }
    public void setviewHelp(view_descip view) {
        TapTargetView.showFor(this,                 // `this` is an Activity
                TapTarget.forView(view.getView(),view.getTitle() ,view.getDesc())
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

                        .tintTarget(true)
                        // Whether to tint the target view's color
                        .transparentTarget(true)// Specify whether the target is transparent (displays the content underneath)
                        // Specify a custom drawable to draw as the target
                        .targetRadius(30)// Specify the target radius (in dp)
                , new TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
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

    private void hellpOutNameDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(G.currentActivity);
        builder.setTitle("توضیح");
        builder.setMessage("نام دستگاهی که توسط خروجی مورد نظر کنترل  میشود را در اینجا وارد کنید." + "\n" + "(حداکثر 10 حرف)" + "\n" + "مثال: پمپ آب");
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
