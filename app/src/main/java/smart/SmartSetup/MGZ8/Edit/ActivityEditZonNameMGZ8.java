
package smart.SmartSetup.MGZ8.Edit;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MGZ8.models.Zon;
import smart.SmartSetup.R;
import smart.SmartSetup.tools;

public class ActivityEditZonNameMGZ8 extends EnhancedActivity {
    public  static ActivityEditZonNameMGZ8 activityEditZonNameMGZ8;
    TextView txtZonEdit,txtsp1,txtsp2;
    //   TextView txtCnZonEdit;
    Button btnExit1;
    Button   btnSave1;
    EditText edtZonName;
    String   desc,partition,mode;
    int[]    strzon;
    byte[]   command1;
    String   unicod;
    String   unicod2 = "";
    byte[]   unicod1;
    int      can;
    LinearLayout line;



    Spinner spiTkzng;
    String[] str1 = { "پارتیشن یک", "پارتیشن دو", "مشترک", "دوگانه" };

    Spinner  spiReport;
    String[] str2 = { "نرمال", "نیمه فعال", "24ساعته", "24ساعته بیصدا", "تاخیری" };

    CheckBox chkSmsControl,chkDeleteZon;
    smart.SmartSetup.MGZ8.models.Zon zon;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        setContentView(R.layout.mgz8_activity_edit_zon_name);
        activityEditZonNameMGZ8 =this;
//        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
//        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
        //  unicod1 = new byte[3];
        txtZonEdit = (TextView) findViewById(R.id.txtZonEdit);
        chkDeleteZon =  findViewById(R.id.chkDeleteZon);
        line =    findViewById(R.id.line);

        btnExit1 = (Button) findViewById(R.id.btnExit1);
        btnSave1 = (Button) findViewById(R.id.btnSave1);
        edtZonName = (EditText) findViewById(R.id.edtZonName);

        txtsp1=(TextView)findViewById(R.id.txtsp1);
        txtsp2=(TextView)findViewById(R.id.txtsp2);

        txtsp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidekeyboard();
            }
        });
        txtsp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidekeyboard();
            }
        });

        chkSmsControl = (CheckBox) findViewById(R.id.chkSmsControl);
        chkSmsControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidekeyboard();
            }
        });

        zon = (Zon) getIntent().getSerializableExtra("ZON");


        if (zon != null) {


                txtZonEdit.setText("زون " + zon.getNumber());

                edtZonName.setText(new tools().StringToChar(zon.getName()) +"");
                if (zon!=null && zon.getIsDelete().equals("1")){
                    line.setVisibility(View.GONE);
                    edtZonName.setVisibility(View.GONE);
                }else {
                    line.setVisibility(View.VISIBLE);
                    edtZonName.setVisibility(View.VISIBLE);

                }


        }


        chkDeleteZon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    line.setVisibility(View.GONE);
                    edtZonName.setVisibility(View.GONE);

                }else {
                    line.setVisibility(View.VISIBLE);
                    edtZonName.setVisibility(View.VISIBLE);

                }
            }
        });





        ///.............................................................
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

        spiReport = (Spinner) findViewById(R.id.spiReport);
        ArrayAdapter<String> adap1 = new ArrayAdapter<String>(this,R.layout.spiner_item, str2){


            public View getView(int position, View convertView,ViewGroup parent) {

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
        adap1.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spiReport.setAdapter(adap1);

        if (zon.getDingDang().equals("0")){
            chkSmsControl.setChecked(false);

        }else {
            chkSmsControl.setChecked(true);

        }

        if (zon.getIsDelete().equals("0")){
            chkDeleteZon.setChecked(false);

        }else {
            chkDeleteZon.setChecked(true);

        }

        spiTkzng.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                // mediaPlayer.start();
                Log.e("fdx",arg2+"");
                partition = (arg2+1)+"";

                //partition = arg0.getItemAtPosition(arg2).toString();


            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }

        });

        ///.............................................................

        spiReport.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                String str = arg0.getItemAtPosition(arg2).toString();
                // mediaPlayer.start();
                mode = arg2+"";
                Log.e("fdx",arg2+"");


            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });
        spiTkzng.setSelection(Integer.parseInt(zon.getPartition())-1);
        spiReport.setSelection(Integer.parseInt(zon.getMode()));


        ///.............................................................

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
                zon.setName(edtZonName.getText().toString());
                zon.setPartition(partition);
                zon.setMode(mode);
                //zon.setPartition(spiTkzng.get);
                if (chkSmsControl.isChecked()) {
                    zon.setDingDang("1");

                } else {
                    zon.setDingDang("0");

                }
                if (chkDeleteZon.isChecked()) {
                    zon.setIsDelete("1");

                } else {
                    zon.setIsDelete("0");

                }
                String str =  ","+ zon.getPartition() + ","+ zon.getMode() + ","
                        + zon.getDingDang()+","+zon.getIsDelete();
hidekeyboard();
                //   send_btzip(str);
                send_bt(zon.getName(),str);
                G.currentActivity.finish();
            }
        });

    }

    //...............................................................................................
    private void send_bt(String name,String str) {

        unicod2 = "SaveZon," + zon.getNumber() + ",";

        Log.e("zonName",str);

        for (int i = 0; i < name.length(); i++) {

            char c = name.charAt(i);

            unicod = Integer.toHexString(c | 0x10000).substring(1);

            unicod2 = unicod2 + unicod;

        }
        unicod2 = unicod2+str;
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