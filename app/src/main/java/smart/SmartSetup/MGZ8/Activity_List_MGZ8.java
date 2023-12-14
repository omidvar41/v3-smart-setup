package smart.SmartSetup.MGZ8;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.ArrayList;

import info.hoang8f.widget.FButton;
import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.G;
import smart.SmartSetup.R;



public class Activity_List_MGZ8 extends AppCompatActivity {
    public static Activity_List_MGZ8 activity_list_MGZ8;
    LinearLayout l1, l2, l3, l4;
    Handler handler1;
    MediaPlayer mediaPlayer;
    ActivityMain main;
    int NUMBER_ELEMENT_VIEW = 1;
    private FButton remot_name, access, zon_name, wl_name, out_name, charge,tak, pasword, goAbout;
    TextView nameoperator, desc;
    ImageView bluicon;
    boolean flag;
    ArrayList<view_descip> view_descips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mgz8_activity_list);
        ActivityMain.go_list.setVisibility(View.VISIBLE);

        activity_list_MGZ8 = this;





        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);
        l3 = (LinearLayout) findViewById(R.id.l3);
        l4 = (LinearLayout) findViewById(R.id.l4);
        nameoperator = (TextView) findViewById(R.id.nameoperator);
        bluicon = (ImageView) findViewById(R.id.bluIcon);
        desc = (TextView) findViewById(R.id.descrip);

        main = new ActivityMain();


        goAbout = (FButton) findViewById(R.id.goAbout);
        goAbout.setButtonColor(getResources().getColor(R.color.white));


        goAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   main.SendBt("AutoDialer?");

                startActivity(new Intent(Activity_List_MGZ8.this, About_System.class));
                finish();
            }
        });


        handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            public void run() {
                handler1.postDelayed(this, 500);


                desc.setText(ActivityMain.LCD);

                nameoperator.setText(ActivityMain.nameOperator);

                switch (ActivityMain.numAn) {
                    case "0":
                        l1.setBackgroundColor(Color.GRAY);
                        l2.setBackgroundColor(Color.GRAY);
                        l3.setBackgroundColor(Color.GRAY);
                        l4.setBackgroundColor(Color.GRAY);
                        //numAn="0";

                        break;
                    case "1":
                        l1.setBackgroundColor(Color.GREEN);
                        l2.setBackgroundColor(Color.GRAY);
                        l3.setBackgroundColor(Color.GRAY);
                        l4.setBackgroundColor(Color.GRAY);
                        //numAn="0";
                        break;
                    case "2":
                        l1.setBackgroundColor(Color.GREEN);
                        l2.setBackgroundColor(Color.GREEN);
                        l3.setBackgroundColor(Color.GRAY);
                        l4.setBackgroundColor(Color.GRAY);
                        //numAn="0";

                        break;

                    case "3":
                        l1.setBackgroundColor(Color.GREEN);
                        l2.setBackgroundColor(Color.GREEN);
                        l3.setBackgroundColor(Color.GREEN);
                        l4.setBackgroundColor(Color.GRAY);
                        //numAn="0";

                        break;

                    case "4":
                        l1.setBackgroundColor(Color.GREEN);
                        l2.setBackgroundColor(Color.GREEN);
                        l3.setBackgroundColor(Color.GREEN);
                        l4.setBackgroundColor(Color.GREEN);
                        //numAn="0";

                        break;
                    default:
                        l1.setBackgroundColor(Color.GRAY);
                        l2.setBackgroundColor(Color.GRAY);
                        l3.setBackgroundColor(Color.GRAY);
                        l4.setBackgroundColor(Color.GRAY);
                        //   numAn="0";

                }


                if (G.connected == false) {
                    bluicon.setImageResource(R.drawable.blutose_disable);


                }
                if (G.connected == true) {
                    bluicon.setImageResource(R.drawable.blutose_enable);
                }


            }


        }, 0);

/*
   handler = new Handler();
        handler.postDelayed(new Runnable(){
            public void run(){
                handler.postDelayed(this, 5000);
if (ActivityMain.flagGO.equals("0")) {
    main.SendBt("CSQ");
}

            }
        }, 1000);

*/
        ///////////////////////////////


        access = (FButton) findViewById(R.id.access);
        access.setButtonColor(getResources().getColor(R.color.white));
        access.setSoundEffectsEnabled(true);
        access.playSoundEffect(SoundEffectConstants.CLICK);

        access.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //setbib();
                Intent intent = new Intent(G.currentActivity, ActivitySmsNumberMGZ8.class);
                G.currentActivity.startActivity(intent);
                finish();
            }
        });


        out_name = (FButton) findViewById(R.id.out_name);
        out_name.setButtonColor(getResources().getColor(R.color.white));

        out_name.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent intent = new Intent(G.currentActivity, ActivityOutNameMGZ8.class);
                G.currentActivity.startActivity(intent);
                finish();

            }
        });


        charge = (FButton) findViewById(R.id.charge);
        charge.setButtonColor(getResources().getColor(R.color.white));

        charge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent intent = new Intent(G.currentActivity, ActivityChargeMGZ8.class);
                G.currentActivity.startActivity(intent);
                finish();

            }
        });

        pasword = (FButton) findViewById(R.id.pasword);
        pasword.setButtonColor(getResources().getColor(R.color.white));

        pasword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent intent = new Intent(G.currentActivity, ActivityPasswordMGZ8.class);
                G.currentActivity.startActivity(intent);
                finish();

            }
        });

        remot_name = (FButton) findViewById(R.id.remot_name);
        remot_name.setButtonColor(getResources().getColor(R.color.white));

        remot_name.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent intent = new Intent(G.currentActivity, ActivityRemoteNameMGZ8.class);
                G.currentActivity.startActivity(intent);
                finish();
            }
        });

        zon_name = (FButton) findViewById(R.id.zon_name);
        zon_name.setButtonColor(getResources().getColor(R.color.white));

        zon_name.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent intent = new Intent(G.currentActivity, ActivityZonNameMGZ8.class);
                G.currentActivity.startActivity(intent);
                finish();
            }
        });

        wl_name = (FButton) findViewById(R.id.wl_name);
        wl_name.setButtonColor(getResources().getColor(R.color.white));

        wl_name.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent intent = new Intent(G.currentActivity, ActivityWlNameMGZ8.class);
                G.currentActivity.startActivity(intent);
                finish();
            }
        });


        tak = (FButton) findViewById(R.id.setting);
        tak.setButtonColor(getResources().getColor(R.color.white));

        tak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent intent = new Intent(G.currentActivity, ActivityPanelMGZ8.class);
                G.currentActivity.startActivity(intent);
                finish();
            }
        });


        ///////////set description
        view_descips = new ArrayList<>();
        view_descips.add(new view_descip(zon_name, "توضیحات",
                "برای زون های دستگاه نام محل نصب را وارد کنید"));


        view_descips.add(new view_descip(access,
                "توضیحات", "شماره هایی که میخواهید" +
                " به آنها پیامک ارسال شود و یا با " +
                "پیامک دستگاه را کنترل کنند در این قسمت وارد کنید" +
                "و تنظیمات مربوطه را انجام دهید."));

        view_descips.add(new view_descip(out_name, "توضیحات",
                "برای خروجی ها یک نام میتوانید ذخیره کنید"));

        view_descips.add(new view_descip(charge, "توضیحات",
                "تنظیمات مربوط به نوع سیمکارت وشارژ را در این قسمت وارد کنید"));

        view_descips.add(new view_descip(pasword,
                "توضیحات", "رمز دستگاه را میتوانید در این قسمت تغییر دهید"));

        view_descips.add(new view_descip(remot_name, "توضیحات",
                "برای هر یک از ریموت ها میتوایند یک نام ذخیر کنید"));


        view_descips.add(new view_descip(tak, "توضیحات",
                "تنظیمات مربوط به دستگاه(مدت آژیر،زون 24ساعته و ...)را در این قسمت انجام دهید"));












        /////////////////

        SharedPreferences prefs = getSharedPreferences("code_help", MODE_PRIVATE);
        String restoredText = prefs.getString("code", null);
        if (restoredText != null) {

        } else {
            view_descips.add(new view_descip(access,
                    "توضیحات", "شماره هایی که میخواهید" +
                    " به آنها پیامک ارسال شود و یا با " +
                    "پیامک دستگاه را کنترل کنند در این قسمت وارد کنید" +
                    "و تنظیمات مربوطه را انجام دهید."));
            SharedPreferences.Editor editor = getSharedPreferences("code_help", MODE_PRIVATE).edit();
            editor.putString("code", "1");
            editor.apply();
        }

        //remot_name,access, zon_name, wl_name, out_name, charge, phone_number, tak, pasword ,goAbout;


        zon_name.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(0));
                return true;
            }
        });

        access.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(1));
                return true;
            }
        });
        out_name.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(2));
                return true;
            }
        });
        charge.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(3));
                return true;
            }
        });
        pasword.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(4));
                return true;
            }
        });

        remot_name.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(5));
                return true;
            }
        });
        wl_name.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(6));
                return true;
            }
        });









        tak.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(7));
                return true;
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



/*
    public void setviewsHelp(view_descip view, final ArrayList<view_descip> list){
        TapTargetView.showFor(this,                 // `this` is an Activity
                TapTarget.forView(view.getView(), view.getTitle(), view.getDesc())

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
                        .cancelable(false)                  // Whether tapping outside the outer circle dismisses the view

                        .tintTarget(true)                   // Whether to tint the target view's color
                        .transparentTarget(true)           // Specify whether the target is transparent (displays the content underneath)
                        // Specify a custom drawable to draw as the target
                        .targetRadius(30)// Specify the target radius (in dp)
      ,  new TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
            @Override
            public void onTargetClick(TapTargetView view) {
                super.onTargetClick(view);      // This call is optional


            if(NUMBER_ELEMENT_VIEW<10){

                setviewsHelp(list.get(NUMBER_ELEMENT_VIEW),view_descips);

                    NUMBER_ELEMENT_VIEW++;
            }



            }



        });
    }
*/

    public void setviewHelp(view_descip view) {
        TapTargetView.showFor(this,                 // `this` is an Activity
                TapTarget.forView(view.getView(), view.getTitle(), view.getDesc())

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
                , new TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
                    @Override
                    public void onTargetClick(TapTargetView view) {
                        super.onTargetClick(view);      // This call is optional


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

    @Override
    protected void onPause() {
        super.onPause();
    }
}