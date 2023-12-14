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
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MGZ8.Edit.ActivityEditZonNameMGZ8;
import smart.SmartSetup.MGZ8.adapters.adapterPartitionRemots;
import smart.SmartSetup.MGZ8.adapters.adapterPartitionZon;
import smart.SmartSetup.MGZ8.adapters.adapterZon;
import smart.SmartSetup.MGZ8.models.Remote;
import smart.SmartSetup.MGZ8.models.Zon;
import smart.SmartSetup.MGZ8.models.partitionRemote;
import smart.SmartSetup.MGZ8.models.partitionZon;
import smart.SmartSetup.R;

public class ActivityZonNameMGZ8 extends EnhancedActivity {
    public static ActivityZonNameMGZ8 activityZonNameMGZ8;

    MediaPlayer mediaPlayer;
    public  static RecyclerView recycleView;


Handler handler1;
    ActivityMain main2=new ActivityMain();

    LinearLayout l1,l2,l3,l4;
    TextView nameoperator,desc;
    ImageView bluicon;

   // String test = "ZONNAME,1_005A004F004E0031_1_1_1_0,2_005A004F004E0032_2_2_0_1,3_005A004F004E0033_3_3_0_0,4_005A004F004E0034_4_4_0_1";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mgz8_activity_zon_name);
        activityZonNameMGZ8 =this;
        recycleView = findViewById(R.id.recycleView);



        l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);
        l3=(LinearLayout)findViewById(R.id.l3);
        l4=(LinearLayout)findViewById(R.id.l4);
        nameoperator=(TextView)findViewById(R.id.nameoperator);
        bluicon=(ImageView)findViewById(R.id.bluIcon);
        desc=(TextView)findViewById(R.id.descrip);

          ActivityMain main=new ActivityMain();


        main.SendBt("Zon?");


        handler1 = new Handler();





        handler1.postDelayed(new Runnable(){
            public void run(){

                handler1.postDelayed(this, 500);


                if (!G.connected){
                    bluicon.setImageResource(R.drawable.blutose_disable);


                }
                if (G.connected) {
                    bluicon.setImageResource(R.drawable.blutose_enable);
                }

                switch (ActivityMain.numAn){


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



                //    main2.SendBt("ZONS?");



            }
        }, 0);


        startShowListZon(getApplicationContext());




    }


    public static   void startShowListZon(Context context) {
        Log.e("Rmmfdss",ActivityMain.zonList.size()+"");
        List<Zon> part1 = new ArrayList<>();
        List<Zon> part2 = new ArrayList<>();
        List<Zon> part3 = new ArrayList<>();
        List<Zon> part4 = new ArrayList<>();

        for (Zon zon : ActivityMain.zonList) {
            if (zon.getPartition().equals("1")) {
                part1.add(zon);
            } else if (zon.getPartition().equals("2")) {
                part2.add(zon);

            } else if (zon.getPartition().equals("3")) {
                part3.add(zon);

            } else {
                part4.add(zon);

            }

            //Collections.sort(ActivityMain.remoteList);

            List<partitionZon> partitionZonList = new ArrayList<>();

            partitionZon partitionZon1 = new partitionZon();
            partitionZon1.setName("پارتیشن یک");
            partitionZon1.setZonList(part1);

            partitionZon partitionZon2 = new partitionZon();
            partitionZon2.setName("پارتیشن دو");
            partitionZon2.setZonList(part2);


            partitionZon partitionZon3 = new partitionZon();
            partitionZon3.setName("مشترک");
            partitionZon3.setZonList(part3);


            partitionZon partitionZon4 = new partitionZon();
            partitionZon4.setName("دوگانه");
            partitionZon4.setZonList(part4);

            if (partitionZon1.getZonList().size() != 0 ){
                partitionZonList.add(partitionZon1);

            }else {

            }
////////////////////
            if (partitionZon2.getZonList().size() != 0 ){
                partitionZonList.add(partitionZon2);

            }else {

            }
///////////////////////
            if (partitionZon3.getZonList().size() != 0 ){
                partitionZonList.add(partitionZon3);

            }else {

            }
////////////////////
            if (partitionZon4.getZonList().size() != 0 ){
                partitionZonList.add(partitionZon4);

            }else {

            }

            adapterPartitionZon adapterPartitionZon = new adapterPartitionZon(context, partitionZonList);
            recycleView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));

            recycleView.setAdapter(adapterPartitionZon);
        }

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
    public void setviewHelp(View view){
        TapTargetView.showFor(this,                 // `this` is an Activity
                TapTarget.forView(view, "توضیح","نام محل نصب زون مربوطه را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:درب سالن")

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
    private void hellpZonNameDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(G.currentActivity);
        builder.setTitle("توضیح");
        builder.setMessage("نام محل نصب زون مربوطه را اینجا وارد کنید" + "\n" + "(حداکثر 10 حرف)" + "\n" + "مثال: درب سالن");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }

    @Override
    protected void onPause() {
//        if (handler1 != null){
//            handler1.removeCallbacksAndMessages(null);
//
//        }
        Log.e("LifeCycle","p");
        super.onPause();

    }


    @Override
    protected void onResume() {
       // startHandler();
        Log.e("LifeCycle","r");

        super.onResume();
    }

    @Override
    protected void onDestroy() {
        if (handler1 != null){
            handler1.removeCallbacksAndMessages(null);

        }
        ActivityMain.zonList.clear();
        finish();
        super.onDestroy();
    }
    @Override
    public void onBackPressed() {
        if (handler1 != null){
            handler1.removeCallbacksAndMessages(null);

        }

        startActivity(new Intent(G.currentActivity, Activity_List_MGZ8.class));
        finish();
        super.onBackPressed();
    }
}
