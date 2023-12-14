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

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.G4.Edit.ActivityEditSmsNumberG4;
import smart.SmartSetup.R;

/**
 * Created by Roholah on 30/06/2017.
 */

public class ActivitySmsNumberG4 extends EnhancedActivity {
public  static ActivitySmsNumberG4 activitySmsNumberG4;
    public static String Comaand;
    public static String ComaandText;

    ImageView bluicon;
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

    static TextView      txtReportSmsMemory1;
    static TextView      txtReportSmsMemory2;
    static TextView      txtReportSmsMemory3;
    static TextView      txtReportSmsMemory4;
    static TextView      txtReportSmsMemory5;
    static TextView      txtReportSmsMemory6;
    static TextView      txtReportSmsMemory7;
    static TextView      txtReportSmsMemory8;
    static TextView      txtReportSmsMemory9;
    static TextView      txtReportSmsMemory10;

    static TextView      txtTkzngSmsMemory1;
    static TextView      txtTkzngSmsMemory2;
    static TextView      txtTkzngSmsMemory3;
    static TextView      txtTkzngSmsMemory4;
    static TextView      txtTkzngSmsMemory5;
    static TextView      txtTkzngSmsMemory6;
    static TextView      txtTkzngSmsMemory7;
    static TextView      txtTkzngSmsMemory8;
    static TextView      txtTkzngSmsMemory9;
    static TextView      txtTkzngSmsMemory10;

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

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g4_activity_sms_number);
activitySmsNumberG4=this;
bluicon=(ImageView)findViewById(R.id.bluIcon);
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

        txtReportSmsMemory1 = (TextView) findViewById(R.id.txtReportMemory1);
        txtReportSmsMemory2 = (TextView) findViewById(R.id.txtReportMemory2);
        txtReportSmsMemory3 = (TextView) findViewById(R.id.txtReportMemory3);
        txtReportSmsMemory4 = (TextView) findViewById(R.id.txtReportMemory4);
        txtReportSmsMemory5 = (TextView) findViewById(R.id.txtReportMemory5);
        txtReportSmsMemory6 = (TextView) findViewById(R.id.txtReportMemory6);
        txtReportSmsMemory7 = (TextView) findViewById(R.id.txtReportMemory7);
        txtReportSmsMemory8 = (TextView) findViewById(R.id.txtReportMemory8);
        txtReportSmsMemory9 = (TextView) findViewById(R.id.txtReportMemory9);
        txtReportSmsMemory10 = (TextView) findViewById(R.id.txtReportMemory10);

        txtTkzngSmsMemory1 = (TextView) findViewById(R.id.txtTkzngMemory1);
        txtTkzngSmsMemory2 = (TextView) findViewById(R.id.txtTkzngMemory2);
        txtTkzngSmsMemory3 = (TextView) findViewById(R.id.txtTkzngMemory3);
        txtTkzngSmsMemory4 = (TextView) findViewById(R.id.txtTkzngMemory4);
        txtTkzngSmsMemory5 = (TextView) findViewById(R.id.txtTkzngMemory5);
        txtTkzngSmsMemory6 = (TextView) findViewById(R.id.txtTkzngMemory6);
        txtTkzngSmsMemory7 = (TextView) findViewById(R.id.txtTkzngMemory7);
        txtTkzngSmsMemory8 = (TextView) findViewById(R.id.txtTkzngMemory8);
        txtTkzngSmsMemory9 = (TextView) findViewById(R.id.txtTkzngMemory9);
        txtTkzngSmsMemory10 = (TextView) findViewById(R.id.txtTkzngMemory10);

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
        ActivityMain main=new ActivityMain();
        main.SendBt("M-Sms?");







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




                setView(1,txtMemory1,imgControlMemory1,txtReportSmsMemory1,txtTkzngSmsMemory1);
                setView(2,txtMemory2,imgControlMemory2,txtReportSmsMemory2,txtTkzngSmsMemory2);
                setView(3,txtMemory3,imgControlMemory3,txtReportSmsMemory3,txtTkzngSmsMemory3);
                setView(4,txtMemory4,imgControlMemory4,txtReportSmsMemory4,txtTkzngSmsMemory4);
                setView(5,txtMemory5,imgControlMemory5,txtReportSmsMemory5,txtTkzngSmsMemory5);
                setView(6,txtMemory6,imgControlMemory6,txtReportSmsMemory6,txtTkzngSmsMemory6);
                setView(7,txtMemory7,imgControlMemory7,txtReportSmsMemory7,txtTkzngSmsMemory7);
                setView(8,txtMemory8,imgControlMemory8,txtReportSmsMemory8,txtTkzngSmsMemory8);
                setView(9,txtMemory9,imgControlMemory9,txtReportSmsMemory9,txtTkzngSmsMemory9);
                setView(10,txtMemory10,imgControlMemory10,txtReportSmsMemory10,txtTkzngSmsMemory10);




            }
        }, 0);





        layMemory1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditSmsNumberG4.class);
                intent.putExtra("MAMORY", "1");
                intent.putExtra("NAMBER", txtMemory1.getText().toString());
                intent.putExtra("CONTROL", ActivityMain.ControlSmsMemory[1]);
                intent.putExtra("TKZNG", ActivityMain.TkzngSmsMemory[1]);
                intent.putExtra("REPORT", ActivityMain.ReportSmsMemory[1]);

                G.currentActivity.startActivity(intent);
            }
        });

        layMemory2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditSmsNumberG4.class);
                intent.putExtra("MAMORY", "2");
                intent.putExtra("NAMBER", txtMemory2.getText().toString());
                intent.putExtra("CONTROL", ActivityMain.ControlSmsMemory[2]);
                intent.putExtra("TKZNG", ActivityMain.TkzngSmsMemory[2]);
                intent.putExtra("REPORT", ActivityMain.ReportSmsMemory[2]);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditSmsNumberG4.class);
                intent.putExtra("MAMORY", "3");
                intent.putExtra("NAMBER", txtMemory3.getText().toString());
                intent.putExtra("CONTROL", ActivityMain.ControlSmsMemory[3]);
                intent.putExtra("TKZNG", ActivityMain.TkzngSmsMemory[3]);
                intent.putExtra("REPORT", ActivityMain.ReportSmsMemory[3]);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditSmsNumberG4.class);
                intent.putExtra("MAMORY", "4");
                intent.putExtra("NAMBER", txtMemory4.getText().toString());
                intent.putExtra("CONTROL", ActivityMain.ControlSmsMemory[4]);
                intent.putExtra("TKZNG", ActivityMain.TkzngSmsMemory[4]);
                intent.putExtra("REPORT", ActivityMain.ReportSmsMemory[4]);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditSmsNumberG4.class);
                intent.putExtra("MAMORY", "5");
                intent.putExtra("NAMBER", txtMemory5.getText().toString());
                intent.putExtra("CONTROL", ActivityMain.ControlSmsMemory[5]);
                intent.putExtra("TKZNG", ActivityMain.TkzngSmsMemory[5]);
                intent.putExtra("REPORT", ActivityMain.ReportSmsMemory[5]);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditSmsNumberG4.class);
                intent.putExtra("MAMORY", "6");
                intent.putExtra("NAMBER", txtMemory6.getText().toString());
                intent.putExtra("CONTROL", ActivityMain.ControlSmsMemory[6]);
                intent.putExtra("TKZNG", ActivityMain.TkzngSmsMemory[6]);
                intent.putExtra("REPORT", ActivityMain.ReportSmsMemory[6]);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditSmsNumberG4.class);
                intent.putExtra("MAMORY", "7");
                intent.putExtra("NAMBER", txtMemory7.getText().toString());
                intent.putExtra("CONTROL", ActivityMain.ControlSmsMemory[7]);
                intent.putExtra("TKZNG", ActivityMain.TkzngSmsMemory[7]);
                intent.putExtra("REPORT", ActivityMain.ReportSmsMemory[7]);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditSmsNumberG4.class);
                intent.putExtra("MAMORY", "8");
                intent.putExtra("NAMBER", txtMemory8.getText().toString());
                intent.putExtra("CONTROL", ActivityMain.ControlSmsMemory[8]);
                intent.putExtra("TKZNG", ActivityMain.TkzngSmsMemory[8]);
                intent.putExtra("REPORT", ActivityMain.ReportSmsMemory[8]);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditSmsNumberG4.class);
                intent.putExtra("MAMORY", "9");
                intent.putExtra("NAMBER", txtMemory9.getText().toString());
                intent.putExtra("CONTROL", ActivityMain.ControlSmsMemory[9]);
                intent.putExtra("TKZNG", ActivityMain.TkzngSmsMemory[9]);
                intent.putExtra("REPORT", ActivityMain.ReportSmsMemory[9]);
                G.currentActivity.startActivity(intent);
            }
        });

        layMemory10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityEditSmsNumberG4.class);
                intent.putExtra("MAMORY", "10");
                intent.putExtra("NAMBER", txtMemory10.getText().toString());
                intent.putExtra("CONTROL", ActivityMain.ControlSmsMemory[10]);
                intent.putExtra("TKZNG", ActivityMain.TkzngSmsMemory[10]);
                intent.putExtra("REPORT", ActivityMain.ReportSmsMemory[10]);
                G.currentActivity.startActivity(intent);
            }
        });



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
        }
        else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("1")){
            txtTkzng.setText("فعال کردن OUT1");
        }
        else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("2")){
            txtTkzng.setText("فعال کردن OUT2");
        }
        else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("3")){
            txtTkzng.setText("غیرفعال کردن OUT2 ");
        }
        else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("4")){
            txtTkzng.setText("تغییر حالت OUT2");
        }
        else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("5")){
            txtTkzng.setText("فعال کردن OUT3");
        }
        else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("6")){
            txtTkzng.setText("غیرفعال کردن OUT3");
        }
        else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("7")){
            txtTkzng.setText("تغییر حالت OUT3");
        }
        else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("8")){
            txtTkzng.setText("فعال کردن OUT4");
        }
        else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("9")){
            txtTkzng.setText("غیرفعال کردن OUT4");
        }   else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("A")){
            txtTkzng.setText("تغییر حالت OUT4");
        } else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("B")){
            txtTkzng.setText("دزدگیر فعال");
        }else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("C")){
            txtTkzng.setText("دزدگیر غیرفعال");
        }else if (ActivityMain.TkzngSmsMemory[numberMemory].equals("D")){
            txtTkzng.setText("تغییر حالت دزدگیر");
        }



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
