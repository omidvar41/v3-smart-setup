package smart.SmartSetup.MG4;

import android.content.Context;
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

import java.util.ArrayList;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MG4.Edit.ActivityEditTimeAlarmMG4;
import smart.SmartSetup.MG4.Edit.ActivityEditpanelSettingMG4;
import smart.SmartSetup.MG4.Edit.Edit_Panel_Zon24;
import smart.SmartSetup.R;

public class ActivityPanelMG4 extends EnhancedActivity {
public static smart.SmartSetup.MG4.ActivityPanelMG4 activityPanelMG4;
    static TextView txtTaimAlarm;
    static TextView txtPower;
    static TextView txtZon24h;
    static TextView txtChrip;
    static TextView txtDingDang;
ArrayList<view_descip> view_descips=new ArrayList<>();
    LinearLayout layTaimAlarm;
    LinearLayout    layPower;
    LinearLayout    layZon24h;
    LinearLayout    layChrip;
    Handler handler1;
    LinearLayout l1,l2,l3,l4;
    TextView nameoperator,desc;
    ImageView bluicon;
MediaPlayer mediaPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mg4_activity_panel);
        activityPanelMG4 =this;
        txtTaimAlarm = (TextView) findViewById(R.id.txtTaimAlarm);
        txtPower = (TextView) findViewById(R.id.txtPower);
        txtZon24h = (TextView) findViewById(R.id.txtZon24h);
        txtChrip = (TextView) findViewById(R.id.txtChrip);

        layTaimAlarm = (LinearLayout) findViewById(R.id.layTaimAlarm);
        layPower = (LinearLayout) findViewById(R.id.layPower);
        layZon24h = (LinearLayout) findViewById(R.id.layZon24h);
        layChrip = (LinearLayout) findViewById(R.id.layChrip);

        l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);
        l3=(LinearLayout)findViewById(R.id.l3);
        l4=(LinearLayout)findViewById(R.id.l4);
        nameoperator=(TextView)findViewById(R.id.nameoperator);
        bluicon=(ImageView)findViewById(R.id.bluIcon);
        desc=(TextView)findViewById(R.id.descrip);
        ActivityMain main=new ActivityMain();
        main.SendBt("forPANEL,setting?");
        ///......................................................................................




        handler1 = new Handler();
        handler1.postDelayed(new Runnable(){
            public void run(){

                handler1.postDelayed(this, 500);
       txtTaimAlarm.setText(ActivityMain.Panel[0]);
       txtChrip.setText(ActivityMain.Panel[3]);
       txtPower.setText(ActivityMain.Panel[1]);
       txtZon24h.setText(ActivityMain.Panel[2]);

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






        layTaimAlarm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditTimeAlarmMG4.class);
                //  intent.putExtra("ZON", "1");
                G.currentActivity.startActivity(intent);
            }
        });

        ///......................................................................................

        layPower.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditpanelSettingMG4.class);
                intent.putExtra("ITEM", "هشدار قطع برق:");
                intent.putExtra("STU", (txtPower.getText().toString()));
                G.currentActivity.startActivity(intent);
            }
        });

        ///......................................................................................

        layZon24h.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                String name=txtZon24h.getText().toString();
                String code="" ;
                Intent intent = new Intent(G.currentActivity, Edit_Panel_Zon24.class);
               switch (name){
                   case "فعال":
                       code="1";
                       break;
                   case "غیر فعال":
                       code="3";
                       break;
                   case "فعال دو مرحله ای":
                       code="2";
                       break;
                       default:
                           break;
               }
                intent.putExtra("code",code);
                G.currentActivity.startActivity(intent);
            }
        });

        ///......................................................................................

        layChrip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditpanelSettingMG4.class);
                intent.putExtra("ITEM", "تک بوق:");
                intent.putExtra("STU", (txtChrip.getText().toString()));
                G.currentActivity.startActivity(intent);
            }
        });

        view_descips.add(new view_descip(layTaimAlarm,"توضیح"
                ,"مدت زمان آژیر دستگاه را در این قسمت انتخاب کنید"));
        view_descips.add(new view_descip(layPower,"توضیح"
                ,"در صورت فعال کردن این گزینه در صورتی که برق شهر بیش از 4 ساعت قطع شود دستگاه آژیر میزند"));
        view_descips.add(new view_descip(layZon24h,
                "توضیح","در صورت فعال کردن این گزینه زون4 در حالت خاموش بودن دستگاه فعال خواهد بود" ));
        view_descips.add(new view_descip(layChrip,
                "توضیح","با فعال کردن این گزینه بلندگو های اصلی ،هنگام روشن و خاموش کردن دستگاه تک بوق میزنند"));

        layTaimAlarm.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(0));
                return true;
            }
        });

        layPower.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(1));
                return true;
            }
        });


        layZon24h.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(2));
                return true;
            }
        });


        layChrip.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(3));
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
        startActivity(new Intent(G.currentActivity, Activity_List_MG4.class));
        finish();

    }

}