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

public class ActivityEditChargeG4 extends EnhancedActivity {

    TextView txtChargeEdit;
    // TextView txtCnOutEdit;
    Button btnExitCharge;
    Button   btnSaveCharge;
    EditText edtChargeCode;
    String   Charge,desc;
    int[]    strzon;
    byte[]   command1;
    String   unicod;
    String   unicod2 = "";
    byte[]   unicod1;
    int      can;
    public static ActivityEditChargeG4 activityEditChargeG4;
    TextView txtCnChargeEdit;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
        setContentView(R.layout.g4_activity_edit_charge);
        activityEditChargeG4=this;
        //  unicod1 = new byte[3];
        txtChargeEdit = (TextView) findViewById(R.id.txtChargeEdit);
        txtCnChargeEdit= (TextView) findViewById(R.id.txtCnChargeEdit);

        btnExitCharge = (Button) findViewById(R.id.btnExitCharge);
        btnSaveCharge = (Button) findViewById(R.id.btnSaveCharge);
        edtChargeCode = (EditText) findViewById(R.id.edtChargeCode);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("CHARGE")) {
                Charge = extras.getString("CHARGE");
                if (Charge.equals("1")) {
                    txtChargeEdit.setText("فرمول کنترل شارژ");
                } else if (Charge.equals("2")) {
                    txtChargeEdit.setText("فرمول شارژ");
                }
            }

            if (extras.containsKey("desc")){
                desc=extras.getString("desc");
                edtChargeCode.setText(desc);
                if (desc.equals("    ")){
                    edtChargeCode.setSelection(0);
                }else {
                    edtChargeCode.setSelection(edtChargeCode.length());
                }
            }
        }



        //.................................................................

        edtChargeCode.addTextChangedListener(new TextWatcher() {

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
                txtCnChargeEdit.setText("10/" + String.valueOf(edtChargeCode.length()));

            }
        });
        //................................................................
        btnExitCharge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                hidekeyboard();
                G.currentActivity.finish();
            }
        });

        btnSaveCharge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String str = (edtChargeCode.getText().toString());
hidekeyboard();
                //   send_btzip(str);
                send_bt(str);
                G.currentActivity.finish();
            }
        });

    }
    private void send_bt(String str) {

        unicod2 = "SaveCharge," + Charge + "," + str;
        ActivityMain main=new ActivityMain();
        main.SendBt(unicod2);

    }

    public void   hidekeyboard(){
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtChargeCode.getWindowToken(), 0);
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
