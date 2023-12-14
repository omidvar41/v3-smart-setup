package smart.SmartSetup.MGZ8;

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

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MGZ8.Edit.ActivityEditPhoneNumberMGZ8;
import smart.SmartSetup.MGZ8.Edit.ActivityEditSmsNumberMGZ8;
import smart.SmartSetup.MGZ8.Edit.ActivityEditTypeTrigMGZ8;
import smart.SmartSetup.MGZ8.adapters.adapterPhoneNumber;
import smart.SmartSetup.MGZ8.models.phoneNumber;
import smart.SmartSetup.R;

public class ActivitySmsNumberMGZ8 extends EnhancedActivity {
    public static ActivitySmsNumberMGZ8 activitySmsNumberMGZ8;
    public static String Comaand;
    public static String ComaandText;
   public static RecyclerView recyclerView;

    LinearLayout    laycitycode;

    LinearLayout    layTypeTring;
    Handler handler1;
    LinearLayout l1,l2,l3,l4;
    TextView nameoperator,desc,txtTypeTrig,txtcitycode;
    ImageView bluicon,helpicon;
    public static String nameOperator="";
MediaPlayer mediaPlayer;
    ActivityMain main;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mgz8_activity_sms_number);
        activitySmsNumberMGZ8 =this;
main=new ActivityMain();

recyclerView = findViewById(R.id.recycleView);
recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        adapterPhoneNumber adapterPhoneNumber = new adapterPhoneNumber(getApplicationContext(), ActivityMain.phoneNumberList) {
            @Override
            public void click(phoneNumber phoneNumber) {
                Intent intent = new Intent(G.currentActivity, ActivityEditSmsNumberMGZ8.class);
                intent.putExtra("phoneNumber",phoneNumber);

                G.currentActivity.startActivity(intent);
            }

            @Override
            public void clickTest(phoneNumber phoneNumber) {
                Intent intent=new Intent(getApplicationContext(), dialog_select_type_call_MGZ8.class);
                intent.putExtra("code",phoneNumber.getNumMemory()+"");
                intent.putExtra("number",phoneNumber.getNumber());
                intent.putExtra("selection",phoneNumber.getMisCallControl()+"");
                startActivity(intent);
            }
        };
recyclerView.setAdapter(adapterPhoneNumber);

        laycitycode= findViewById(R.id.laycitycode);
        layTypeTring =   findViewById(R.id.typetriger);

        txtTypeTrig =  findViewById(R.id.txtTrtiger);
        txtcitycode =   findViewById(R.id.txtcitycode);


        helpicon=(ImageView)findViewById(R.id.help);
        helpicon.setVisibility(View.GONE);


        SharedPreferences prefs = getSharedPreferences("code_help_Sms", MODE_PRIVATE);
        String restoredText = prefs.getString("code", null);
        if (restoredText != null) {

        }else
        {
          //  setviewHelp(layMemory1);
            SharedPreferences.Editor editor = getSharedPreferences("code_help_Sms", MODE_PRIVATE).edit();
            editor.putString("code", "1");
            editor.apply();
        }







//        layMemory10.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                setviewHelp(layMemory10);
//
//                return true;
//            }
//        });

        l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);
        l3=(LinearLayout)findViewById(R.id.l3);
        l4=(LinearLayout)findViewById(R.id.l4);
        nameoperator=(TextView)findViewById(R.id.nameoperator);
        bluicon=(ImageView)findViewById(R.id.bluIcon);
        desc=(TextView)findViewById(R.id.descrip);


        final ActivityMain main=new ActivityMain();
        main.SendBt("PHON?");


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


                if (ActivityMain.typeTriger.equals("1")){
                    txtTypeTrig.setText("سطحی");
                }else {
                    txtTypeTrig.setText("لحظه ای");

                }

                txtcitycode.setText(ActivityMain.cityCode);


            }
        }, 0);



        laycitycode.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(G.currentActivity, ActivityEditPhoneNumberMGZ8.class);
                intent.putExtra("MAMORY", "0");
                intent.putExtra("valu", txtcitycode.getText().toString()+"");
                intent.putExtra("desc", txtcitycode.getText().toString()+"");

                startActivity(intent);
            }

        });

        layTypeTring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(ActivitySmsNumberMGZ8.this, ActivityEditTypeTrigMGZ8.class);
                intent.putExtra("code",txtTypeTrig.getText().toString());
                startActivity(intent);
            }
        });









    }
    public void go_edit(TextView textView,int num){

        Intent intent = new Intent(G.currentActivity, ActivityEditSmsNumberMGZ8.class);
        intent.putExtra("MAMORY", ""+num);
        intent.putExtra("NAMBER", textView.getText().toString());
        intent.putExtra("CONTROL", ActivityMain.ControlSmsMemory[num]);
        intent.putExtra("TKZNG", ActivityMain.TkzngSmsMemory[num]);
        intent.putExtra("REPORT", ActivityMain.ReportSmsMemory[num]);
        G.currentActivity.startActivity(intent);
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
