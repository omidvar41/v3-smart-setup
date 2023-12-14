package smart.SmartSetup.MGZ8.Edit;

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

public class ActivityEditWlNameMGZ8 extends EnhancedActivity {
    TextView txtOutEdit;
    // TextView txtCnOutEdit;
    public static ActivityEditWlNameMGZ8 activityEditWlNameMGZ8;
    Button btnExitWl;
    Button   btnSaveWl;
    EditText edtWlName;
    String   Wireles,desc;
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
        setContentView(R.layout.mgz8_activity_edit_wl_name);
        activityEditWlNameMGZ8 =this;
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
        //  unicod1 = new byte[3];
        txtOutEdit = (TextView) findViewById(R.id.txtWlEdit);

        btnExitWl = (Button) findViewById(R.id.btnExitWl);
        btnSaveWl = (Button) findViewById(R.id.btnSaveWl);
        edtWlName = (EditText) findViewById(R.id.edtWlName);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("WIRELES")) {
                Wireles = extras.getString("WIRELES");
                txtOutEdit.setText("سنسور بیسیم " + Wireles);
            }
        }
        //.................................................................

        edtWlName.addTextChangedListener(new TextWatcher() {

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
                TextView txtCnWlEdit = (TextView) findViewById(R.id.txtCnWlEdit);
                txtCnWlEdit.setText("10/" + String.valueOf(edtWlName.length()));

            }
        });
        //................................................................
        btnExitWl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                G.currentActivity.finish();hidekeyboard();
            }
        });

        btnSaveWl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String str = (edtWlName.getText().toString());
hidekeyboard();
                //   send_btzip(str);
                send_bt(str);
                G.currentActivity.finish();
            }
        });

    }
    private void send_bt(String str) {

        unicod2 = "SaveWireles," + Wireles + ",";

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
        imm.hideSoftInputFromWindow(edtWlName.getWindowToken(), 0);
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
