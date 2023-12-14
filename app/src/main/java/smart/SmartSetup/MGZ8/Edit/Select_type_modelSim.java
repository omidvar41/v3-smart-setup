package smart.SmartSetup.MGZ8.Edit;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MGZ8.ActivityChargeMGZ8;
import smart.SmartSetup.R;

public class Select_type_modelSim extends EnhancedActivity {

    Button btnExit;
    Button   btnSave;
    RadioButton daeemi,eetebari;
EditText editText;
    ActivityMain main;
    Dialog dialog
            ;
    MediaPlayer mediaPlayer;
    public static Select_type_modelSim select_type_modelSim;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.mgz8_dialog_select_type_model_sim);
select_type_modelSim=this;
dialog=new Dialog(this);
        btnExit = (Button) findViewById(R.id.btnExit);
        btnSave = (Button) findViewById(R.id.btnSave);
        daeemi = (RadioButton) findViewById(R.id.daeemi);
        eetebari = (RadioButton) findViewById(R.id.eetebari);
        editText=(EditText)findViewById(R.id.edtCharge);

        main=new ActivityMain();

        Intent intent=getIntent();
        if (intent!=null) {
            String code = intent.getStringExtra("code");

            switch (code) {
                case "1":
                    daeemi.setChecked(true);
                    editText.setVisibility(View.GONE);
                    break;
                case "2":
                    eetebari.setChecked(true);
editText.setVisibility(View.VISIBLE);
editText.requestFocus();
editText.setSelection(editText.length());
openkeyboard();
                    break;
                default:
            }

            String name=intent.getStringExtra("Name");
            if (name.equals("IR-MCI")){
                if (ActivityChargeMGZ8.txtCodeChekCharge.getText().toString().equals("    ")) {
                    editText.setText("*140*11#");
                    editText.setFocusable(true);

                    editText.requestFocus();
                    editText.setSelection(editText.length());
                    openkeyboard();

                }else{
                    editText.setFocusable(true);

                    editText.setText(ActivityChargeMGZ8.txtCodeChekCharge.getText().toString());
                    editText.requestFocus();
                    editText.setSelection(editText.length());
                    openkeyboard();
                }
            }else if (name.equals("Irancell")){

                if (ActivityChargeMGZ8.txtCodeChekCharge.getText().toString().equals("    ")) {
                    editText.setText("*141*1#");
                    editText.setFocusable(true);

                    editText.requestFocus();
                    editText.setSelection(editText.length());
                    openkeyboard();
                }else{
                    editText.setText(ActivityChargeMGZ8.txtCodeChekCharge.getText().toString());
                    editText.setFocusable(true);
                    editText.requestFocus();
                    editText.setSelection(editText.length());
                    openkeyboard();
                }
            }else{
                editText.setText("");
            }


        }

        daeemi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setVisibility(View.GONE);
            }
        });
        eetebari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setVisibility(View.VISIBLE);
                editText.setFocusable(true);
                editText.requestFocus();
                editText.setSelection(editText.length());

            openkeyboard();
            }
        });




        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                hidekeyboard();
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                if (daeemi.isChecked()){
                    ActivityChargeMGZ8.TypeSim="1";
                        String str ="";
                        String unicod2 = "SaveCharge," + "1" + "," + str;
                        main.SendBt(unicod2);
                    ActivityMain.Cusd="";

                    hidekeyboard();
                        G.currentActivity.finish();




                 //   main.SendBt("LEVEL");
                }if (eetebari.isChecked()){
                  ///  main.SendBt("EDGE");
                    ActivityChargeMGZ8.TypeSim="2";

                    if (0 != editText.length()) {
                        String str = editText.getText().toString();
                        String unicod2 = "SaveCharge," + "1" + "," + str;
ActivityMain.CodeChekCharge=" ";
                        main.SendBt(unicod2);

                        hidekeyboard();
                        ActivityMain.Cusd="در حال محاسبه...";
                        ActivityChargeMGZ8.progressBar.setVisibility(View.VISIBLE);
                        G.currentActivity.finish();
                    } else {

                        editText.setError("فرمول کنترل شارژ را وارد کنید");
                    }

                }


            }
        });

editText.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View view) {
        setviewHelp();
        return true;
    }
});

    }
    public void   hidekeyboard(){
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public void   openkeyboard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);

    }
    public void setviewHelp() {
        TapTargetView.showFor(dialog,                 // `this` is an Activity
                TapTarget.forView(editText, "توضیح","فرمول کنترل شارژ را در این قسمت وارد کنید")

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
