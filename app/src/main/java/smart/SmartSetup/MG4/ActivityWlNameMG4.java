package smart.SmartSetup.MG4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MG4.Edit.ActivityEditWlNameMG4;
import smart.SmartSetup.R;

public class ActivityWlNameMG4 extends EnhancedActivity {
    public  static smart.SmartSetup.MG4.ActivityWlNameMG4 activityWlNameMG4;
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
    LinearLayout l1,l2,l3,l4;
    TextView nameoperator,desc;
    ImageView bluicon;
MediaPlayer mediaPlayer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mg4_activity_wl_name);
activityWlNameMG4 =this;
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

        l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);
        l3=(LinearLayout)findViewById(R.id.l3);
        l4=(LinearLayout)findViewById(R.id.l4);
        nameoperator=(TextView)findViewById(R.id.nameoperator);
        bluicon=(ImageView)findViewById(R.id.bluIcon);
        desc=(TextView)findViewById(R.id.descrip);
        ///......................................................................................
        ActivityMain main=new ActivityMain();


        main.SendBt("Wireles?");




        handler1 = new Handler();
        handler1.postDelayed(new Runnable(){
            public void run(){

                handler1.postDelayed(this, 500);



                if (G.connected==false){
                    bluicon.setImageResource(R.drawable.blutose_disable);


                }
                if (G.connected==true) {
                    bluicon.setImageResource(R.drawable.blutose_enable);
                }

                switch (ActivityMain.numAn){
                    case "0":
                        l1.setBackgroundColor(Color.GRAY);
                        l2.setBackgroundColor(Color.GRAY);
                        l3.setBackgroundColor(Color.GRAY);
                        l4.setBackgroundColor(Color.GRAY);


                        break;
                    case "1" :l1.setBackgroundColor(Color.GREEN);
                        l2.setBackgroundColor(Color.GRAY);
                        l3.setBackgroundColor(Color.GRAY);
                        l4.setBackgroundColor(Color.GRAY);

                        break;
                    case "2" :l1.setBackgroundColor(Color.GREEN);
                        l2.setBackgroundColor(Color.GREEN);
                        l3.setBackgroundColor(Color.GRAY);
                        l4.setBackgroundColor(Color.GRAY);


                        break;

                    case "3" :l1.setBackgroundColor(Color.GREEN);
                        l2.setBackgroundColor(Color.GREEN);
                        l3.setBackgroundColor(Color.GREEN);
                        l4.setBackgroundColor(Color.GRAY);


                        break;

                    case "4" :l1.setBackgroundColor(Color.GREEN);
                        l2.setBackgroundColor(Color.GREEN);
                        l3.setBackgroundColor(Color.GREEN);
                        l4.setBackgroundColor(Color.GREEN);


                        break;
                    default:
                        l1.setBackgroundColor(Color.GRAY);
                        l2.setBackgroundColor(Color.GRAY);
                        l3.setBackgroundColor(Color.GRAY);
                        l4.setBackgroundColor(Color.GRAY);


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


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        nameoperator.setText(ActivityMain.nameOperator);

                    }
                });
                desc.setText(ActivityMain.LCD);



            }
        }, 0);






        layWlName1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameMG4.class);
                intent.putExtra("WIRELES", "1");
                G.currentActivity.startActivity(intent);
            }
        });

        layWlName2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameMG4.class);
                intent.putExtra("WIRELES", "2");
                G.currentActivity.startActivity(intent);
            }
        });

        layWlName3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameMG4.class);
                intent.putExtra("WIRELES", "3");
                G.currentActivity.startActivity(intent);
            }
        });

        layWlName4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameMG4.class);
                intent.putExtra("WIRELES", "4");
                G.currentActivity.startActivity(intent);
            }
        });

        layWlName5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameMG4.class);
                intent.putExtra("WIRELES", "5");
                G.currentActivity.startActivity(intent);
            }
        });

        layWlName6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameMG4.class);
                intent.putExtra("WIRELES", "6");
                G.currentActivity.startActivity(intent);
            }
        });

        layWlName7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameMG4.class);
                intent.putExtra("WIRELES", "7");
                G.currentActivity.startActivity(intent);
            }
        });

        layWlName8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditWlNameMG4.class);
                intent.putExtra("WIRELES", "8");
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


    public void setbib(){
        if (mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bib);
        //  float log1 =((float)1/CONSTANT.SYSTEM_MAX_VOLUME) ;
        //mediaPlayer.setVolume(50f,50f);
        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0);
        mediaPlayer.start();


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


    @Override
    protected void onDestroy() {
        handler1.removeCallbacksAndMessages(null);
        finish();
        super.onDestroy();
    }
    @Override
    public void onBackPressed() {
        handler1.removeCallbacksAndMessages(null);
        startActivity(new Intent(G.currentActivity, Activity_List_MG4.class));
        finish();
        super.onBackPressed();
    }

}
