package smart.SmartSetup.G4;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import info.hoang8f.widget.FButton;
import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.R;

/**
 * Created by Roholah on 30/06/2017.
 */

public class ActivityPaswordG4 extends EnhancedActivity {
    EditText edtOldPassword;
    EditText edtNewPassword;
    EditText edtVerifyPassword;

    FButton btnSavePassword;
    FButton   btnExitPassword;
    ImageView bluicon;
    Handler handler1;


    public  static ActivityPaswordG4 activityPaswordG4;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.g4_activity_pasword);
activityPaswordG4=this;
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
        edtOldPassword = (EditText) findViewById(R.id.edtOldPassword);
        edtNewPassword = (EditText) findViewById(R.id.edtNewPassword);
        edtVerifyPassword = (EditText) findViewById(R.id.edtVerifyPassword);

        bluicon=(ImageView)findViewById(R.id.bluIcon);

        btnSavePassword = (FButton) findViewById(R.id.btnSavePassword);
        btnSavePassword.setButtonColor(getResources().getColor(R.color.white));

        btnExitPassword = (FButton) findViewById(R.id.btnExitPassword);
        btnExitPassword.setButtonColor(getResources().getColor(R.color.white));

        ///...............................................................


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







            }
        }, 0);


        btnSavePassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                //      edtNewPassword.g

                String str = edtNewPassword.getText().toString();
                if (edtOldPassword.length() == 0) {
                    // Toast.makeText(G.context, "رمز قدیم را وارد کنید", Toast.LENGTH_SHORT).show();
                    edtOldPassword.setError("رمز قدیم را وارد کنید");

                }
                else if (edtNewPassword.length() == 0) {
                   // Toast.makeText(G.context, "رمز جدید را وارد کنید", Toast.LENGTH_SHORT).show();
                    edtNewPassword.setError("رمز جدید را وارد کنید");

                }
                else if (edtVerifyPassword.length() == 0) {
                  //  Toast.makeText(G.context, "رمز جدید را تکرار کنید", Toast.LENGTH_SHORT).show();
                    edtVerifyPassword.setError("رمز جدید را وارد کنید");
                }
                else if (edtOldPassword.length() != 4) {
                   // Toast.makeText(G.context, "رمز باید چهار رقمی باشد", Toast.LENGTH_SHORT).show();
                    edtOldPassword.setError("رمز باید چهار رقمی باشد");
                }
                else if (edtNewPassword.length() != 4) {
                   // Toast.makeText(G.context, "رمز باید چهار رقمی باشد", Toast.LENGTH_SHORT).show();
                    edtNewPassword.setError("رمز باید چهار رقمی باشد");

                }
                else if (edtVerifyPassword.length() != 4) {
                    //Toast.makeText(G.context, "رمز باید چهار رقمی باشد", Toast.LENGTH_SHORT).show();
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
                G.currentActivity.finish();
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
        handler1.removeCallbacksAndMessages(null);

        hidekeyboard();
        super.onBackPressed();
    }
}
