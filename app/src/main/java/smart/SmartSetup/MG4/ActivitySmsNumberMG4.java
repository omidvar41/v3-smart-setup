package smart.SmartSetup.MG4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MG4.Edit.ActivityEditSmsNumberMG4;
import smart.SmartSetup.R;

public class ActivitySmsNumberMG4 extends EnhancedActivity {
    public static smart.SmartSetup.MG4.ActivitySmsNumberMG4 activitySmsNumberMG4;
    public static String Comaand;
    public static String ComaandText;

    static TextView txtMemory1;
    static TextView      txtMemory2;
    static TextView      txtMemory3;
    static TextView      txtMemory4;
    static TextView      txtMemory5;
    static TextView      txtMemory6;
    static TextView      txtMemory7;
    static TextView      txtMemory8;
    static TextView      txtMemory9;
    static TextView      txtMemory10;

    static TextView      txtReportMemory1;
    static TextView      txtReportMemory2;
    static TextView      txtReportMemory3;
    static TextView      txtReportMemory4;
    static TextView      txtReportMemory5;
    static TextView      txtReportMemory6;
    static TextView      txtReportMemory7;
    static TextView      txtReportMemory8;
    static TextView      txtReportMemory9;
    static TextView      txtReportMemory10;

    static TextView      txtTkzngMemory1;
    static TextView      txtTkzngMemory2;
    static TextView      txtTkzngMemory3;
    static TextView      txtTkzngMemory4;
    static TextView      txtTkzngMemory5;
    static TextView      txtTkzngMemory6;
    static TextView      txtTkzngMemory7;
    static TextView      txtTkzngMemory8;
    static TextView      txtTkzngMemory9;
    static TextView      txtTkzngMemory10;

    static ImageView imgControlMemory1;
    static ImageView     imgControlMemory2;
    static ImageView     imgControlMemory3;
    static ImageView     imgControlMemory4;
    static ImageView     imgControlMemory5;
    static ImageView     imgControlMemory6;
    static ImageView     imgControlMemory7;
    static ImageView     imgControlMemory8;
    static ImageView     imgControlMemory9;
    static ImageView     imgControlMemory10;

    LinearLayout layMemory1;
    LinearLayout         layMemory2;
    LinearLayout         layMemory3;
    LinearLayout         layMemory4;
    LinearLayout         layMemory5;
    LinearLayout         layMemory6;
    LinearLayout         layMemory7;
    LinearLayout         layMemory8;
    LinearLayout         layMemory9;
    LinearLayout         layMemory10;

    Handler handler1;
    LinearLayout l1,l2,l3,l4;
    TextView nameoperator,desc;
    ImageView bluicon,helpicon;
    public static String nameOperator="";
MediaPlayer mediaPlayer;
    ActivityMain main;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mg4_activity_sms_number);
        activitySmsNumberMG4 =this;
main=new ActivityMain();



        txtMemory1 = (TextView) findViewById(R.id.txtMemory1);
        txtMemory2 = (TextView) findViewById(R.id.txtMemory2);
        txtMemory3 = (TextView) findViewById(R.id.txtMemory3);
        txtMemory4 = (TextView) findViewById(R.id.txtMemory4);
        txtMemory5 = (TextView) findViewById(R.id.txtMemory5);
        txtMemory6 = (TextView) findViewById(R.id.txtMemory6);
        txtMemory7 = (TextView) findViewById(R.id.txtMemory7);
        txtMemory8 = (TextView) findViewById(R.id.txtMemory8);
        txtMemory9 = (TextView) findViewById(R.id.txtMemory9);
        txtMemory10 = (TextView) findViewById(R.id.txtMemory10);

        txtReportMemory1 = (TextView) findViewById(R.id.txtReportMemory1);
        txtReportMemory2 = (TextView) findViewById(R.id.txtReportMemory2);
        txtReportMemory3 = (TextView) findViewById(R.id.txtReportMemory3);
        txtReportMemory4 = (TextView) findViewById(R.id.txtReportMemory4);
        txtReportMemory5 = (TextView) findViewById(R.id.txtReportMemory5);
        txtReportMemory6 = (TextView) findViewById(R.id.txtReportMemory6);
        txtReportMemory7 = (TextView) findViewById(R.id.txtReportMemory7);
        txtReportMemory8 = (TextView) findViewById(R.id.txtReportMemory8);
        txtReportMemory9 = (TextView) findViewById(R.id.txtReportMemory9);
        txtReportMemory10 = (TextView) findViewById(R.id.txtReportMemory10);

        txtTkzngMemory1 = (TextView) findViewById(R.id.txtTkzngMemory1);
        txtTkzngMemory2 = (TextView) findViewById(R.id.txtTkzngMemory2);
        txtTkzngMemory3 = (TextView) findViewById(R.id.txtTkzngMemory3);
        txtTkzngMemory4 = (TextView) findViewById(R.id.txtTkzngMemory4);
        txtTkzngMemory5 = (TextView) findViewById(R.id.txtTkzngMemory5);
        txtTkzngMemory6 = (TextView) findViewById(R.id.txtTkzngMemory6);
        txtTkzngMemory7 = (TextView) findViewById(R.id.txtTkzngMemory7);
        txtTkzngMemory8 = (TextView) findViewById(R.id.txtTkzngMemory8);
        txtTkzngMemory9 = (TextView) findViewById(R.id.txtTkzngMemory9);
        txtTkzngMemory10 = (TextView) findViewById(R.id.txtTkzngMemory10);

        imgControlMemory1 = (ImageView) findViewById(R.id.imgControlMemory1);
        imgControlMemory2 = (ImageView) findViewById(R.id.imgControlMemory2);
        imgControlMemory3 = (ImageView) findViewById(R.id.imgControlMemory3);
        imgControlMemory4 = (ImageView) findViewById(R.id.imgControlMemory4);
        imgControlMemory5 = (ImageView) findViewById(R.id.imgControlMemory5);
        imgControlMemory6 = (ImageView) findViewById(R.id.imgControlMemory6);
        imgControlMemory7 = (ImageView) findViewById(R.id.imgControlMemory7);
        imgControlMemory8 = (ImageView) findViewById(R.id.imgControlMemory8);
        imgControlMemory9 = (ImageView) findViewById(R.id.imgControlMemory9);
        imgControlMemory10 = (ImageView) findViewById(R.id.imgControlMemory10);

        layMemory1 = (LinearLayout) findViewById(R.id.layMemory1);
        layMemory2 = (LinearLayout) findViewById(R.id.layMemory2);
        layMemory3 = (LinearLayout) findViewById(R.id.layMemory3);
        layMemory4 = (LinearLayout) findViewById(R.id.layMemory4);
        layMemory5 = (LinearLayout) findViewById(R.id.layMemory5);
        layMemory6 = (LinearLayout) findViewById(R.id.layMemory6);
        layMemory7 = (LinearLayout) findViewById(R.id.layMemory7);
        layMemory8 = (LinearLayout) findViewById(R.id.layMemory8);
        layMemory9 = (LinearLayout) findViewById(R.id.layMemory9);
        layMemory10 = (LinearLayout) findViewById(R.id.layMemory10);

        helpicon=(ImageView)findViewById(R.id.help);
        helpicon.setVisibility(View.GONE);


        SharedPreferences prefs = getSharedPreferences("code_help_Sms", MODE_PRIVATE);
        String restoredText = prefs.getString("code", null);
        if (restoredText != null) {

        }else
        {
            setviewHelp(layMemory1);
            SharedPreferences.Editor editor = getSharedPreferences("code_help_Sms", MODE_PRIVATE).edit();
            editor.putString("code", "1");
            editor.apply();
        }





        layMemory1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layMemory1);
                return true;
            }
        });

        layMemory2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layMemory2);

                return true;
            }
        });

        layMemory3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layMemory3);

                return true;
            }
        });
        layMemory4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layMemory4);

                return true;
            }
        });

        layMemory5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layMemory5);

                return true;
            }
        });

        layMemory6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layMemory6);

                return true;
            }
        });

        layMemory7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layMemory7);

                return true;
            }
        });

        layMemory8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layMemory8);

                return true;
            }
        });

        layMemory9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layMemory9);

                return true;
            }
        });

        layMemory10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(layMemory10);

                return true;
            }
        });





















        l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);
        l3=(LinearLayout)findViewById(R.id.l3);
        l4=(LinearLayout)findViewById(R.id.l4);
        nameoperator=(TextView)findViewById(R.id.nameoperator);
        bluicon=(ImageView)findViewById(R.id.bluIcon);
        desc=(TextView)findViewById(R.id.descrip);


        final ActivityMain main=new ActivityMain();
        main.SendBt("M-Sms?");


                //////////////////////////










        handler1 = new Handler();
        handler1.postDelayed(new Runnable(){
            public void run(){

                handler1.postDelayed(this, 500);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        nameoperator.setText(ActivityMain.nameOperator);

                    }
                });
                desc.setText(ActivityMain.LCD);
                setView(1,txtMemory1,imgControlMemory1,txtReportMemory1,txtTkzngMemory1);
                setView(2,txtMemory2,imgControlMemory2,txtReportMemory2,txtTkzngMemory2);
                setView(3,txtMemory3,imgControlMemory3,txtReportMemory3,txtTkzngMemory3);
                setView(4,txtMemory4,imgControlMemory4,txtReportMemory4,txtTkzngMemory4);
                setView(5,txtMemory5,imgControlMemory5,txtReportMemory5,txtTkzngMemory5);
                setView(6,txtMemory6,imgControlMemory6,txtReportMemory6,txtTkzngMemory6);
                setView(7,txtMemory7,imgControlMemory7,txtReportMemory7,txtTkzngMemory7);
                setView(8,txtMemory8,imgControlMemory8,txtReportMemory8,txtTkzngMemory8);
                setView(9,txtMemory9,imgControlMemory9,txtReportMemory9,txtTkzngMemory9);
                setView(10,txtMemory10,imgControlMemory10,txtReportMemory10,txtTkzngMemory10);

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




            }
        }, 0);







        layMemory1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
              go_edit(txtMemory1,1);
            }
        });

        layMemory2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
              go_edit(txtMemory2,2);
            }
        });

        layMemory3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
              go_edit(txtMemory3,3);
            }
        });

        layMemory4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
            go_edit(txtMemory4,4);
            }
        });

        layMemory5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
            go_edit(txtMemory5,5);
            }
        });

        layMemory6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
               go_edit(txtMemory6,6);
            }
        });

        layMemory7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
             go_edit(txtMemory7,7);
            }
        });

        layMemory8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
             go_edit(txtMemory8,8);
            }
        });

        layMemory9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
           go_edit(txtMemory9,9);
            }
        });

        layMemory10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
           go_edit(txtMemory10,10);
            }
        });





    }
    public void go_edit(TextView textView,int num){
        
        Intent intent = new Intent(G.currentActivity, ActivityEditSmsNumberMG4.class);
        intent.putExtra("MAMORY", ""+num);
        intent.putExtra("NAMBER", textView.getText().toString());
        intent.putExtra("CONTROL", ActivityMain.ControlSmsMemory[num]);
        intent.putExtra("TKZNG", ActivityMain.TkzngSmsMemory[num]);
        intent.putExtra("REPORT", ActivityMain.ReportSmsMemory[num]);
        G.currentActivity.startActivity(intent);
    }

    public void setView(int numberMemory,TextView txtNumber,ImageView imgControl,TextView txtReport,TextView txtTkzng){


        txtNumber.setText(ActivityMain.NumberSmsMemory[numberMemory]);
        if (ActivityMain.ControlSmsMemory[numberMemory].equals("1")){
            imgControl.setVisibility(View.VISIBLE);
        } else{imgControl.setVisibility(View.INVISIBLE);}
        if (ActivityMain.ReportSmsMemory[numberMemory].equals("0")){txtReport.setText("");}
        else if(ActivityMain.ReportSmsMemory[numberMemory].equals("1")){txtReport.setText("Full");}
        else if(ActivityMain.ReportSmsMemory[numberMemory].equals("2")){txtReport.setText("Economy");}

        if (ActivityMain.TkzngSmsMemory[numberMemory].equals("0")){
            txtTkzng.setText("");
        }else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("B")){
            txtTkzng.setText("دزدگیر فعال");
        }else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("C")){
            txtTkzng.setText("دزدگیر غیرفعال");
        }else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("D")){
            txtTkzng.setText("تغییر حالت دزدگیر");
        }



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

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    public void setviewHelp(View view){
        TapTargetView.showFor(this,                 // `this` is an Activity
                TapTarget.forView(view, "راهنما",
                        "تنظیمات مربوط به این حافظه پیامک در این قسمت نمایش داده میشود" +
                        "جهت تغییر بر روی آن کلیک کنید")

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
