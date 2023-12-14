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

import smart.SmartSetup.G4.Edit.ActivityEditWlNameG4;
import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.R;

/**
 * Created by Roholah on 30/06/2017.
 */

public class ActivityWlNameG4 extends EnhancedActivity {
    public  static ActivityWlNameG4 activityWlNameG4;

    ImageView bluicon;
    static TextView txtWlName1;
    static TextView     txtWlName2;
    static TextView     txtWlName3;
    static TextView     txtWlName4;
    static TextView     txtWlName5;
    static TextView     txtWlName6;
    static TextView     txtWlName7;
    static TextView     txtWlName8;

    static LinearLayout layWlName1;
    static LinearLayout layWlName2;
    static LinearLayout layWlName3;
    static LinearLayout layWlName4;
    static LinearLayout layWlName5;
    static LinearLayout layWlName6;
    static LinearLayout layWlName7;
    static LinearLayout layWlName8;

Handler handler1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.g4_activity_wl_name);
        bluicon=(ImageView)findViewById(R.id.bluIcon);
activityWlNameG4=this;
        txtWlName1 = (TextView) findViewById(R.id.txtWlName1);
        txtWlName2 = (TextView) findViewById(R.id.txtWlName2);
        txtWlName3 = (TextView) findViewById(R.id.txtWlName3);
        txtWlName4 = (TextView) findViewById(R.id.txtWlName4);
        txtWlName5 = (TextView) findViewById(R.id.txtWlName5);
        txtWlName6 = (TextView) findViewById(R.id.txtWlName6);
        txtWlName7 = (TextView) findViewById(R.id.txtWlName7);
        txtWlName8 = (TextView) findViewById(R.id.txtWlName8);

        layWlName1 = (LinearLayout) findViewById(R.id.layWlName1);
        layWlName2 = (LinearLayout) findViewById(R.id.layWlName2);
        layWlName3 = (LinearLayout) findViewById(R.id.layWlName3);
        layWlName4 = (LinearLayout) findViewById(R.id.layWlName4);
        layWlName5 = (LinearLayout) findViewById(R.id.layWlName5);
        layWlName6 = (LinearLayout) findViewById(R.id.layWlName6);
        layWlName7 = (LinearLayout) findViewById(R.id.layWlName7);
        layWlName8 = (LinearLayout) findViewById(R.id.layWlName8);

        ///......................................................................................
        ActivityMain main=new ActivityMain();
        for (int i=0;i<ActivityMain.Wireles.length;i++){
            ActivityMain.Wireles[i]="";
        }

                main.SendBt("Wireles?");


        handler1 = new Handler();
        handler1.postDelayed(new Runnable(){
            public void run(){

                handler1.postDelayed(this, 1000);

                if (G.connected == false) {
                    bluicon.setImageResource(R.drawable.blutose_disable);


                }
                if (G.connected == true) {
                    bluicon.setImageResource(R.drawable.blutose_enable);
                }


                switch (ActivityMain.Wireles[9]) {
            case "8":
                 layWlName8.setVisibility(View.VISIBLE);
               txtWlName8.setText(ActivityMain.Wireles[8]);
            case "7":
                layWlName7.setVisibility(View.VISIBLE);
                txtWlName7.setText(ActivityMain.Wireles[7]);
            case "6":
                layWlName6.setVisibility(View.VISIBLE);
                txtWlName6.setText(ActivityMain.Wireles[6]);
            case "5":
                layWlName5.setVisibility(View.VISIBLE);
                txtWlName5.setText(ActivityMain.Wireles[5]);
            case "4":
                layWlName4.setVisibility(View.VISIBLE);
                txtWlName4.setText(ActivityMain.Wireles[4]);
            case "3":
                layWlName3.setVisibility(View.VISIBLE);
                txtWlName3.setText(ActivityMain.Wireles[3]);
            case "2":
                layWlName2.setVisibility(View.VISIBLE);
                txtWlName2.setText(ActivityMain.Wireles[2]);
            case "1":
                layWlName1.setVisibility(View.VISIBLE);
                txtWlName1.setText(ActivityMain.Wireles[1]);
        }


            }
        }, 0);




        layWlName1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameG4.class);
                intent.putExtra("WIRELES", "1");
                setIntent(intent,txtWlName1);
                G.currentActivity.startActivity(intent);
            }
        });

        layWlName2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameG4.class);
                intent.putExtra("WIRELES", "2");
                setIntent(intent,txtWlName2);
                G.currentActivity.startActivity(intent);
            }
        });

        layWlName3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameG4.class);
                intent.putExtra("WIRELES", "3");
                setIntent(intent,txtWlName3);
                G.currentActivity.startActivity(intent);
            }
        });

        layWlName4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameG4.class);
                intent.putExtra("WIRELES", "4");
                setIntent(intent,txtWlName4);
                G.currentActivity.startActivity(intent);
            }
        });

        layWlName5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameG4.class);
                intent.putExtra("WIRELES", "5");
                setIntent(intent,txtWlName5);
                G.currentActivity.startActivity(intent);
            }
        });

        layWlName6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameG4.class);
                intent.putExtra("WIRELES", "6");
                setIntent(intent,txtWlName6);
                G.currentActivity.startActivity(intent);
            }
        });

        layWlName7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameG4.class);
                intent.putExtra("WIRELES", "7");
                setIntent(intent,txtWlName7);
                G.currentActivity.startActivity(intent);
            }
        });

        layWlName8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameG4.class);
                intent.putExtra("WIRELES", "8");
                setIntent(intent,txtWlName8);
                G.currentActivity.startActivity(intent);
            }
        });


        layWlName1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layWlName1);
                return true;
            }
        });

        layWlName2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layWlName2);
                return true;
            }
        });

        layWlName3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layWlName3);
                return true;
            }
        });

        layWlName4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layWlName4);
                return true;
            }
        });


        layWlName5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layWlName5);
                return true;
            }
        });


        layWlName6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layWlName6);
                return true;
            }
        });

        layWlName7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layWlName7);
                return true;
            }
        });

        layWlName8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layWlName8);
                return true;
            }
        });






    }
    public void setviewHelp(View view){
        TapTargetView.showFor(this,                 // `this` is an Activity
                TapTarget.forView(view, "توضیح","نام محل نصب سنسور بی سیم مربوطه را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:پارکینگ")

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
    private void hellpWlNameDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(G.currentActivity);
        builder.setTitle("توضیح");
        builder.setMessage("نام محل نصب سنسور بی سیم مربوطه را اینجا وارد کنید." + "\n" + "(حداکثر 10 حرف)" + "\n" + "مثال: پارکینگ");
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
