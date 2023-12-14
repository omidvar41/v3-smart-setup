package smart.SmartSetup.MGZ8;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.ArrayList;

import info.hoang8f.widget.FButton;
import smart.SmartSetup.MGZ8.Edit.ActivityEditPhoneNumberMGZ8;
import smart.SmartSetup.MGZ8.Edit.ActivityEditTypeTrigMGZ8;
import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.MG4.Edit.ActivivtyEditselectTypeCall;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.R;

/**
 * Created by Roholah on 30/06/2017.
 */

public class ActivityPhoneNumberMGZ8 extends EnhancedActivity {
public static ActivityPhoneNumberMGZ8 activityPhoneNumberMGZ8;
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
    static TextView txtTypeTrig;

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
    LinearLayout    laycitycode;

    LinearLayout    layTypeTring;
    public static FButton btnt1,btnt2,btnt3,btnt4,btnt5,btnt6,btnt7,btnt8,btnt9,btnt10;


public static boolean flag=true;
    Handler handler3;

    static LinearLayout l1,l2,l3,l4;
    static TextView nameoperator;
    static TextView desc;
    static TextView txtcitycode;
    static ImageView bluicon;
    public static String numAn="0";
    public static String nameOperator="";

    ActivityMain main;

    ArrayList<view_descip> view_descips=new ArrayList<>();
    MediaPlayer mediaPlayer;
    public static ActivityPhoneNumberMGZ8 phoneNumberMG4;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.mgz8_activity_phone_number);

        mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.bib);
        float log1=(float)(Math.log(100-10)/Math.log(50));
        mediaPlayer.setVolume(1-log1,1-log1);

activityPhoneNumberMGZ8 =this;
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
        txtTypeTrig = (TextView) findViewById(R.id.txtTrtiger);
        txtcitycode = (TextView) findViewById(R.id.txtcitycode);

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
        layTypeTring = (LinearLayout) findViewById(R.id.typetriger);


        btnt1=(FButton)findViewById(R.id.test11);
        btnt1.setButtonColor(getResources().getColor(R.color.white));
        btnt1.setTextColor(getResources().getColor(R.color.blue));

        btnt2=(FButton)findViewById(R.id.test12);
        btnt2.setButtonColor(getResources().getColor(R.color.white));
        btnt2.setTextColor(getResources().getColor(R.color.blue));

        btnt3=(FButton)findViewById(R.id.test13);
        btnt3.setButtonColor(getResources().getColor(R.color.white));
        btnt3.setTextColor(getResources().getColor(R.color.blue));

        btnt4=(FButton)findViewById(R.id.test14);
        btnt4.setButtonColor(getResources().getColor(R.color.white));
        btnt4.setTextColor(getResources().getColor(R.color.blue));

        btnt5=(FButton)findViewById(R.id.test15);
        btnt5.setButtonColor(getResources().getColor(R.color.white));
        btnt5.setTextColor(getResources().getColor(R.color.blue));

        btnt6=(FButton)findViewById(R.id.test16);
        btnt6.setButtonColor(getResources().getColor(R.color.white));
        btnt6.setTextColor(getResources().getColor(R.color.blue));

        btnt7=(FButton)findViewById(R.id.test17);
        btnt7.setButtonColor(getResources().getColor(R.color.white));
        btnt7.setTextColor(getResources().getColor(R.color.blue));

        btnt8=(FButton)findViewById(R.id.test18);
        btnt8.setButtonColor(getResources().getColor(R.color.white));
        btnt8.setTextColor(getResources().getColor(R.color.blue));

        btnt9=(FButton)findViewById(R.id.test19);
        btnt9.setButtonColor(getResources().getColor(R.color.white));
        btnt9.setTextColor(getResources().getColor(R.color.blue));

        btnt10=(FButton)findViewById(R.id.test20);
        btnt10.setButtonColor(getResources().getColor(R.color.white));
        btnt10.setTextColor(getResources().getColor(R.color.blue));






        l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);
        l3=(LinearLayout)findViewById(R.id.l3);
        l4=(LinearLayout)findViewById(R.id.l4);
        laycitycode=(LinearLayout)findViewById(R.id.laycitycode);
        nameoperator=(TextView)findViewById(R.id.nameoperator);
        bluicon=(ImageView)findViewById(R.id.bluIcon);
        desc=(TextView)findViewById(R.id.descrip);
        ///////////////////////////
        main=new ActivityMain();

        main.SendBt("M-Pho?");





















        handler3 = new Handler();




        final Runnable r = new Runnable() {
            public void run() {
                if (flag) {
                    nameoperator.setText(ActivityMain.nameOperator);
                    desc.setText(ActivityMain.LCD);
                    txtMemory11.setText(ActivityMain.NumberPhoneMemory[1]);
                    showbtn(1, btnt1);
                    txtMemory12.setText(ActivityMain.NumberPhoneMemory[2]);
                    showbtn(2, btnt2);
                    txtMemory13.setText(ActivityMain.NumberPhoneMemory[3]);
                    showbtn(3, btnt3);
                    txtMemory14.setText(ActivityMain.NumberPhoneMemory[4]);
                    showbtn(4, btnt4);
                    txtMemory15.setText(ActivityMain.NumberPhoneMemory[5]);
                    showbtn(5, btnt5);
                    txtMemory16.setText(ActivityMain.NumberPhoneMemory[6]);
                    showbtn(6, btnt6);
                    txtMemory17.setText(ActivityMain.NumberPhoneMemory[7]);
                    showbtn(7, btnt7);
                    txtMemory18.setText(ActivityMain.NumberPhoneMemory[8]);
                    showbtn(8, btnt8);
                    txtMemory19.setText(ActivityMain.NumberPhoneMemory[9]);
                    showbtn(9, btnt9);
                    txtMemory20.setText(ActivityMain.NumberPhoneMemory[10]);
                    showbtn(10, btnt10);
                    txtcitycode.setText(ActivityMain.NumberPhoneMemory[12]);
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
                    if (ActivityMain.NumberPhoneMemory[11].equals("Level")) {
                        txtTypeTrig.setText("سطحی");

                    }
                    if (ActivityMain.NumberPhoneMemory[11].equals("Edge")) {
                        txtTypeTrig.setText("لحظه ای");

                    }

                }
                handler3.postDelayed(this, 1000);
            }
        };

        handler3.postDelayed(r, 0);










        ////////////////////////////


        btnt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTestnumber("11");
            }
        });

        btnt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTestnumber("12");
            }
        });
        btnt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTestnumber("13");
            }
        });

        btnt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTestnumber("14");
            }
        });


        btnt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTestnumber("15");
            }
        });

        btnt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTestnumber("16");
            }
        });

        btnt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTestnumber("17");
            }
        });

        btnt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTestnumber("18");
            }
        });

        btnt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTestnumber("19");
            }
        });


        btnt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTestnumber("20");
            }
        });



        layTypeTring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                flag=false;
                Intent intent=new Intent(ActivityPhoneNumberMGZ8.this, ActivityEditTypeTrigMGZ8.class);
                intent.putExtra("code",txtTypeTrig.getText().toString());
                startActivity(intent);
            }
        });







        laycitycode.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberMGZ8.class);
                intent.putExtra("MAMORY", "0");
                setIntent(intent,txtcitycode);

                G.currentActivity.startActivity(intent);
            }

        });

        layMemory11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberMGZ8.class);
                intent.putExtra("MAMORY", "11");

                setIntent(intent,txtMemory11);



                G.currentActivity.startActivity(intent);
            }

        });

        layMemory12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                flag=false;
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberMGZ8.class);
                if (!txtMemory12.getText().toString().equals("Empty")) {
                    intent.putExtra("desc", txtMemory12.getText().toString()+"");
                }



                intent.putExtra("MAMORY", "12");
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory13.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberMGZ8.class);
                intent.putExtra("MAMORY", "13");
                if (!txtMemory13.getText().toString().equals("Empty")) {
                    intent.putExtra("desc", txtMemory13.getText().toString());
                }



                G.currentActivity.startActivity(intent);
            }
        });

        layMemory14.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberMGZ8.class);
                intent.putExtra("MAMORY", "14");
                if (!txtMemory14.getText().toString().equals("Empty")) {
                    intent.putExtra("desc", txtMemory14.getText().toString());
                }



                G.currentActivity.startActivity(intent);
            }
        });

        layMemory15.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberMGZ8.class);
                intent.putExtra("MAMORY", "15");
                if (!txtMemory15.getText().toString().equals("Empty")) {
                    intent.putExtra("desc", txtMemory15.getText().toString());
                }


                G.currentActivity.startActivity(intent);
            }
        });

        layMemory16.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberMGZ8.class);
                intent.putExtra("MAMORY", "16");
                if (!txtMemory16.getText().toString().equals("Empty")) {
                    intent.putExtra("desc", txtMemory16.getText().toString());
                }

                G.currentActivity.startActivity(intent);
            }
        });

        layMemory17.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberMGZ8.class);
                intent.putExtra("MAMORY", "17");
                if (!txtMemory17.getText().toString().equals("Empty")) {
                    intent.putExtra("desc", txtMemory17.getText().toString());
                }



                G.currentActivity.startActivity(intent);
            }
        });

        layMemory18.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberMGZ8.class);
                intent.putExtra("MAMORY", "18");
                if (!txtMemory18.getText().toString().equals("Empty")) {
                    intent.putExtra("desc", txtMemory18.getText().toString());
                }



                G.currentActivity.startActivity(intent);
            }
        });

        layMemory19.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberMGZ8.class);
                intent.putExtra("MAMORY", "19");
                if (!txtMemory19.getText().toString().equals("Empty")) {
                    intent.putExtra("desc", txtMemory19.getText().toString());
                }



                G.currentActivity.startActivity(intent);
            }
        });

        layMemory20.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberMGZ8.class);
                intent.putExtra("MAMORY", "20");
                if (!txtMemory20.getText().toString().equals("Empty")) {
                    intent.putExtra("desc", txtMemory20.getText().toString());
                }


                G.currentActivity.startActivity(intent);
            }
        });


view_descips.add(new view_descip(layTypeTring,"توضیحات"
        ,"اگر میخواهید با قطع آژیر شماره گیری متوقف شود" +
        "تحریک سطحی را انتخاب کنید\n" +
        "واگر میخواهید در صورت قطع آژیر با تمامی شماره ها تماس گرفته شود تحریک لحظه ای را انتخاب کنید"));

view_descips.add(new view_descip(laycitycode,"توضیحات","کد شهر محل نصب را در این قسمت وارد کنید\n(مثال:021)"));

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

layTypeTring.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View view) {
        setviewHelp(view_descips.get(0));
        return true;
    }
});

        laycitycode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(1));
                return true;
            }
        });

        layMemory11.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(2));
                return true;
            }
        });


        layMemory12.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(3));
                return true;
            }
        });

        layMemory13.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(4));
                return true;
            }
        });

        layMemory14.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(5));
                return true;
            }
        });

        layMemory15.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(6));
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
                setviewHelp(view_descips.get(8));
                return true;
            }
        });

        layMemory18.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(9));
                return true;
            }
        });
        layMemory19.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(10));
                return true;
            }
        });
        layMemory20.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(11));
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


    public static void showbtn(int i,Button button){
        if (ActivityMain.NumberPhoneMemory[i].equals("Empty")){
            button.setVisibility(View.GONE);

        }else{
            button.setVisibility(View.VISIBLE);

        }
    }

    public void setIntent(Intent intent,TextView textView){
        if (!textView.getText().toString().equals("Empty")) {
            intent.putExtra("desc", textView.getText().toString());
        }

    }


    public void goTestnumber(String number){

        Intent intent=new Intent(getApplicationContext(),ActivivtyEditselectTypeCall.class);
        intent.putExtra("code",number);
        startActivity(intent);
    }

    private void hellpPhoneNumberDialog(String ms) {
        AlertDialog.Builder builder = new AlertDialog.Builder(G.currentActivity);
        builder.setTitle("توضیح");
        builder.setMessage(ms);
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
        super.onBackPressed();
        handler3.removeCallbacksAndMessages(null);
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
}
