package smart.SmartSetup.MGZ8;

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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.ArrayList;

import info.hoang8f.widget.FButton;
import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MGZ8.Edit.ActivitySendShargeMGZ8;
import smart.SmartSetup.MGZ8.Edit.Select_type_modelSim;
import smart.SmartSetup.R;

public class ActivityChargeMGZ8 extends EnhancedActivity {
    public  static ActivityChargeMGZ8 activityChargeMGZ8;
    LinearLayout layCodeChekCharge;


public  static String TypeSim="";
Handler handler1;
    FButton btnAddCharge,
  btnChekCharge;
    public static TextView txtCodeChekCharge;
public static ProgressBar progressBar;
    public static TextView txtCusd;
    LinearLayout l1,l2,l3,l4,lyselectsim;
    TextView nameoperator,desc,modelsim,simcardName,txtWaith;
    ImageView bluicon;
    boolean flag;
    MediaPlayer mediaPlayer;
    ArrayList<view_descip> view_descips=new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mgz8_activity_charge);
        activityChargeMGZ8 =this;
        layCodeChekCharge = (LinearLayout) findViewById(R.id.layCodeChekCharge);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        lyselectsim = (LinearLayout) findViewById(R.id.lySelectTypeSim);



        txtCodeChekCharge = (TextView) findViewById(R.id.txtCodeChekCharge);
        txtWaith = (TextView) findViewById(R.id.txtWaith);

        txtCusd = (TextView) findViewById(R.id.txtCusd);
        simcardName = (TextView) findViewById(R.id.simcardName);
        modelsim = (TextView) findViewById(R.id.modelsim);

        l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);
        l3=(LinearLayout)findViewById(R.id.l3);
        l4=(LinearLayout)findViewById(R.id.l4);
        nameoperator=(TextView)findViewById(R.id.nameoperator);
        bluicon=(ImageView)findViewById(R.id.bluIcon);
        desc=(TextView)findViewById(R.id.descrip);

        btnAddCharge = (FButton) findViewById(R.id.btnAddCharge);
        btnAddCharge.setButtonColor(getResources().getColor(R.color.white));

        btnChekCharge = (FButton) findViewById(R.id.btnChekCharge);
        btnChekCharge.setButtonColor(getResources().getColor(R.color.white));

        lyselectsim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String model=modelsim.getText().toString();
                Intent intent=new Intent(G.currentActivity, Select_type_modelSim.class);
                if (model.equals("دائمی")){
                    intent.putExtra("code","1");
                }
                if (model.equals("اعتباری")){
                    intent.putExtra("code","2");
                }

                intent.putExtra("Name",nameoperator.getText().toString());
                startActivityForResult(intent,1);
            }
        });


        final ActivityMain main=new ActivityMain();

        main.SendBt("Charge?");



        handler1 = new Handler();
        handler1.postDelayed(new Runnable(){
            public void run(){


                handler1.postDelayed(this, 500);

                if (!txtCusd.getText().toString().equals("")){
                    progressBar.setVisibility(View.INVISIBLE);
                    txtWaith.setVisibility(View.GONE);

                }


                if (flag) {

                    txtCodeChekCharge.setText(ActivityMain.CodeChekCharge);
                    txtCusd.setText(ActivityMain.Cusd);



                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if (ActivityMain.CodeChekCharge.equals("")){
                                layCodeChekCharge.setVisibility(View.GONE);
                                btnAddCharge.setVisibility(View.GONE);
                                btnChekCharge.setVisibility(View.GONE);
                                progressBar.setVisibility(View.INVISIBLE);
                                ActivityMain.Cusd="";
                                modelsim.setText("دائمی");

                            }

                            if (ActivityMain.CodeChekCharge.equals("    ")){
                                layCodeChekCharge.setVisibility(View.GONE);
                                btnAddCharge.setVisibility(View.GONE);
                                btnChekCharge.setVisibility(View.GONE);
                                ActivityMain.Cusd="";
                                progressBar.setVisibility(View.INVISIBLE);

                                modelsim.setText("دائمی");

                            }else{
                                layCodeChekCharge.setVisibility(View.VISIBLE);
btnChekCharge.setVisibility(View.VISIBLE);
btnAddCharge.setVisibility(View.VISIBLE);

                                modelsim.setText("اعتباری");

                            }

                            nameoperator.setText(ActivityMain.nameOperator);
                            if (!nameoperator.equals("")){


                            String name=ActivityMain.nameOperator;

                            if (name.equals("IR-MCI")){
                                simcardName.setText("همراه اول");
                            }else if (name.equals("Irancell")){
                                simcardName.setText("ایرانسل");

                            }else {
                                simcardName.setText(name);

                            }


                        }
                        }
                    });
                    desc.setText(ActivityMain.LCD);


                    if (G.connected == false) {
                        bluicon.setImageResource(R.drawable.blutose_disable);


                    }
                    if (G.connected == true) {
                        bluicon.setImageResource(R.drawable.blutose_enable);
                    }

                    switch (ActivityMain.numAn) {
                        case "0":
                            l1.setBackgroundColor(Color.GRAY);
                            l2.setBackgroundColor(Color.GRAY);
                            l3.setBackgroundColor(Color.GRAY);
                            l4.setBackgroundColor(Color.GRAY);


                            break;
                        case "1":
                            l1.setBackgroundColor(Color.GREEN);
                            l2.setBackgroundColor(Color.GRAY);
                            l3.setBackgroundColor(Color.GRAY);
                            l4.setBackgroundColor(Color.GRAY);

                            break;
                        case "2":
                            l1.setBackgroundColor(Color.GREEN);
                            l2.setBackgroundColor(Color.GREEN);
                            l3.setBackgroundColor(Color.GRAY);
                            l4.setBackgroundColor(Color.GRAY);


                            break;

                        case "3":
                            l1.setBackgroundColor(Color.GREEN);
                            l2.setBackgroundColor(Color.GREEN);
                            l3.setBackgroundColor(Color.GREEN);
                            l4.setBackgroundColor(Color.GRAY);


                            break;

                        case "4":
                            l1.setBackgroundColor(Color.GREEN);
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
                }

            }
        }, 0);









        btnAddCharge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(G.currentActivity, ActivitySendShargeMGZ8.class);
                G.currentActivity.startActivity(intent);
            }

        });

        btnChekCharge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

progressBar.setVisibility(View.VISIBLE);
txtWaith.setVisibility(View.VISIBLE);
               ActivityMain.Cusd="";
               txtCusd.setText("");
               txtWaith.setText("درحال محاسبه ...");
                ActivityMain main=new ActivityMain();
                main.SendBt("ChekCharge?");

            }
        });




        view_descips.add(new view_descip(lyselectsim,"توضیح"
                ,"در این قسمت نوع سیم کارت نمایش داده میشود جهت تنظیم بر روی آن کلیک کنید"));

        view_descips.add(new view_descip(btnAddCharge,"توضیح"
                ,"جهت شارژ سیم کارت رمز شارژ همراه یا کد دستوری مربوطه را در این قسمت وارد کنید"));
        view_descips.add(new view_descip(btnChekCharge,"توضیح","باقیمانده شارژ را نشان میدهد"));


        lyselectsim.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(0));
                return true;
            }
        });



     btnAddCharge.setOnLongClickListener(new View.OnLongClickListener() {
         @Override
         public boolean onLongClick(View view) {
             setviewHelp(view_descips.get(1));
             return true;
         }
     });

        btnChekCharge.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(2));
                return true;
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (TypeSim){
            case "1":

                break;
            case "2":

                break;

                default:
                    break;
        }



    }

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

    @Override
    protected void onDestroy() {
        handler1.removeCallbacksAndMessages(null);

        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handler1.removeCallbacksAndMessages(null);
        ActivityMain.Cusd="";
        startActivity(new Intent(G.currentActivity, Activity_List_MGZ8.class));
        finish();

    }

    @Override
    protected void onResume() {
        super.onResume();
        flag=true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        flag=false;
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
}
