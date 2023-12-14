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

import smart.SmartSetup.G4.Edit.ActivityEditPhoneNumberG4;
import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MG4.view_descip;
import smart.SmartSetup.R;

/**
 * Created by Roholah on 30/06/2017.
 */

public class ActivityPhoneNumberG4 extends EnhancedActivity {

    static TextView txtMemory11;
    static TextView txtMemory12;
    static TextView txtMemory13;
    static TextView txtMemory14;
    static TextView txtMemory15;
    static TextView txtMemory16;
    static TextView txtMemory17;
    static TextView txtMemory18;
    static TextView txtMemory19;
    static TextView txtMemory20;

    LinearLayout layMemory11;
    LinearLayout    layMemory12;
    LinearLayout    layMemory13;
    LinearLayout    layMemory14;
    LinearLayout    layMemory15;
    LinearLayout    layMemory16;
    LinearLayout    layMemory17;
    LinearLayout    layMemory18;
    LinearLayout    layMemory19;
    LinearLayout    layMemory20;
    Handler handler3;

    ArrayList<view_descip> view_descips=new ArrayList<>();

public static ActivityPhoneNumberG4 activityPhoneNumberG4;
    ActivityMain main;
    ImageView bluicon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.g4_activity_phone_number);
activityPhoneNumberG4=this;
bluicon=(ImageView)findViewById(R.id.bluIcon);
        txtMemory11 = (TextView) findViewById(R.id.txtMemory11);
        txtMemory12 = (TextView) findViewById(R.id.txtMemory12);
        txtMemory13 = (TextView) findViewById(R.id.txtMemory13);
        txtMemory14 = (TextView) findViewById(R.id.txtMemory14);
        txtMemory15 = (TextView) findViewById(R.id.txtMemory15);
        txtMemory16 = (TextView) findViewById(R.id.txtMemory16);
        txtMemory17 = (TextView) findViewById(R.id.txtMemory17);
        txtMemory18 = (TextView) findViewById(R.id.txtMemory18);
        txtMemory19 = (TextView) findViewById(R.id.txtMemory19);
        txtMemory20 = (TextView) findViewById(R.id.txtMemory20);

        layMemory11 = (LinearLayout) findViewById(R.id.layMemory11);
        layMemory12 = (LinearLayout) findViewById(R.id.layMemory12);
        layMemory13 = (LinearLayout) findViewById(R.id.layMemory13);
        layMemory14 = (LinearLayout) findViewById(R.id.layMemory14);
        layMemory15 = (LinearLayout) findViewById(R.id.layMemory15);
        layMemory16 = (LinearLayout) findViewById(R.id.layMemory16);
        layMemory17 = (LinearLayout) findViewById(R.id.layMemory17);
        layMemory18 = (LinearLayout) findViewById(R.id.layMemory18);
        layMemory19 = (LinearLayout) findViewById(R.id.layMemory19);
        layMemory20 = (LinearLayout) findViewById(R.id.layMemory20);


        main=new ActivityMain();
       main.SendBt("M-Pho?");













        handler3 = new Handler();
        handler3.postDelayed(new Runnable(){
            public void run(){

                handler3.postDelayed(this, 1000);


                if (G.connected == false) {
                    bluicon.setImageResource(R.drawable.blutose_disable);


                }
                if (G.connected == true) {
                    bluicon.setImageResource(R.drawable.blutose_enable);
                }


                txtMemory11.setText(ActivityMain.NumberPhoneMemory[1]);
                txtMemory12.setText(ActivityMain.NumberPhoneMemory[2]);
                txtMemory13.setText(ActivityMain.NumberPhoneMemory[3]);
                txtMemory14.setText(ActivityMain.NumberPhoneMemory[4]);
                txtMemory15.setText(ActivityMain.NumberPhoneMemory[5]);
                txtMemory16.setText(ActivityMain.NumberPhoneMemory[6]);
                txtMemory17.setText(ActivityMain.NumberPhoneMemory[7]);
                txtMemory18.setText(ActivityMain.NumberPhoneMemory[8]);
                txtMemory19.setText(ActivityMain.NumberPhoneMemory[9]);
                txtMemory20.setText(ActivityMain.NumberPhoneMemory[10]);


            }
        }, 0);



















        layMemory11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberG4.class);
                intent.putExtra("MAMORY", "11");
                setIntent(intent,txtMemory11);
                G.currentActivity.startActivity(intent);
            }

        });

        layMemory12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberG4.class);
                intent.putExtra("MAMORY", "12");
                setIntent(intent,txtMemory12);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory13.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberG4.class);
                intent.putExtra("MAMORY", "13");
                setIntent(intent,txtMemory13);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory14.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberG4.class);
                intent.putExtra("MAMORY", "14");
                setIntent(intent,txtMemory14);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory15.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberG4.class);
                intent.putExtra("MAMORY", "15");
                setIntent(intent,txtMemory15);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory16.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberG4.class);
                intent.putExtra("MAMORY", "16");
                setIntent(intent,txtMemory16);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory17.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberG4.class);
                intent.putExtra("MAMORY", "17");
                setIntent(intent,txtMemory17);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory18.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberG4.class);
                intent.putExtra("MAMORY", "18");
                setIntent(intent,txtMemory18);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory19.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberG4.class);
                intent.putExtra("MAMORY", "19");
                setIntent(intent,txtMemory19);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory20.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberG4.class);
                intent.putExtra("MAMORY", "20");
                setIntent(intent,txtMemory20);
                G.currentActivity.startActivity(intent);
            }
        });


        view_descips.add(new view_descip(layMemory11,"توضیحات","شماره تلفن های که می خواهیدهنگام" +
                " آژیر با آنها تماس صوتی گرفته شود را وارد کنید " +
                "                        \nشماره های ثابت را حتما با کد شهر وارد کنید"));

        view_descips.add(new view_descip(layMemory12,"توضیحات","شماره تلفن های که می خواهیدهنگام" +
                " آژیر با آنها تماس صوتی گرفته شود را وارد کنید " +
                "                        \nشماره های ثابت را حتما با کد شهر وارد کنید"
        ));
        view_descips.add(new view_descip(layMemory13,"توضیحات","شماره تلفن های که می خواهیدهنگام" +
                " آژیر با آنها تماس صوتی گرفته شود را وارد کنید " +
                "                        \nشماره های ثابت را حتما با کد شهر وارد کنید"
        ));
        view_descips.add(new view_descip(layMemory14,"توضیحات","شماره تلفن های که می خواهیدهنگام" +
                " آژیر با آنها تماس صوتی گرفته شود را وارد کنید " +
                "                        \nشماره های ثابت را حتما با کد شهر وارد کنید"));
        view_descips.add(new view_descip(layMemory15,"توضیحات","شماره تلفن های که می خواهیدهنگام" +
                " آژیر با آنها تماس صوتی گرفته شود را وارد کنید " +
                "                        \nشماره های ثابت را حتما با کد شهر وارد کنید"));
        view_descips.add(new view_descip(layMemory16,"توضیحات","شماره تلفن های که می خواهیدهنگام" +
                " آژیر با آنها تماس صوتی گرفته شود را وارد کنید " +
                "                        \nشماره های ثابت را حتما با کد شهر وارد کنید"));
        view_descips.add(new view_descip(layMemory17,"توضیحات","شماره تلفن های که می خواهیدهنگام" +
                " آژیر با آنها تماس صوتی گرفته شود را وارد کنید " +
                "                        \nشماره های ثابت را حتما با کد شهر وارد کنید"));
        view_descips.add(new view_descip(layMemory18,"توضیحات","شماره تلفن های که می خواهیدهنگام" +
                " آژیر با آنها تماس صوتی گرفته شود را وارد کنید " +
                "                        \nشماره های ثابت را حتما با کد شهر وارد کنید"));
        view_descips.add(new view_descip(layMemory19,"توضیحات","شماره تلفن های که می خواهیدهنگام" +
                " آژیر با آنها تماس صوتی گرفته شود را وارد کنید " +
                "                        \nشماره های ثابت را حتما با کد شهر وارد کنید"));
        view_descips.add(new view_descip(layMemory20,"توضیحات","شماره تلفن های که می خواهیدهنگام" +
                " آژیر با آنها تماس صوتی گرفته شود را وارد کنید " +
                "                        \nشماره های ثابت را حتما با کد شهر وارد کنید"));

        layMemory11.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(0));
                return true;
            }
        });


        layMemory12.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(1));
                return true;
            }
        });

        layMemory13.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(2));
                return true;
            }
        });

        layMemory14.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(3));
                return true;
            }
        });

        layMemory15.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(4));
                return true;
            }
        });
        layMemory16.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(7));
                return true;
            }
        });
        layMemory17.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(5));
                return true;
            }
        });

        layMemory18.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(6));
                return true;
            }
        });
        layMemory19.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(7));
                return true;
            }
        });
        layMemory20.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(8));
                return true;
            }
        });


    }

    public void setviewHelp(view_descip  view_descip) {
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

    private void hellpPhoneNumberDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(G.currentActivity);
        builder.setTitle("توضیح");
        builder.setMessage("شماره تلفن های که می خواهیدهنگام تحریک با آنها تماس گرفته شود را وارد کنید " + "\n" + "شماره های ثابت را حتما با کد شهر محل نصب وارد کنید");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }


    @Override
    protected void onDestroy() {
        handler3.removeCallbacksAndMessages(null);
        finish();
        super.onDestroy();
    }
    @Override
    public void onBackPressed() {
        handler3.removeCallbacksAndMessages(null);
        finish();
        super.onBackPressed();
    }

}
