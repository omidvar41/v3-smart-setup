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
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.ArrayList;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.BluetoothSPPConnection;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MGZ8.Edit.ActivityEditOutNameMGZ8;
import smart.SmartSetup.MGZ8.adapters.adapterOut;
import smart.SmartSetup.MGZ8.models.OutName;
import smart.SmartSetup.R;

public class ActivityOutNameMGZ8 extends EnhancedActivity {
public  static ActivityOutNameMGZ8 activityOutNameMGZ8;


    BluetoothSPPConnection mBluetoothSPPConnection;

    public static RecyclerView recycleView;


    Handler handler1;
    LinearLayout l1,l2,l3,l4;
    TextView nameoperator,desc;
    ImageView bluicon;
ArrayList<view_descip> view_descips=new ArrayList<>();

MediaPlayer mediaPlayer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mgz8_activity_out_name);
activityOutNameMGZ8 =this;

        recycleView = findViewById(R.id.recycleView);





        l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);
        l3=(LinearLayout)findViewById(R.id.l3);
        l4=(LinearLayout)findViewById(R.id.l4);
        nameoperator=(TextView)findViewById(R.id.nameoperator);
        bluicon=(ImageView)findViewById(R.id.bluIcon);
        desc=(TextView)findViewById(R.id.descrip);
        ///......................................................................................

        ActivityMain main=new ActivityMain();
        main.SendBt("Out?");

        final adapterOut adapterOut = new adapterOut(getApplicationContext(),ActivityMain.outNameList) {
            @Override
            public void click(OutName OutName,int pos) {
                if (pos!=2){
                    Intent intent = new Intent(G.currentActivity, ActivityEditOutNameMGZ8.class);
                    intent.putExtra("OUT", pos+"");
                    intent.putExtra("valu", OutName.getName()+"");
                    G.currentActivity.startActivity(intent);
                }

            }

            @Override
            public void longClick(OutName OutName) {

            }
        };

        recycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        recycleView.setAdapter(adapterOut);



        handler1 = new Handler();
        handler1.postDelayed(new Runnable(){
            public void run(){

                handler1.postDelayed(this, 500);
           adapterOut.notifyDataSetChanged();


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



            }
        }, 0);








//        view_descips.add(new view_descip(layOutName1,"توضیح","نام دستگاهی که توسط این خروجی کنترل  میشود را در قسمت وارد کنید\nحداکثر 10 حرف \nمثال:در بازکن"));
//        view_descips.add(new view_descip(layOutName2,"توضیح","نام دستگاهی که توسط این خروجی  کنترل  میشود را در قسمت وارد کنید\nحداکثر 10 حرف \nمثال:فن"));
//        view_descips.add(new view_descip(layOutName3,"توضیح","نام دستگاهی که توسط این خروجی کنترل  میشود را در قسمت وارد کنید\nحداکثر 10 حرف \nمثال:لامپ"));
//layOutName1.setOnLongClickListener(new View.OnLongClickListener() {
//    @Override
//    public boolean onLongClick(View view) {
//        setviewHelp(view_descips.get(0));
//
//        return true;
//    }
//});
//
//
//
//        layOutName2.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                setviewHelp(view_descips.get(1));
//                return true;
//            }
//        });
//
//
//        layOutName3.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                setviewHelp(view_descips.get(2));
//                return true;
//            }
//        });
//
//



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

    private void hellpOutNameDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(G.currentActivity);
        builder.setTitle("توضیح");
        builder.setMessage("نام دستگاهی که توسط خروجی مورد نظر کنترل  میشود را در اینجا وارد کنید" + "\n" + "(حداکثر 10 حرف)" + "\n" + "مثال: پمپ آب");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }


    @Override
    protected void onPause() {
        super.onPause();

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
        startActivity(new Intent(G.currentActivity, Activity_List_MGZ8.class));
        finish();

    }

}