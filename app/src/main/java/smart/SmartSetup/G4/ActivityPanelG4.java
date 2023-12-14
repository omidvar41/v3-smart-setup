package smart.SmartSetup.G4;

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

import smart.SmartSetup.G4.Edit.ActivityEditPanelSettingG4;
import smart.SmartSetup.G4.Edit.ActivityEditTaimAlarmG4;
import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MG4.view_descip;
import smart.SmartSetup.R;

/**
 * Created by Roholah on 30/06/2017.
 */

public class ActivityPanelG4 extends EnhancedActivity {
    static TextView txtTaimAlarm;
    static TextView txtPower;
    static TextView txtZon24h;
    static TextView txtChrip;
    static TextView txtDingDang;

    LinearLayout layTaimAlarm;
    LinearLayout    layPower;
    LinearLayout    layZon24h;
    LinearLayout    layChrip;
   Handler handler1;
    ArrayList<view_descip> view_descips=new ArrayList<>();
    ImageView bluicnin;

    public static ActivityPanelG4 activityPanelG4;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.g4_activity_panel);
activityPanelG4=this;
bluicnin=(ImageView)findViewById(R.id.bluIcon);
        txtTaimAlarm = (TextView) findViewById(R.id.txtTaimAlarm);
        txtPower = (TextView) findViewById(R.id.txtPower);
        txtZon24h = (TextView) findViewById(R.id.txtZon24h);
        txtChrip = (TextView) findViewById(R.id.txtChrip);

        layTaimAlarm = (LinearLayout) findViewById(R.id.layTaimAlarm);
        layPower = (LinearLayout) findViewById(R.id.layPower);
        layZon24h = (LinearLayout) findViewById(R.id.layZon24h);
        layChrip = (LinearLayout) findViewById(R.id.layChrip);
        ActivityMain main=new ActivityMain();
        main.SendBt("forPANEL,setting?");



        handler1 = new Handler();
        handler1.postDelayed(new Runnable(){
            public void run(){

                handler1.postDelayed(this, 1000);

                if (G.connected == false) {
                    bluicnin.setImageResource(R.drawable.blutose_disable);


                }
                if (G.connected == true) {
                    bluicnin.setImageResource(R.drawable.blutose_enable);
                }



                txtTaimAlarm.setText(ActivityMain.Panel[0]);
                txtChrip.setText(ActivityMain.Panel[3]);
                txtPower.setText(ActivityMain.Panel[1]);
                txtZon24h.setText(ActivityMain.Panel[2]);



            }
        }, 0);











        ///......................................................................................

        layTaimAlarm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditTaimAlarmG4.class);
                //  intent.putExtra("ZON", "1");
                G.currentActivity.startActivity(intent);
            }
        });

        ///......................................................................................

        layPower.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditPanelSettingG4.class);
                intent.putExtra("ITEM", "هشدار قطع برق:");
                intent.putExtra("STU", (txtPower.getText().toString()));
                G.currentActivity.startActivity(intent);
            }
        });

        ///......................................................................................

        layZon24h.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditPanelSettingG4.class);
                intent.putExtra("ITEM", "زون 24 ساعته:");
                intent.putExtra("STU", (txtZon24h.getText().toString()));
                G.currentActivity.startActivity(intent);
            }
        });

        ///......................................................................................

        layChrip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditPanelSettingG4.class);
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
            handler1.removeCallbacksAndMessages(null);
            finish();
            super.onBackPressed();
    }
}
