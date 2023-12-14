
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

public class ActivityEditZonNameMG4 extends EnhancedActivity {
    public  static smart.SmartSetup.MG4.Edit.ActivityEditZonNameMG4 activityEditZonNameMG4;
    TextView txtZonEdit;
    //   TextView txtCnZonEdit;
    Button btnExit1;
    Button   btnSave1;
    EditText edtZonName;
    String   Zon,desc;
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
        setContentView(R.layout.mg4_activity_edit_zon_name);
        activityEditZonNameMG4 =this;
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
        //  unicod1 = new byte[3];
        txtZonEdit = (TextView) findViewById(R.id.txtZonEdit);

        btnExit1 = (Button) findViewById(R.id.btnExit1);
        btnSave1 = (Button) findViewById(R.id.btnSave1);
        edtZonName = (EditText) findViewById(R.id.edtZonName);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("ZON")) {
                Zon = extras.getString("ZON");
                txtZonEdit.setText("زون " + Zon);
            }


        }
        //.................................................................

        edtZonName.addTextChangedListener(new TextWatcher() {

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
                TextView txtCnZonEdit = (TextView) findViewById(R.id.txtCnZonEdit);
                txtCnZonEdit.setText("10/" + String.valueOf(edtZonName.length()));

            }
        });
        //................................................................
        btnExit1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                G.currentActivity.finish();hidekeyboard();
            }
        });

        btnSave1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String str = (edtZonName.getText().toString());
hidekeyboard();
                //   send_btzip(str);
                send_bt(str);
                G.currentActivity.finish();
            }
        });

    }
    private void send_btzip(String str) {

        //   String str1 = "SaveZon," + Zon + ",";
        //   String str2 = "SaveZon," + Zon + "," + str;

        int lengthAry = (str.length() * 2) + 10;
        unicod1 = new byte[lengthAry];
        can = 0;
        unicod1[can++] = 'S';
        unicod1[can++] = 'a';
        unicod1[can++] = 'v';
        unicod1[can++] = 'e';
        unicod1[can++] = 'Z';
        unicod1[can++] = 'o';
        unicod1[can++] = 'n';
        unicod1[can++] = ',';
        if (Zon.equals("1")) {
            unicod1[can++] = '1';
        }
        else if (Zon.equals("2")) {
            unicod1[can++] = '2';
        }
        else if (Zon.equals("3")) {
            unicod1[can++] = '3';
        }
        else if (Zon.equals("4")) {
            unicod1[can++] = '4';
        }

        unicod1[can++] = ',';

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            byte ch = (byte) (c / 256);
            byte d = (byte) (c % 256);

            unicod1[can++] = ch;
            unicod1[can++] = d;

        }
        unicod1[can++] = ',';
        ActivityMain.mBluetoothSPPConnection.write(unicod1);

    }


    //...............................................................................................
    private void send_bt(String str) {

        unicod2 = "SaveZon," + Zon + ",";

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
        imm.hideSoftInputFromWindow(edtZonName.getWindowToken(), 0);
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