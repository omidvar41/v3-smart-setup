package smart.SmartSetup.MG4;

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
import android.widget.TextView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.ArrayList;

import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.G;
import smart.SmartSetup.MG4.Edit.ActivityEditRemotNameMG4;
import smart.SmartSetup.R;

public class ActivityRemoteNameMG4 extends EnhancedActivity {
public  static smart.SmartSetup.MG4.ActivityRemoteNameMG4 activityRemoteNameMG4;
ArrayList<view_descip> view_descips=new ArrayList<>();
MediaPlayer mediaPlayer;
    static TextView txtRemot1;
    static TextView     txtRemot2;
    static TextView     txtRemot3;
    static TextView     txtRemot4;
    static TextView     txtRemot5;
    static TextView     txtRemot6;
    static TextView     txtRemot7;
    static TextView     txtRemot8;
    static TextView     txtRemot9;
    static TextView     txtRemot10;

    static LinearLayout layRemot1;
    static LinearLayout layRemot2;
    static LinearLayout layRemot3;
    static LinearLayout layRemot4;
    static LinearLayout layRemot5;
    static LinearLayout layRemot6;
    static LinearLayout layRemot7;
    static LinearLayout layRemot8;
    static LinearLayout layRemot9;
    static LinearLayout layRemot10;



Handler handler1;
    LinearLayout l1,l2,l3,l4;
    TextView nameoperator,desc;
    ImageView bluicon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mg4_activity_remote_name);
activityRemoteNameMG4 =this;
        txtRemot1 = (TextView) findViewById(R.id.txtRemot1);
        txtRemot2 = (TextView) findViewById(R.id.txtRemot2);
        txtRemot3 = (TextView) findViewById(R.id.txtRemot3);
        txtRemot4 = (TextView) findViewById(R.id.txtRemot4);
        txtRemot5 = (TextView) findViewById(R.id.txtRemot5);
        txtRemot6 = (TextView) findViewById(R.id.txtRemot6);
        txtRemot7 = (TextView) findViewById(R.id.txtRemot7);
        txtRemot8 = (TextView) findViewById(R.id.txtRemot8);
        txtRemot9 = (TextView) findViewById(R.id.txtRemot9);
        txtRemot10 = (TextView) findViewById(R.id.txtRemot10);

        layRemot1 = (LinearLayout) findViewById(R.id.layRemot1);
        layRemot2 = (LinearLayout) findViewById(R.id.layRemot2);
        layRemot3 = (LinearLayout) findViewById(R.id.layRemot3);
        layRemot4 = (LinearLayout) findViewById(R.id.layRemot4);
        layRemot5 = (LinearLayout) findViewById(R.id.layRemot5);
        layRemot6 = (LinearLayout) findViewById(R.id.layRemot6);
        layRemot7 = (LinearLayout) findViewById(R.id.layRemot7);
        layRemot8 = (LinearLayout) findViewById(R.id.layRemot8);
        layRemot9 = (LinearLayout) findViewById(R.id.layRemot9);
        layRemot10 = (LinearLayout) findViewById(R.id.layRemot10);


        l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);
        l3=(LinearLayout)findViewById(R.id.l3);
        l4=(LinearLayout)findViewById(R.id.l4);
        nameoperator=(TextView)findViewById(R.id.nameoperator);
        bluicon=(ImageView)findViewById(R.id.bluIcon);
        desc=(TextView)findViewById(R.id.descrip);

        ActivityMain main=new ActivityMain();

        main.SendBt("Remot?");










        handler1 = new Handler();
        handler1.postDelayed(new Runnable(){
            public void run(){

                handler1.postDelayed(this, 500);



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
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        nameoperator.setText(ActivityMain.nameOperator);

                    }
                });
                desc.setText(ActivityMain.LCD);






                switch (ActivityMain.Remot[11]) {

                    case "10":
                        layRemot10.setVisibility(View.VISIBLE);
                        txtRemot10.setText(ActivityMain.Remot[10]);

                    case "9":
                        // ActivityRemotNameG4.layRemot9.setVisibility(View.VISIBLE);
                        layRemot9.setVisibility(View.VISIBLE);
                        txtRemot9.setText(ActivityMain.Remot[9]);

                        // ActivityRemotNameG4.txtRemot9.setText(text);
                    case "8":
                        layRemot8.setVisibility(View.VISIBLE);
                        txtRemot8.setText(ActivityMain.Remot[8]);
                    case "7":
                        layRemot7.setVisibility(View.VISIBLE);
                        txtRemot7.setText(ActivityMain.Remot[7]);
                    case "6":
                        layRemot6.setVisibility(View.VISIBLE);
                        txtRemot6.setText(ActivityMain.Remot[6]);
                    case "5":
                        layRemot5.setVisibility(View.VISIBLE);
                        txtRemot5.setText(ActivityMain.Remot[5]);
                    case "4":
                        layRemot4.setVisibility(View.VISIBLE);
                        txtRemot4.setText(ActivityMain.Remot[4]);
                    case "3":
                        layRemot3.setVisibility(View.VISIBLE);
                        txtRemot3.setText(ActivityMain.Remot[3]);
                    case "2":
                        layRemot2.setVisibility(View.VISIBLE);
                        txtRemot2.setText(ActivityMain.Remot[2]);
                    case "1":
                        layRemot1.setVisibility(View.VISIBLE);
                        txtRemot1.setText(ActivityMain.Remot[1]);
                }



            }
        }, 0);








        layRemot1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditRemotNameMG4.class);
                intent.putExtra("REMOT", "1");
                G.currentActivity.startActivity(intent);
            }
        });

        layRemot2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditRemotNameMG4.class);
                intent.putExtra("REMOT", "2");

                G.currentActivity.startActivity(intent);
            }
        });

        layRemot3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditRemotNameMG4.class);
                intent.putExtra("REMOT", "3");

                G.currentActivity.startActivity(intent);
            }
        });

        layRemot4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditRemotNameMG4.class);
                intent.putExtra("REMOT", "4");

                G.currentActivity.startActivity(intent);
            }
        });

        layRemot5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditRemotNameMG4.class);
                intent.putExtra("REMOT", "5");

                G.currentActivity.startActivity(intent);
            }
        });

        layRemot6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditRemotNameMG4.class);
                intent.putExtra("REMOT", "6");

                G.currentActivity.startActivity(intent);
            }
        });

        layRemot7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditRemotNameMG4.class);
                intent.putExtra("REMOT", "7");

                G.currentActivity.startActivity(intent);
            }
        });

        layRemot8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditRemotNameMG4.class);
                intent.putExtra("REMOT", "8");

                G.currentActivity.startActivity(intent);
            }
        });

        layRemot9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditRemotNameMG4.class);
                intent.putExtra("REMOT", "9");

                G.currentActivity.startActivity(intent);
            }
        });

        layRemot10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                Intent intent = new Intent(G.currentActivity, ActivityEditRemotNameMG4.class);
                intent.putExtra("REMOT", "10");

                G.currentActivity.startActivity(intent);
            }
        });







        view_descips.add(new view_descip(layRemot1,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
        view_descips.add(new view_descip(layRemot2,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
        view_descips.add(new view_descip(layRemot3,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
        view_descips.add(new view_descip(layRemot4,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
        view_descips.add(new view_descip(layRemot5,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
        view_descips.add(new view_descip(layRemot6,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
        view_descips.add(new view_descip(layRemot7,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
        view_descips.add(new view_descip(layRemot8,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
        view_descips.add(new view_descip(layRemot9,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
        view_descips.add(new view_descip(layRemot10,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));


     layRemot1.setOnLongClickListener(new View.OnLongClickListener() {
         @Override
         public boolean onLongClick(View view) {
             setviewHelp(view_descips.get(0));
             return true;
         }
     });
        layRemot2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(1));
                return true;
            }
        });
        layRemot3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(2));
                return true;
            }
        });
        layRemot4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(3));
                return true;
            }
        });
        layRemot5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(4));
                return true;
            }
        });
        layRemot6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(5));
                return true;
            }
        });
        layRemot7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(6));
                return true;
            }
        });
        layRemot8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(7));
                return true;
            }
        });
        layRemot9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(8));
                return true;
            }
        });
        layRemot10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(9));
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
    private void hellpRemotNameDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(G.currentActivity);
        builder.setTitle("توضیح");
        builder.setMessage("نام شخص استفاده کننده از ریموت را در اینجا وارد کنید." + "\n" + "(حداکثر 10 حرف)"
                + "\n" + "مثال: نگهبان");
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
        startActivity(new Intent(G.currentActivity, Activity_List_MG4.class));
        finish();
        super.onBackPressed();
    }

}
