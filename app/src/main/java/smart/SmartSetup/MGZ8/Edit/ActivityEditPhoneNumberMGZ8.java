package smart.SmartSetup.MGZ8.Edit;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.R;

/**
 * Created by Roholah on 30/06/2017.
 */

public class ActivityEditPhoneNumberMGZ8 extends EnhancedActivity {
public static ActivityEditPhoneNumberMGZ8 activityEditPhoneNumberMGZ8;
    TextView txtMamoryEdit;
    Button btnExit;
    Button   btnSave;
    EditText edtPhoneNumber;
    String   Mamory,desc;
    Dialog dialog;
    MediaPlayer mediaPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.mgz8_activity_edit_phone_numbe);


        activityEditPhoneNumberMGZ8 =this;
dialog=new Dialog(this);
        txtMamoryEdit = (TextView) findViewById(R.id.txtMamoryEdit);
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
        edtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumber);
        TextView txtPhoneCn = (TextView) findViewById(R.id.txtPhoneCn);

        btnExit = (Button) findViewById(R.id.btnExit);
        btnSave = (Button) findViewById(R.id.btnSave);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            if (extras.containsKey("desc")) {
                desc = extras.getString("desc");
              //  Toast.makeText(this, desc+"", Toast.LENGTH_SHORT).show();
              if (desc.equals("Empty")){
                  edtPhoneNumber.setHint("شماره را وارد کنید");
                  edtPhoneNumber.setText("");

              }else {
                  edtPhoneNumber.setText(desc);

              }
                edtPhoneNumber.setSelection(edtPhoneNumber.getText().toString().length());
                txtPhoneCn.setText("16/" + String.valueOf(edtPhoneNumber.length()));

            }


            if (extras.containsKey("MAMORY")) {
                Mamory = extras.getString("MAMORY");
               // edtPhoneNumber.setText(extras.getString("valu"));

                if (Mamory.equals("0")){
                    txtMamoryEdit.setText("کد شهر");
                    edtPhoneNumber.setHint("کدشهر را وارد کنید");

                }else {
                    txtMamoryEdit.setText("حافظه " + Mamory);
                }
            }
        }
        ///.............................................................

        edtPhoneNumber.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub

            }


            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub

            }


            @Override
            public void afterTextChanged(Editable arg0) {
                txtPhoneCn.setText("16/" + String.valueOf(edtPhoneNumber.length()));

            }
        });
        ///.............................................................
        btnExit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                hidekeyboard();
                G.currentActivity.finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                String str = ("SaveCod,"+ (edtPhoneNumber.getText().toString()));
hidekeyboard();
                ActivityMain main=new ActivityMain();
                main.SendBt(str);

                G.currentActivity.finish();
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

    public void   hidekeyboard(){
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtPhoneNumber.getWindowToken(), 0);
    }

    @Override
    protected void onDestroy() {
        hidekeyboard();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        hidekeyboard();
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
