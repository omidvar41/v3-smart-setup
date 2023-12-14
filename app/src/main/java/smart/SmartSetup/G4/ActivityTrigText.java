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

import smart.SmartSetup.G4.Edit.ActivityEditTrigNameG4;
import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MG4.view_descip;
import smart.SmartSetup.R;

/**
 * Created by Roholah on 30/06/2017.
 */

public class ActivityTrigText extends EnhancedActivity {
public  static ActivityTrigText activityTrigText;
    static TextView txtTrig1;
    static TextView txtTrig2;
    static TextView txtTrig3;
    static TextView txtTrig4on;
    static TextView txtTrig4off;

    LinearLayout layTrig1;
    LinearLayout    layTrig2;
    LinearLayout    layTrig3;
    LinearLayout    layTrig4on;
    LinearLayout    layTrig4off;
ArrayList<view_descip> view_descips=new ArrayList<>();
     Handler handler1;

     ImageView bluicon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.g4_activity_trig_text);
activityTrigText=this;
bluicon=(ImageView)findViewById(R.id.bluIcon);
        txtTrig1 = (TextView) findViewById(R.id.txtTrig1);
        txtTrig2 = (TextView) findViewById(R.id.txtTrig2);
        txtTrig3 = (TextView) findViewById(R.id.txtTrig3);
        txtTrig4on = (TextView) findViewById(R.id.txtTrig4on);
        txtTrig4off = (TextView) findViewById(R.id.txtTrig4off);

        layTrig1 = (LinearLayout) findViewById(R.id.layTrig1);
        layTrig2 = (LinearLayout) findViewById(R.id.layTrig2);
        layTrig3 = (LinearLayout) findViewById(R.id.layTrig3);
        layTrig4on = (LinearLayout) findViewById(R.id.layTrig4on);
        layTrig4off = (LinearLayout) findViewById(R.id.layTrig4off);
         ActivityMain main=new ActivityMain();
        main.SendBt("Trig?");






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




                txtTrig1.setText(ActivityMain.TrigText[1]);
                txtTrig2.setText(ActivityMain.TrigText[2]);
                txtTrig3.setText(ActivityMain.TrigText[3]);
                txtTrig4off.setText(ActivityMain.TrigText[0]);
                txtTrig4on.setText(ActivityMain.TrigText[4]);




            }
        }, 0);





        layTrig1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditTrigNameG4.class);
                intent.putExtra("TRIG", "1");
                setIntent(intent,txtTrig1);
                G.currentActivity.startActivity(intent);
            }
        });

        layTrig2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditTrigNameG4.class);
                intent.putExtra("TRIG", "2");
                setIntent(intent,txtTrig2);
                G.currentActivity.startActivity(intent);
            }
        });

        layTrig3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditTrigNameG4.class);
                intent.putExtra("TRIG", "3");
                setIntent(intent,txtTrig3);
                G.currentActivity.startActivity(intent);
            }
        });

        layTrig4on.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditTrigNameG4.class);
                intent.putExtra("TRIG", "4");
                setIntent(intent,txtTrig4on);
                G.currentActivity.startActivity(intent);
            }
        });

        layTrig4off.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditTrigNameG4.class);
                intent.putExtra("TRIG", "0");
                setIntent(intent,txtTrig4off);
                G.currentActivity.startActivity(intent);
            }
        });

        view_descips.add(new view_descip(layTrig1,"توضیح","متن مورد نظر را برای هر تحریک وارد کنید \n(حداکثر 35 حرف)"));
        view_descips.add(new view_descip(layTrig2,"توضیح","متن مورد نظر را برای هر تحریک وارد کنید \n(حداکثر 35 حرف)"));
        view_descips.add(new view_descip(layTrig3,"توضیح","متن مورد نظر را برای هر تحریک وارد کنید \n(حداکثر 35 حرف)"));
        view_descips.add(new view_descip(layTrig4off,"توضیح","متن مورد نظر را برای هر تحریک وارد کنید \n(حداکثر 35 حرف)"));
        view_descips.add(new view_descip(layTrig4on,"توضیح","متن مورد نظر را برای هر تحریک وارد کنید \n(حداکثر 35 حرف)"));


        layTrig1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(0));
                return true;
            }
        });
        layTrig2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(1));
                return true;
            }
        });
        layTrig3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(2));
                return true;
            }
        });
        layTrig4off.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(3));
                return true;
            }
        });
        layTrig4on.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(4));
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

    private void hellpTrigNameDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(G.currentActivity);
        builder.setTitle("توضیح");
        builder.setMessage("متن مورد نظر برای هر تحریک را وارد کنید." + "\n" + "(حداکثر 35 حرف)");
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
