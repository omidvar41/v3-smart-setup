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

public class ActivityEditTrigNameG4 extends EnhancedActivity {
    TextView txtTrigEdit;
    //   TextView txtCnZonEdit;
    Button btnExitTrig;
    Button   btnSaveTrig;
    EditText edtTrigText;
    String   Trig,desc;
    int[]    strtrig;
    byte[]   command1;
    String   unicod;
    String   unicod2 = "";
    byte[]   unicod1;
    int      can;
    public static ActivityEditTrigNameG4 activityEditTrigNameG4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g4_activity_edit_trig_name);
        activityEditTrigNameG4=this;
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
        //  unicod1 = new byte[3];
        txtTrigEdit = (TextView) findViewById(R.id.txtTrigEdit);

        btnExitTrig = (Button) findViewById(R.id.btnExitTrig);
        btnSaveTrig = (Button) findViewById(R.id.btnSaveTrig);
        edtTrigText = (EditText) findViewById(R.id.edtTrigText);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("TRIG")) {
                Trig = extras.getString("TRIG");
                if (Trig.equals("0")) {
                    txtTrigEdit.setText("تحریک 4 غیرفعال");
                }
                else if (Trig.equals("4")) {
                    txtTrigEdit.setText("تحریک 4 فعال");
                }
                else {
                    txtTrigEdit.setText("تحریک " + Trig);
                }
            }
            if (extras.containsKey("desc")){
                desc=extras.getString("desc");
                edtTrigText.setText(desc);
                edtTrigText.setSelection(edtTrigText.length());
            }
        }
        //.................................................................

        edtTrigText.addTextChangedListener(new TextWatcher() {

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
                TextView txtCnTrigEdit = (TextView) findViewById(R.id.txtCnTrigEdit);
                txtCnTrigEdit.setText("35/" + String.valueOf(edtTrigText.length()));

            }
        });
        //................................................................
        btnExitTrig.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                hidekeyboard();G.currentActivity.finish();
            }
        });

        btnSaveTrig.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String str = (edtTrigText.getText().toString());
hidekeyboard();
                //   send_btzip(str);
                send_bt(str);
                G.currentActivity.finish();
            }
        });
    }

    private void send_bt(String str) {

        unicod2 = "SaveTrig," + Trig + ",";

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
        imm.hideSoftInputFromWindow(edtTrigText.getWindowToken(), 0);
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
