package smart.SmartSetup.MG4.Edit;

import android.graphics.drawable.ColorDrawable;
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

public class ActivityEditRemotNameMG4 extends EnhancedActivity {
    TextView txtRemotEdit;
public static smart.SmartSetup.MG4.Edit.ActivityEditRemotNameMG4 activityEditRemotNameMG4;
    Button btnExitRemot;
    Button   btnSaveRemot;
    EditText edtRemotName;
    String   Remot,desc;
    int[]    strzon;
    byte[]   command1;
    String   unicod;
    String   unicod2 = "";
    byte[]   unicod1;
    int      can;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.mg4_activity_edit_remot_name);
        activityEditRemotNameMG4 =this;
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
        //  unicod1 = new byte[3];
        txtRemotEdit = (TextView) findViewById(R.id.txtRemotEdit);

        btnExitRemot = (Button) findViewById(R.id.btnExitRemot);
        btnSaveRemot = (Button) findViewById(R.id.btnSaveRemot);
        edtRemotName = (EditText) findViewById(R.id.edtRemotName);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("REMOT")) {
                Remot = extras.getString("REMOT");
                txtRemotEdit.setText("ریموت " + Remot);
            }

        }
        //.................................................................

        edtRemotName.addTextChangedListener(new TextWatcher() {

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
                TextView txtCnRemotEdit = (TextView) findViewById(R.id.txtCnRemotEdit);
                txtCnRemotEdit.setText("10/" + String.valueOf(edtRemotName.length()));

            }
        });
        //................................................................
        btnExitRemot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                hidekeyboard();
                G.currentActivity.finish();
            }
        });

        btnSaveRemot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String str = (edtRemotName.getText().toString());
hidekeyboard();
                //   send_btzip(str);
                send_bt(str);
                G.currentActivity.finish();
            }
        });
    }
    private void send_bt(String str) {

        if (Remot.equals("10")) {
            unicod2 = "SaveRemot," + "0" + ",";
        }
        else {
            unicod2 = "SaveRemot," + Remot + ",";
        }

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
        imm.hideSoftInputFromWindow(edtRemotName.getWindowToken(), 0);
    }

    @Override
    public void onBackPressed() {
        hidekeyboard();
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        hidekeyboard();
        super.onDestroy();
    }
}
