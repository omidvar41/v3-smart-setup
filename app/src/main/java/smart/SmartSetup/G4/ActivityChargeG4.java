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
import android.widget.ProgressBar;
import android.widget.TextView;

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
 * Created by Roholah on 30/06/2017.
 */

public class ActivityChargeG4 extends EnhancedActivity {



    Handler handler1;
    boolean flag=false;


    FButton          btnChekCharge;
    public static TextView txtCodeChekCharge;

    public static TextView txtCusd;

    ArrayList<view_descip> view_descips=new ArrayList<>();
    public static ActivityChargeG4 activityChargeG4;
    LinearLayout layselectsim,layCodeChekCharge;

    TextView txtEetebari,txtoperator,txtWaith;
    public static ProgressBar progressBar;
ImageView bluIcon;



    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g4_activity_charge);
activityChargeG4=this;
        txtoperator=(TextView)findViewById(R.id.txtoperator);
        txtEetebari=(TextView)findViewById(R.id.txtEetebari);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        txtCodeChekCharge = (TextView) findViewById(R.id.txtCodeChekCharge);
layselectsim=(LinearLayout)findViewById(R.id.layselectsim);
        layCodeChekCharge=(LinearLayout)findViewById(R.id.layCodeChekCharge);
        txtCusd = (TextView) findViewById(R.id.txtCusd);
        txtWaith = (TextView) findViewById(R.id.txtWaith);
        bluIcon=(ImageView)findViewById(R.id.bluIcon);



        btnChekCharge = (FButton) findViewById(R.id.btnChekCharge);
        btnChekCharge.setButtonColor(getResources().getColor(R.color.white));

        final ActivityMain main=new ActivityMain();
        ActivityMain.Cusd="";
        ActivityMain.CodeCharge="";
        ActivityMain.CodeChekCharge="";
        main.SendBt("Charge?");













        handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
                                 public void run() {


                                     handler1.postDelayed(this, 500);



                                     if (G.connected == false) {
                                         bluIcon.setImageResource(R.drawable.blutose_disable);


                                     }
                                     if (G.connected == true) {
                                         bluIcon.setImageResource(R.drawable.blutose_enable);
                                     }



                                     txtCodeChekCharge.setText(ActivityMain.CodeChekCharge);
                                     txtCusd.setText(ActivityMain.Cusd);


                                     if (!txtCusd.getText().toString().equals("")){
                                         progressBar.setVisibility(View.INVISIBLE);
                                         txtWaith.setVisibility(View.GONE);

                                     }



                                             if (ActivityMain.CodeChekCharge.equals("")) {
                                                 layCodeChekCharge.setVisibility(View.GONE);

                                                 btnChekCharge.setVisibility(View.GONE);
                                                 progressBar.setVisibility(View.INVISIBLE);
                                                 ActivityMain.Cusd = "";
                                                 txtoperator.setText("");
                                                 txtEetebari.setText("دائمی");

                                             }

                                             else if  (ActivityMain.CodeChekCharge.equals("    ")) {
                                                 layCodeChekCharge.setVisibility(View.GONE);
                                                 btnChekCharge.setVisibility(View.GONE);
                                                 ActivityMain.Cusd = "";
                                                 progressBar.setVisibility(View.INVISIBLE);
                                                 txtoperator.setText("");

                                                 txtEetebari.setText("دائمی");

                                             }
                                             else if (ActivityMain.CodeChekCharge.equals("*140*11#")) {
                                                 layCodeChekCharge.setVisibility(View.VISIBLE);
                                                 btnChekCharge.setVisibility(View.VISIBLE);
                                                 txtoperator.setText("همراه اول");

                                                 txtEetebari.setText("اعتباری");

                                             }
                                             else if (ActivityMain.CodeChekCharge.equals("*141*1#")) {
                                                 layCodeChekCharge.setVisibility(View.VISIBLE);
                                                 btnChekCharge.setVisibility(View.VISIBLE);

                                                 txtoperator.setText("ایرانسل");

                                                 txtEetebari.setText("اعتباری");

                                             }
                                             else {
                                                 layCodeChekCharge.setVisibility(View.VISIBLE);
                                                 btnChekCharge.setVisibility(View.VISIBLE);
                                                 txtoperator.setText("");
                                                 txtEetebari.setText("اعتباری");

                                             }



                                 }
                                     }, 0);








        btnChekCharge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                txtCusd.setText("");
                ActivityMain.Cusd="";
                txtWaith.setText("درحال محاسبه...");
                txtWaith.setVisibility(View.VISIBLE);

                progressBar.setVisibility(View.VISIBLE);
                ActivityMain main=new ActivityMain();
                main.SendBt("ChekCharge?");

            }
        });
        layselectsim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(G.currentActivity,select_type_sim.class);
                String model=txtEetebari.getText().toString();

                if (ActivityMain.CodeChekCharge.equals("    ")){
                    intent.putExtra("code","1");
                }
                if (ActivityMain.CodeChekCharge.equals("")){
                    intent.putExtra("code","1");
                }
                if (ActivityMain.CodeChekCharge.equals("*140*11#")){
                    intent.putExtra("code","2");
                }
                if (ActivityMain.CodeChekCharge.equals("*141*1#")){
                    intent.putExtra("code","3");
                }
                else {
                    intent.putExtra("code","4");
                }

                intent.putExtra("number",ActivityMain.CodeChekCharge);
                startActivityForResult(intent,1);


            }
        });





        view_descips.add(new view_descip(btnChekCharge,"توضیح","باقیمانده شارژ را نشان میدهد"));






        btnChekCharge.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(0));
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

    private void hellpChekChargDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(G.currentActivity);
        builder.setTitle("توضیح");
        builder.setMessage("فرمول کنترل شارژ" + "\n" + "برای ایرانسل اعتباری " + "#141*1*" + "\n" + "برای همراه اول اعتباری " + "#140*11*" + "\n" + "برای سیم کارت دایمی خالی");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }


    ///.................................................................................
    private void hellpCodeChargeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(G.currentActivity);
        builder.setTitle("توضیح");
        builder.setMessage("فرمول شارژ" + "\n" + "برای ایرانسل اعتباری " + "*141*" + "\n" + "برای همراه اول اعتباری " + "#*140*" + "\n" + "برای سیم کارت دایمی خالی");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }
    public void setIntent(Intent intent,TextView textView){
        if (!textView.getText().toString().equals("Empty")) {
            intent.putExtra("descc", textView.getText().toString());
        }

    }

    @Override
    protected void onDestroy() {
        handler1.removeCallbacksAndMessages(null);

        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        handler1.removeCallbacksAndMessages(null);

        super.onBackPressed();
    }
}
