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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.G;
import smart.SmartSetup.MGZ8.Edit.ActivityEditRemotNameMGZ8;
import smart.SmartSetup.MGZ8.adapters.adapterPartitionRemots;
import smart.SmartSetup.MGZ8.adapters.adapterRemots;
import smart.SmartSetup.MGZ8.models.Remote;
import smart.SmartSetup.MGZ8.models.partitionRemote;
import smart.SmartSetup.R;

public class ActivityRemoteNameMGZ8 extends EnhancedActivity {
public  static ActivityRemoteNameMGZ8 activityRemoteNameMGZ8;
ArrayList<view_descip> view_descips=new ArrayList<>();
MediaPlayer mediaPlayer;
  static RecyclerView recycleView;





Handler handler1;
    LinearLayout l1,l2,l3,l4;
    TextView nameoperator,desc;
    ImageView bluicon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mgz8_activity_remote_name);
activityRemoteNameMGZ8 =this;
ActivityMain.remoteList.clear();

        recycleView =  findViewById(R.id.recycleView);


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




//                String s= "";
//                for(String a : ActivityMain.Remot){
//                    s=s+""+a;
//                    Log.e("Remot",a+"");
//                }
//                Log.e("Remot",s+"");



            }
        }, 0);

      //  startShowListRemote(getApplicationContext());









//        layRemot1.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//
//                Intent intent = new Intent(G.currentActivity, ActivityEditRemotNameMGZ8.class);
//                intent.putExtra("REMOT", "1");
//                G.currentActivity.startActivity(intent);
//            }
//        });






//        view_descips.add(new view_descip(layRemot1,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
//        view_descips.add(new view_descip(layRemot2,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
//        view_descips.add(new view_descip(layRemot3,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
//        view_descips.add(new view_descip(layRemot4,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
//        view_descips.add(new view_descip(layRemot5,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
//        view_descips.add(new view_descip(layRemot6,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
//        view_descips.add(new view_descip(layRemot7,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
//        view_descips.add(new view_descip(layRemot8,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
//        view_descips.add(new view_descip(layRemot9,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));
//        view_descips.add(new view_descip(layRemot10,"توضیح","نام شخص استفاده کننده از ریموت را اینجا وارد کنید\n(حداکثر 10 حرف)\nمثال:نگهبان"));


//     layRemot1.setOnLongClickListener(new View.OnLongClickListener() {
//         @Override
//         public boolean onLongClick(View view) {
//             setviewHelp(view_descips.get(0));
//             return true;
//         }
//     });
//





    }

    public static void startShowListRemote(Context context){
        List<Remote> part1 = new ArrayList<>();
        List<Remote> part2 = new ArrayList<>();

        for (int i = 0;i<ActivityMain.remoteList.size();i++){
            int j  = i+1;
            ActivityMain.remoteList.get(i).setNumRemote(j+"");

            if (ActivityMain.remoteList.get(i).getPartitionName() == 1){
                part1.add(ActivityMain.remoteList.get(i));
            }else {
                part2.add(ActivityMain.remoteList.get(i));

            }

        }


       //Collections.sort(ActivityMain.remoteList);

        List<partitionRemote> partitionRemoteList = new ArrayList<>();

        partitionRemote  partitionRemote1 =new partitionRemote();
        partitionRemote1.setName("پارتیشن یک");
        partitionRemote1.setRemoteList(part1);

        partitionRemote  partitionRemote2 =new partitionRemote();
        partitionRemote2.setName("پارتیشن دو");
        partitionRemote2.setRemoteList(part2);

        partitionRemoteList.add(partitionRemote1);
        partitionRemoteList.add(partitionRemote2);

        adapterPartitionRemots adapterPartitionRemots = new adapterPartitionRemots(context,partitionRemoteList);
        recycleView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.VERTICAL,false));

        recycleView.setAdapter(adapterPartitionRemots);
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
        startActivity(new Intent(G.currentActivity, Activity_List_MGZ8.class));
        finish();
        super.onBackPressed();
    }

}
