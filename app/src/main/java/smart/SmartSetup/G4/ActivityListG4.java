package smart.SmartSetup.G4;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.ArrayList;

import info.hoang8f.widget.FButton;
import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MG4.view_descip;
import smart.SmartSetup.R;

/**
 * Created by Roholah on 01/07/2017.
 */

public class ActivityListG4 extends EnhancedActivity {
    private FButton  remot_name, zon_name, wl_name, access, out_name, trig_text, charge, phone_number, tak, pasword;
    ArrayList<view_descip> view_descips;
    public static ActivityListG4 activityListG4;

    Handler handler1;
    ImageView bluicon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g4_activity_list);
        bluicon=(ImageView)findViewById(R.id.bluIcon);
        ActivityMain.go_list.setVisibility(View.VISIBLE);
        access = (FButton) findViewById(R.id.access);
        access.setButtonColor(getResources().getColor(R.color.white));
activityListG4=this;



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





            }
        }, 0);




        access.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(G.currentActivity, ActivitySmsNumberG4.class);
                G.currentActivity.startActivity(intent);
            }
        });

        phone_number = (FButton) findViewById(R.id.phone_number);
        phone_number.setButtonColor(getResources().getColor(R.color.white));

        phone_number.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(G.currentActivity, ActivityPhoneNumberG4.class);
                G.currentActivity.startActivity(intent);

            }
        });

        out_name = (FButton) findViewById(R.id.out_name);
        out_name.setButtonColor(getResources().getColor(R.color.white));

        out_name.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(G.currentActivity, ActivityOutNameG4.class);
                G.currentActivity.startActivity(intent);

            }
        });

        trig_text = (FButton) findViewById(R.id.trig_text);
        trig_text.setButtonColor(getResources().getColor(R.color.white));

        trig_text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(G.currentActivity, ActivityTrigText.class);
                G.currentActivity.startActivity(intent);

            }
        });

        charge = (FButton) findViewById(R.id.charge);
        charge.setButtonColor(getResources().getColor(R.color.white));

        charge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(G.currentActivity, ActivityChargeG4.class);
                G.currentActivity.startActivity(intent);

            }
        });

        pasword = (FButton) findViewById(R.id.pasword);
        pasword.setButtonColor(getResources().getColor(R.color.white));

        pasword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(G.currentActivity, ActivityPaswordG4.class);
                G.currentActivity.startActivity(intent);

            }
        });

        remot_name = (FButton) findViewById(R.id.remot_name);
        remot_name.setButtonColor(getResources().getColor(R.color.white));

        remot_name.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(G.currentActivity, ActivityRemotNameG4.class);
                G.currentActivity.startActivity(intent);
                // G.currentActivity.finish();
            }
        });

        zon_name = (FButton) findViewById(R.id.zon_name);
        zon_name.setButtonColor(getResources().getColor(R.color.white));

        zon_name.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(G.currentActivity, ActivityZonNameG4.class);
                G.currentActivity.startActivity(intent);
            }
        });

        wl_name = (FButton) findViewById(R.id.wl_name);
        wl_name.setButtonColor(getResources().getColor(R.color.white));

        wl_name.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(G.currentActivity, ActivityWlNameG4.class);
                G.currentActivity.startActivity(intent);

            }
        });



        tak = (FButton) findViewById(R.id.tak);
        tak.setButtonColor(getResources().getColor(R.color.white));

        tak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(G.currentActivity, ActivityPanelG4.class);
                G.currentActivity.startActivity(intent);

            }
        });

        view_descips = new ArrayList<>();
        view_descips.add(new view_descip(access,
                "توضیحات", "شماره هایی که میخواهید" +
                " به آنها پیامک ارسال شود و یا با " +
                "پیامک دستگاه را کنترل کنند در این قسمت وارد کنید" +
                "و تنظیمات مربوطه را انجام دهید."));
        view_descips.add(new view_descip(remot_name, "توضیحات",
                "برای هر یک از ریموت ها میتوایند یک نام ذخیر کنید"));

        view_descips.add(new view_descip(zon_name, "توضیحات",
                "برای زون های دستگاه نام محل نصب را وارد کنید"));

        view_descips.add(new view_descip(wl_name, "توضیحات"
                , "نام محل سنسور های بیسیم نصب شده را در این قسمت وارد کنید"));

        view_descips.add(new view_descip(out_name, "توضیحات",
                "برای خروجی ها یک نام میتوانید ذخیره کنید"));

        view_descips.add(new view_descip(charge, "توضیحات",
                "تنظیمات مربوط به نوع سیمکارت وشارژ را در این قسمت وارد کنید"));

        view_descips.add(new view_descip(phone_number,
                "توضیحات", "شماره هایی که میخواهید با آنها تماس " +
                "صوتی گرفته شود در این قسمت وارد کنید"));

        view_descips.add(new view_descip(tak, "توضیحات",
                "تنظیمات مربوط به دستگاه(مدت آژیر،زون 24ساعته و ...)را در این قسمت انجام دهید"));

        view_descips.add(new view_descip(pasword,
                "توضیحات", "رمز دستگاه را میتوانید در این قسمت تغییر دهید"));




        view_descips.add(new view_descip(trig_text, "توضیحات"
                , "متن پیامک تحریک هارا در این قسمت میتوانید تغییر دهید"));

        access.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(0));
                return true;
            }
        });
        remot_name.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(1));
                return true;
            }
        });
        zon_name.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(2));
                return true;
            }
        });
        wl_name.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(3));
                return true;
            }
        });
        out_name.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(4));
                return true;
            }
        });
        charge.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(5));
                return true;
            }
        });
        phone_number.setOnLongClickListener(new View.OnLongClickListener() {
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

        pasword.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(8));
                return true;
            }
        });

        trig_text.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(9));
                return true;
            }
        });


    }

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
