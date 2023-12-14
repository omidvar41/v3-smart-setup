
package smart.SmartSetup.MGZ8.Edit;

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
import smart.SmartSetup.tools;

public class ActivityEditOutNameMGZ8 extends EnhancedActivity {
public static ActivityEditOutNameMGZ8 activityEditOutNameMGZ8;
    TextView txtOutEdit;
    // TextView txtCnOutEdit;
    Button btnExitOut;
    Button   btnSaveOut;
    EditText edtOutName;
    String   Out;
    int[]    strzon;
    byte[]   command1;
    String   unicod;
    String   unicod2 = "";
    byte[]   unicod1;
    int      can;
MediaPlayer mediaPlayer;
    String desc;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.mgz8_activity_edit_out_name);
        activityEditOutNameMGZ8 =this;
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
        //  unicod1 = new byte[3];
        txtOutEdit = (TextView) findViewById(R.id.txtOutEdit);

        btnExitOut = (Button) findViewById(R.id.btnExitOut);
        btnSaveOut = (Button) findViewById(R.id.btnSaveOut);
        edtOutName = (EditText) findViewById(R.id.edtOutName);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("OUT")) {
                Out = extras.getString("OUT");
                txtOutEdit.setText("خروجی " + Out);
                edtOutName.setText(tools.StringToChar(extras.getString("valu")));
                edtOutName.setSelection(edtOutName.getText().length());

            }


        }
        //.................................................................

        edtOutName.addTextChangedListener(new TextWatcher() {

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
                TextView txtCnOutEdit = (TextView) findViewById(R.id.txtCnOutEdit);
                txtCnOutEdit.setText("10/" + String.valueOf(edtOutName.length()));

            }
        });
        //................................................................
        btnExitOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                hidekeyboard();
                G.currentActivity.finish();

            }
        });

        btnSaveOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
                String str = (edtOutName.getText().toString());
hidekeyboard();
                //   send_btzip(str);
                send_bt(str);
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
    private void send_bt(String str) {

        unicod2 = "SaveOut," + Out + ",";

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            unicod = Integer.toHexString(c | 0x10000).substring(1);

            unicod2 = unicod2 + unicod;

        }
        ActivityMain main=new ActivityMain();
        main.SendBt(unicod2);

    }
    public void   hidekeyboard(){
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtOutName.getWindowToken(), 0);
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
}
