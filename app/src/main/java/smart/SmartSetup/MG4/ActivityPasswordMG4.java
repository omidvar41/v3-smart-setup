package smart.SmartSetup.MG4;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import info.hoang8f.widget.FButton;
import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.R;

public class ActivityPasswordMG4 extends EnhancedActivity {
    EditText edtOldPassword;
    EditText edtNewPassword;
    EditText edtVerifyPassword;
public static smart.SmartSetup.MG4.ActivityPasswordMG4 activityPasswordMG4;
    FButton btnSavePassword
    ,btnExitPassword;
    LinearLayout l1,l2,l3,l4;
    TextView nameoperator,desc;
    ImageView bluicon;

    Handler handler1;
    MediaPlayer mediaPlayer;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mg4_activity_password);
        activityPasswordMG4 =this;
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
        edtOldPassword = (EditText) findViewById(R.id.edtOldPassword);
        edtNewPassword = (EditText) findViewById(R.id.edtNewPassword);
        edtVerifyPassword = (EditText) findViewById(R.id.edtVerifyPassword);

        btnSavePassword = (FButton) findViewById(R.id.btnSavePassword);
        btnSavePassword.setButtonColor(getResources().getColor(R.color.white));

        btnExitPassword = (FButton) findViewById(R.id.btnExitPassword);
        btnExitPassword.setButtonColor(getResources().getColor(R.color.white));

        l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);
        l3=(LinearLayout)findViewById(R.id.l3);
        l4=(LinearLayout)findViewById(R.id.l4);
        nameoperator=(TextView)findViewById(R.id.nameoperator);
        bluicon=(ImageView)findViewById(R.id.bluIcon);
        desc=(TextView)findViewById(R.id.descrip);
        ///...............................................................



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





            }
        }, 0);



        btnSavePassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                //      edtNewPassword.g

                String str = edtNewPassword.getText().toString();
                if (edtOldPassword.length() == 0) {
                    //Toast.makeText(G.context, "رمز قدیم را وارد کنید", Toast.LENGTH_SHORT).show();
                    edtOldPassword.setError("رمز قدیم را وارد کنید");
                }
                else if (edtNewPassword.length() == 0) {
                   // Toast.makeText(G.context, "رمز جدید را وارد کنید", Toast.LENGTH_SHORT).show();
                    edtNewPassword.setError("رمز جدید را وارد کنید");

                }
                else if (edtVerifyPassword.length() == 0) {
                    edtVerifyPassword.setError("رمز جدید را وارد کنید");

                }
                else if (edtOldPassword.length() != 4) {

                    edtOldPassword.setError("رمز باید چهار رقمی باشد");

                }
                else if (edtNewPassword.length() != 4) {
                    edtNewPassword.setError("رمز باید چهار رقمی باشد");

                }
                else if (edtVerifyPassword.length() != 4) {
                    edtVerifyPassword.setError("رمز باید چهار رقمی باشد");

                }


                else if (edtVerifyPassword.getText().toString().equals(str)) {
                    hidekeyboard();
                    ActivityMain main=new ActivityMain();
                    main.SendBt("SavePassword," + edtOldPassword.getText().toString() + "," + str);

                } else {

                  //  Toast.makeText(G.context, "رمز اشتباه است", Toast.LENGTH_SHORT).show();
                    edtVerifyPassword.setError("رمز اشتباه است");


                }

            }
        });

        //................
        btnExitPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                hidekeyboard();
                startActivity(new Intent(G.currentActivity, Activity_List_MG4.class));
                finish();
            }
        });

    }
    public void   hidekeyboard(){
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtNewPassword.getWindowToken(), 0);
    }



    @Override
    protected void onDestroy() {
        handler1.removeCallbacksAndMessages(null);
hidekeyboard();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handler1.removeCallbacksAndMessages(null);
        hidekeyboard();
        startActivity(new Intent(G.currentActivity, Activity_List_MG4.class));
        finish();

    }
}