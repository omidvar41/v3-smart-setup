package smart.SmartSetup.G4.Edit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
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

public class ActivityEditOutNameG4 extends EnhancedActivity {

    TextView txtOutEdit;
    // TextView txtCnOutEdit;
    Button btnExitOut;
    Button   btnSaveOut;
    EditText edtOutName;
    String   Out;
    int[]    strzon;
    byte[]   command1;
    String   unicod,desc;
    String   unicod2 = "";
    byte[]   unicod1;
    int      can;

    public  static  ActivityEditOutNameG4 activityEditOutNameG4;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g4_activity_edit_out_name);
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
        //  unicod1 = new byte[3];
        txtOutEdit = (TextView) findViewById(R.id.txtOutEdit);
activityEditOutNameG4=this;
        btnExitOut = (Button) findViewById(R.id.btnExitOut);
        btnSaveOut = (Button) findViewById(R.id.btnSaveOut);
        edtOutName = (EditText) findViewById(R.id.edtOutName);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("OUT")) {
                Out = extras.getString("OUT");
                txtOutEdit.setText("خروجی " + Out);
            }
            if (extras.containsKey("desc")){
                desc=extras.getString("desc");
                edtOutName.setText(desc);
                edtOutName.setSelection(edtOutName.length());
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
