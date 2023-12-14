package smart.SmartSetup.MGZ8;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.ArrayList;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MGZ8.Edit.ActivityEditTimeAlarmMGZ8;
import smart.SmartSetup.MGZ8.Edit.ActivityEditpanelSettingMGZ8;
import smart.SmartSetup.MG4.Edit.Edit_Panel_Zon24;
import smart.SmartSetup.R;

public class ActivityPanelMGZ8 extends EnhancedActivity {
public static ActivityPanelMGZ8 activityPanelMGZ8;

ArrayList<view_descip> view_descips=new ArrayList<>();


    ConstraintLayout layStart;
    ConstraintLayout    layExit;
    ConstraintLayout    layAlarm;
    ConstraintLayout layChrip;

    Handler handler1;
    LinearLayout l1,l2,l3,l4;
    TextView nameoperator,desc;
    ImageView bluicon;
MediaPlayer mediaPlayer;


    public  static TextView numDelayStart,numDelayExit,numDelayAlarm,numTakBib;
public  static SeekBar SeekBarTak,SeekBarExit,SeekBarStart,SeekBarAlarm;
ImageView iconSeekBar;
int seekBarProgressTak=0;
    ActivityMain main;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mgz8_activity_panel);
        activityPanelMGZ8 =this;

        SeekBarStart =   findViewById(R.id.SeekBarStart);
        SeekBarExit =   findViewById(R.id.SeekBarExit);
        SeekBarAlarm =   findViewById(R.id.SeekBarAlarm);
        SeekBarTak =   findViewById(R.id.SeekBarTak);
        numDelayStart =   findViewById(R.id.numDelayStart);
        numDelayExit =   findViewById(R.id.numDelayExit);
        numDelayAlarm =   findViewById(R.id.numDelayAlarm);
        numTakBib =   findViewById(R.id.numTakBib);



        iconSeekBar =   findViewById(R.id.iconSeekBar);

        layStart =  findViewById(R.id.layStart);
        layExit =   findViewById(R.id.layExit);
        layAlarm =   findViewById(R.id.layAlarm);
        layChrip =   findViewById(R.id.layChrip);

        l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);
        l3=(LinearLayout)findViewById(R.id.l3);
        l4=(LinearLayout)findViewById(R.id.l4);
        nameoperator=(TextView)findViewById(R.id.nameoperator);
        bluicon=(ImageView)findViewById(R.id.bluIcon);
        desc=(TextView)findViewById(R.id.descrip);
          main=new ActivityMain();
        main.SendBt("Setting?");
        ///......................................................................................


        iconSeekBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seekBarProgressTak != 0) {
                    main.SendBt("ChripTest," + seekBarProgressTak);
                }

            }
        });


        SeekBarTak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgressTak = progress;
                if (progress == 0){
                    iconSeekBar.setImageDrawable(getResources().getDrawable(R.drawable.mute));
                }else {
                    iconSeekBar.setImageDrawable(getResources().getDrawable(R.drawable.on_mute));

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });








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
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        nameoperator.setText(ActivityMain.nameOperator);

                    }
                });
                desc.setText(ActivityMain.LCD);



            }
        }, 0);






        layStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(G.currentActivity, ActivityEditpanelSettingMGZ8.class);
                intent.putExtra("ITEM", "تاخیر ورود:");
                intent.putExtra("progress", main.Panel[0]);
                // intent.putExtra("STU", (txtChrip.getText().toString()));
                G.currentActivity.startActivity(intent);
            }
        });

        ///......................................................................................

        layExit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(G.currentActivity, ActivityEditpanelSettingMGZ8.class);
                intent.putExtra("ITEM", "تاخیر خروج:");
                intent.putExtra("progress", main.Panel[1]);

                // intent.putExtra("STU", (txtChrip.getText().toString()));
                G.currentActivity.startActivity(intent);
            }
        });

        ///......................................................................................

        layAlarm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(G.currentActivity, ActivityEditpanelSettingMGZ8.class);
                intent.putExtra("ITEM", "مدت آژیر:");
                intent.putExtra("progress", main.Panel[2]);

                // intent.putExtra("STU", (txtChrip.getText().toString()));
                G.currentActivity.startActivity(intent);


            }
        });

        ///......................................................................................

        layChrip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditpanelSettingMGZ8.class);
                intent.putExtra("ITEM", "تک بوق:");
                intent.putExtra("progress", main.Panel[3]);

                // intent.putExtra("STU", (txtChrip.getText().toString()));
                G.currentActivity.startActivity(intent);
            }
        });
//
//        view_descips.add(new view_descip(layTaimAlarm,"توضیح"
//                ,"مدت زمان آژیر دستگاه را در این قسمت انتخاب کنید"));
//        view_descips.add(new view_descip(layPower,"توضیح"
//                ,"در صورت فعال کردن این گزینه در صورتی که برق شهر بیش از 4 ساعت قطع شود دستگاه آژیر میزند"));
//        view_descips.add(new view_descip(layZon24h,
//                "توضیح","در صورت فعال کردن این گزینه زون4 در حالت خاموش بودن دستگاه فعال خواهد بود" ));
//        view_descips.add(new view_descip(layChrip,
//                "توضیح","با فعال کردن این گزینه بلندگو های اصلی ،هنگام روشن و خاموش کردن دستگاه تک بوق میزنند"));
//
//        layTaimAlarm.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                setviewHelp(view_descips.get(0));
//                return true;
//            }
//        });
//
//        layPower.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                setviewHelp(view_descips.get(1));
//                return true;
//            }
//        });
//
//
//        layZon24h.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                setviewHelp(view_descips.get(2));
//                return true;
//            }
//        });
//
//
//        layChrip.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                setviewHelp(view_descips.get(3));
//                return true;
//            }
//        });



        notTouch(SeekBarAlarm);
        notTouch(SeekBarExit);
        notTouch(SeekBarStart);
        notTouch(SeekBarTak);


    }
    @SuppressLint("ClickableViewAccessibility")
    public void notTouch(SeekBar s){
        s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
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
    public void setviewHelp(view_descip  view_descip){
        TapTargetView.showFor(this,                 // `this` is an Activity
                TapTarget.forView(view_descip.getView(), view_descip.getTitle(), view_descip.getDesc())

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
        super.onBackPressed();
        handler1.removeCallbacksAndMessages(null);
        startActivity(new Intent(G.currentActivity, Activity_List_MGZ8.class));
        finish();

    }

}