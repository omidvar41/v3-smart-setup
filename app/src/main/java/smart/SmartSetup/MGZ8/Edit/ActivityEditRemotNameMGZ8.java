package smart.SmartSetup.MGZ8.Edit;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MGZ8.models.Remote;
import smart.SmartSetup.R;
import smart.SmartSetup.tools;

public class ActivityEditRemotNameMGZ8 extends EnhancedActivity {
    TextView txtRemotEdit;
public static ActivityEditRemotNameMGZ8 activityEditRemotNameMGZ8;
    Button btnExitRemot;
    Button   btnSaveRemot;
    EditText edtRemotName;
    String     desc;
    int[]    strzon;
    byte[]   command1;
    String   unicod;
    String   unicod2 = "";
    byte[]   unicod1;
    int      can;

    Spinner spiTkzng;
    String[] str1 = { "پارتیشن یک", "پارتیشن دو"};

    Remote remote;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.mgz8_activity_edit_remot_name);
        activityEditRemotNameMGZ8 =this;
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
        //  unicod1 = new byte[3];
        txtRemotEdit = (TextView) findViewById(R.id.txtRemotEdit);

        btnExitRemot = (Button) findViewById(R.id.btnExitRemot);
        btnSaveRemot = (Button) findViewById(R.id.btnSaveRemot);
        edtRemotName = (EditText) findViewById(R.id.edtRemotName);


        remote = (Remote) getIntent().getSerializableExtra("REMOT");
        TextView txtCnRemotEdit = (TextView) findViewById(R.id.txtCnRemotEdit);


        if (remote != null) {


                txtRemotEdit.setText("ریموت " + remote.getNumRemote());
                edtRemotName.setText(tools.StringToChar(remote.getName()) +"");

                edtRemotName.setSelection(edtRemotName.getText().toString().length());

            txtCnRemotEdit.setText("10/" + String.valueOf(edtRemotName.length()));

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

        spiTkzng = (Spinner) findViewById(R.id.spiTkzng);
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, R.layout.spiner_item, str1){



            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);

                ((TextView) v).setTextSize(13);

                return v;

            }

            public View getDropDownView(int position, View convertView,ViewGroup parent) {

                View v = super.getDropDownView(position, convertView,parent);

                ((TextView) v).setGravity(Gravity.CENTER);

                return v;

            }



        };
        adap.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spiTkzng.setAdapter(adap);


        spiTkzng.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                // mediaPlayer.start();
                Log.e("fdx",arg2+"");
                remote.setPartitionName(arg2+1);

                //partition = arg0.getItemAtPosition(arg2).toString();


            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }

        });
        spiTkzng.setSelection(remote.getPartitionName()-1);




    }
    private void send_bt(String str) {



            unicod2 = "SaveRemot," + remote.getNumRemote() + ","+remote.getPartitionName()+",";


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
