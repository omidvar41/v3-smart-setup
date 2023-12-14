package smart.SmartSetup.MGZ8.Edit;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.takusemba.spotlight.OnSpotlightStateChangedListener;
import com.takusemba.spotlight.Spotlight;
import com.takusemba.spotlight.shape.Circle;
import com.takusemba.spotlight.target.SimpleTarget;

import java.util.ArrayList;
import java.util.regex.Pattern;

import info.hoang8f.widget.FButton;
import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MG4.Edit.ActivivtyEditselectTypeCall;
import smart.SmartSetup.MG4.view_descip;
import smart.SmartSetup.MGZ8.dialog_select_type_call_MGZ8;
import smart.SmartSetup.MGZ8.models.phoneNumber;
import smart.SmartSetup.R;

public class ActivityEditSmsNumberMGZ8 extends EnhancedActivity  {
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hidekeyboard();
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }

    public void   openkeyboard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(edtPhoneNumber, InputMethodManager.SHOW_IMPLICIT);

    }
public static ActivityEditSmsNumberMGZ8 activityEditSmsNumberMGZ8;
int selectioned;
    TextView txtMamoryEdit,txtsp2;
    TextView btnExit;
    TextView   btnSave;
    TextView   btnEdit;
    TextView   txtSP1;
    TextView   txtSP2;
    EditText edtPhoneNumber;
    View viewEdit;





    phoneNumber phoneNumber;
    Spinner spiTkzng;
    String[] str1 = {"غیرفعال","تغییر حالت پارتیشن یک", "تغییر حالت پارتیشن دو", "روشن کردن پارتیشن یک" ,"روشن کردن پارتیشن دو"
    ,"خاموش کردن پارتیشن یک","خاموش کردن پارتیشن دو"};



    ActivityMain main;


    CheckBox  chxCallP1,chxCallP2,chxP1,chxP2,chxControl,
            chxEnDisP1,chxEnDisP2,
            chxAlarmP1,chxAlarmP2,
            chxElectCity,chxAux,chxCutVoice,chxCutPhoneLine,
            chxCommonArea,chxTwoArea,chxSystemReports;

    ArrayList<view_descip> view_descips=new ArrayList<>();
    LinearLayout lch,lspT,linReportSms,linVoiceCall,lyspTac;

    Dialog dialog;
MediaPlayer mediaPlayer;

    ConstraintLayout linEditBase;
    TextView txtPhoneCn,txtControlSms,txtReportSms;
    View borderTopControlSms,borderTopReportSms,borderTopMissCall;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mgz8_activity_edit_sms_number);
        linEditBase =  findViewById(R.id.linEditBase);
        lch=(LinearLayout)findViewById(R.id.lycheakbox);
        linVoiceCall=(LinearLayout)findViewById(R.id.linVoiceCall);
        lyspTac=(LinearLayout)findViewById(R.id.lyspTac);


        linReportSms =  findViewById(R.id.linReportSms);
        txtPhoneCn =  findViewById(R.id.txtPhoneCn);
        txtControlSms =  findViewById(R.id.txtControlSms);
        txtReportSms =  findViewById(R.id.txtReportSms);
        borderTopControlSms =  findViewById(R.id.borderTopControlSms);
        borderTopReportSms =  findViewById(R.id.borderTopReportSms);
        borderTopMissCall =  findViewById(R.id.borderTopMissCall);

        chxElectCity =  findViewById(R.id.chxElectCity);
        chxAux =  findViewById(R.id.chxAux);
        chxCutPhoneLine =  findViewById(R.id.chxCutPhone);
        chxCutVoice =  findViewById(R.id.chxCutVoice);
        chxSystemReports = findViewById(R.id.chxSystemReports);


        if(!G.versionNameMainSoftWareDevice.equals("") &&
                Integer.parseInt(G.versionNameMainSoftWareDevice)>1 ){
            chxElectCity.setVisibility(View.VISIBLE);
            chxCutPhoneLine.setVisibility(View.VISIBLE);
            chxAux.setVisibility(View.VISIBLE);
            chxCutVoice.setVisibility(View.VISIBLE);
            chxSystemReports.setVisibility(View.GONE);

        }else{
            chxElectCity.setVisibility(View.GONE);
            chxCutPhoneLine.setVisibility(View.GONE);
            chxAux.setVisibility(View.GONE);
            chxCutVoice.setVisibility(View.GONE);
            chxSystemReports.setVisibility(View.VISIBLE);
        }



        Intent intent = getIntent();
        if (intent.hasExtra("phoneNumber")){
            phoneNumber = (phoneNumber)intent.getSerializableExtra("phoneNumber");
        }

        chxCallP1 = findViewById(R.id.chxCallP1);
        chxCallP2 = findViewById(R.id.chxCallP2);
        chxP1 = findViewById(R.id.chxP1);
        btnEdit = findViewById(R.id.btnEdit);

        chxP2 = findViewById(R.id.chxP2);
        viewEdit = findViewById(R.id.viewEdit);

        chxControl = findViewById(R.id.chxControl);
//            chxEnDisP1,chxEnDisP2,
//            chxAlarmP1,chxAlarmP2,
//            chxCommonArea,chxTwoArea,chxSystemReports;
        chxEnDisP1 = findViewById(R.id.chxEnDisP1);
        chxEnDisP2 = findViewById(R.id.chxEnDisP2);
        chxAlarmP1 = findViewById(R.id.chxAlarmP1);
        chxAlarmP2 = findViewById(R.id.chxAlarmP2);
        chxCommonArea = findViewById(R.id.chxCommonArea);
        chxTwoArea = findViewById(R.id.chxTwoArea);
         spiTkzng = (Spinner) findViewById(R.id.spiTkzng);

        ///.............................................................

        ///..............................................................









        dialog=new Dialog(this);

        txtsp2=(TextView)findViewById(R.id.txtsp2);

        setupUI(linEditBase);
        txtsp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidekeyboard();
            }
        });


        activityEditSmsNumberMGZ8 =this;

        txtMamoryEdit = (TextView) findViewById(R.id.txtMamoryEdit);

        btnExit =  findViewById(R.id.btnExit);
        btnSave =   findViewById(R.id.btnSave);
        edtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumber);


        ArrayAdapter<String> adap = new ArrayAdapter<String>(getApplicationContext(), R.layout.spiner_item, str1){



            public View getView(int position, View convertView,ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                txtSP1 = (TextView) v;
                ((TextView) v).setTextSize(13);
                ((TextView) v).setTypeface(G.type);
                 return v;

            }

            public View getDropDownView(int position, View convertView,ViewGroup parent) {

                View v = super.getDropDownView(position, convertView,parent);
                txtSP2 = (TextView) v;

                ((TextView) v).setGravity(Gravity.CENTER);
                ((TextView) v).setTypeface(G.type);

                return v;

            }



        };
        adap.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spiTkzng.setAdapter(adap);

        spiTkzng.setSelection(Integer.parseInt(phoneNumber.getMisCallControl()));
        selectioned = Integer.parseInt(phoneNumber.getMisCallControl());



        if (phoneNumber.getNumber().equals("Empty")){
            btnExit.setVisibility(View.VISIBLE);
            btnSave.setVisibility(View.VISIBLE);
            btnEdit.setVisibility(View.GONE);
            viewEdit.setVisibility(View.GONE);
            edtPhoneNumber.requestFocus();




                borderTopControlSms.setVisibility(View.GONE);
                txtControlSms.setVisibility(View.GONE);
                lch.setVisibility(View.GONE);
                txtReportSms.setVisibility(View.GONE);
                linReportSms.setVisibility(View.GONE);
                borderTopMissCall.setVisibility(View.GONE);

                linVoiceCall.setVisibility(View.GONE);
            lyspTac.setVisibility(View.GONE);



            linEditBase.setBackgroundColor(Color.WHITE);
            btnEdit.setBackground(getResources().getDrawable(R.drawable.border_black));
            btnExit.setBackground(getResources().getDrawable(R.drawable.border_black));
            btnSave.setBackground(getResources().getDrawable(R.drawable.border_black));




            txtMamoryEdit.setTextColor(Color.BLACK);
            txtPhoneCn.setTextColor(Color.BLACK);
            edtPhoneNumber.setTextColor(Color.BLACK);
            edtPhoneNumber.setHintTextColor(Color.BLACK);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                edtPhoneNumber.setBackgroundTintList(getResources().getColorStateList(R.color.black));
                chxCallP1.setButtonTintList(getResources().getColorStateList(R.color.black));
                chxCallP2.setButtonTintList(getResources().getColorStateList(R.color.black));
                chxP1.setButtonTintList(getResources().getColorStateList(R.color.black));
                chxP2.setButtonTintList(getResources().getColorStateList(R.color.black));
                chxControl.setButtonTintList(getResources().getColorStateList(R.color.black));

                chxEnDisP1.setButtonTintList(getResources().getColorStateList(R.color.black));
                chxEnDisP2.setButtonTintList(getResources().getColorStateList(R.color.black));
                chxAlarmP1.setButtonTintList(getResources().getColorStateList(R.color.black));
                chxAlarmP2.setButtonTintList(getResources().getColorStateList(R.color.black));
                chxCommonArea.setButtonTintList(getResources().getColorStateList(R.color.black));
                chxTwoArea.setButtonTintList(getResources().getColorStateList(R.color.black));
                chxSystemReports.setButtonTintList(getResources().getColorStateList(R.color.black));
                chxCutVoice.setButtonTintList(getResources().getColorStateList(R.color.black));
                chxCutPhoneLine.setButtonTintList(getResources().getColorStateList(R.color.black));
                chxElectCity.setButtonTintList(getResources().getColorStateList(R.color.black));
                chxAux.setButtonTintList(getResources().getColorStateList(R.color.black));

            }
            chxCallP1.setTextColor(getResources().getColor(R.color.black));
            chxCallP2.setTextColor(getResources().getColor(R.color.black));
            borderTopControlSms.setBackgroundColor(getResources().getColor(R.color.black));
            txtControlSms.setTextColor(getResources().getColor(R.color.black));
            chxP1.setTextColor(getResources().getColor(R.color.black));
            chxP2.setTextColor(getResources().getColor(R.color.black));
            chxControl.setTextColor(getResources().getColor(R.color.black));
            borderTopReportSms.setBackgroundColor(getResources().getColor(R.color.black));
            txtReportSms.setTextColor(getResources().getColor(R.color.black));

            chxEnDisP1.setTextColor(getResources().getColor(R.color.black));
            chxEnDisP2.setTextColor(getResources().getColor(R.color.black));
            chxAlarmP1.setTextColor(getResources().getColor(R.color.black));
            chxAlarmP2.setTextColor(getResources().getColor(R.color.black));
            chxCommonArea.setTextColor(getResources().getColor(R.color.black));
            chxTwoArea.setTextColor(getResources().getColor(R.color.black));
            chxSystemReports.setTextColor(getResources().getColor(R.color.black));
            chxElectCity.setTextColor(getResources().getColor(R.color.black));
            chxAux.setTextColor(getResources().getColor(R.color.black));
            chxCutPhoneLine.setTextColor(getResources().getColor(R.color.black));
            chxCutVoice.setTextColor(getResources().getColor(R.color.black));

            borderTopMissCall.setBackgroundColor(getResources().getColor(R.color.black));
            txtsp2.setTextColor(getResources().getColor(R.color.black));
            adap = new ArrayAdapter<String>(getApplicationContext(), R.layout.spiner_item, str1){



                public View getView(int position, View convertView,ViewGroup parent) {

                    View v = super.getView(position, convertView, parent);
                    txtSP1 = (TextView) v;
                    txtSP1.setTextColor(getResources().getColor(R.color.black));

                    ((TextView) v).setTextSize(13);
                    ((TextView) v).setTypeface(G.type);
                    return v;

                }

                public View getDropDownView(int position, View convertView,ViewGroup parent) {

                    View v = super.getDropDownView(position, convertView,parent);
                    txtSP2 = (TextView) v;
                    txtSP2.setTextColor(getResources().getColor(R.color.black));

                    ((TextView) v).setGravity(Gravity.CENTER);
                    ((TextView) v).setTypeface(G.type);

                    return v;

                }



            };
            adap.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);

            spiTkzng.setAdapter(adap);

            spiTkzng.setSelection(Integer.parseInt(phoneNumber.getMisCallControl()));




        }
        else {
            viewEdit.setVisibility(View.VISIBLE);
            btnEdit.setBackground(getResources().getDrawable(R.drawable.border_white));
            btnExit.setBackground(getResources().getDrawable(R.drawable.border_white));
            btnSave.setBackground(getResources().getDrawable(R.drawable.border_white));

            adap = new ArrayAdapter<String>(getApplicationContext(), R.layout.spiner_item, str1){



                public View getView(int position, View convertView,ViewGroup parent) {

                    View v = super.getView(position, convertView, parent);
                    txtSP1 = (TextView) v;
                    txtSP1.setTextColor(getResources().getColor(R.color.white));

                    ((TextView) v).setTextSize(13);
                    ((TextView) v).setTypeface(G.type);
                    return v;

                }

                public View getDropDownView(int position, View convertView,ViewGroup parent) {

                    View v = super.getDropDownView(position, convertView,parent);
                    txtSP2 = (TextView) v;
                    txtSP2.setTextColor(getResources().getColor(R.color.white));

                    ((TextView) v).setGravity(Gravity.CENTER);
                    ((TextView) v).setTypeface(G.type);

                    return v;

                }



            };
            adap.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);

           spiTkzng.setAdapter(adap);

            spiTkzng.setSelection(Integer.parseInt(phoneNumber.getMisCallControl()));


        }
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            edtPhoneNumber.requestFocus();
                openkeyboard();

                btnExit.setVisibility(View.VISIBLE);
                btnSave.setVisibility(View.VISIBLE);
                btnEdit.setVisibility(View.GONE);
                viewEdit.setVisibility(View.GONE);
                edtPhoneNumber.setHintTextColor(Color.BLACK);
                btnEdit.setBackground(getResources().getDrawable(R.drawable.border_black));
                btnExit.setBackground(getResources().getDrawable(R.drawable.border_black));
                btnSave.setBackground(getResources().getDrawable(R.drawable.border_black));

                linEditBase.setBackgroundColor(Color.WHITE);
                txtMamoryEdit.setTextColor(Color.BLACK);
                txtPhoneCn.setTextColor(Color.BLACK);
                edtPhoneNumber.setTextColor(Color.BLACK);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    edtPhoneNumber.setBackgroundTintList(getResources().getColorStateList(R.color.black));
                    chxCallP1.setButtonTintList(getResources().getColorStateList(R.color.black));
                    chxCallP2.setButtonTintList(getResources().getColorStateList(R.color.black));
                    chxP1.setButtonTintList(getResources().getColorStateList(R.color.black));
                    chxP2.setButtonTintList(getResources().getColorStateList(R.color.black));
                    chxControl.setButtonTintList(getResources().getColorStateList(R.color.black));

                    chxEnDisP1.setButtonTintList(getResources().getColorStateList(R.color.black));
                    chxEnDisP2.setButtonTintList(getResources().getColorStateList(R.color.black));
                    chxAlarmP1.setButtonTintList(getResources().getColorStateList(R.color.black));
                    chxAlarmP2.setButtonTintList(getResources().getColorStateList(R.color.black));
                    chxCommonArea.setButtonTintList(getResources().getColorStateList(R.color.black));
                    chxTwoArea.setButtonTintList(getResources().getColorStateList(R.color.black));
                    chxSystemReports.setButtonTintList(getResources().getColorStateList(R.color.black));
                    chxCutVoice.setButtonTintList(getResources().getColorStateList(R.color.black));
                    chxCutPhoneLine.setButtonTintList(getResources().getColorStateList(R.color.black));
                    chxElectCity.setButtonTintList(getResources().getColorStateList(R.color.black));
                    chxAux.setButtonTintList(getResources().getColorStateList(R.color.black));

                }
                chxCallP1.setTextColor(getResources().getColor(R.color.black));
                chxCallP2.setTextColor(getResources().getColor(R.color.black));
                borderTopControlSms.setBackgroundColor(getResources().getColor(R.color.black));
                txtControlSms.setTextColor(getResources().getColor(R.color.black));
                chxP1.setTextColor(getResources().getColor(R.color.black));
                chxP2.setTextColor(getResources().getColor(R.color.black));
                chxControl.setTextColor(getResources().getColor(R.color.black));
                borderTopReportSms.setBackgroundColor(getResources().getColor(R.color.black));
                txtReportSms.setTextColor(getResources().getColor(R.color.black));

                chxEnDisP1.setTextColor(getResources().getColor(R.color.black));
                chxEnDisP2.setTextColor(getResources().getColor(R.color.black));
                chxAlarmP1.setTextColor(getResources().getColor(R.color.black));
                chxAlarmP2.setTextColor(getResources().getColor(R.color.black));
                chxCommonArea.setTextColor(getResources().getColor(R.color.black));
                chxTwoArea.setTextColor(getResources().getColor(R.color.black));
                chxSystemReports.setTextColor(getResources().getColor(R.color.black));
                chxElectCity.setTextColor(getResources().getColor(R.color.black));
                chxAux.setTextColor(getResources().getColor(R.color.black));
                chxCutPhoneLine.setTextColor(getResources().getColor(R.color.black));
                chxCutVoice.setTextColor(getResources().getColor(R.color.black));
                borderTopMissCall.setBackgroundColor(getResources().getColor(R.color.black));
                txtsp2.setTextColor(getResources().getColor(R.color.black));

                ArrayAdapter<String> adapt2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.spiner_item, str1){



                    public View getView(int position, View convertView,ViewGroup parent) {

                        View v = super.getView(position, convertView, parent);
                        txtSP1 = (TextView) v;
                        txtSP1.setTextColor(getResources().getColor(R.color.black));

                        ((TextView) v).setTextSize(13);
                        ((TextView) v).setTypeface(G.type);
                        return v;

                    }

                    public View getDropDownView(int position, View convertView,ViewGroup parent) {

                        View v = super.getDropDownView(position, convertView,parent);
                        txtSP2 = (TextView) v;
                        txtSP2.setTextColor(getResources().getColor(R.color.black));

                        ((TextView) v).setGravity(Gravity.CENTER);
                        ((TextView) v).setTypeface(G.type);

                        return v;

                    }



                };
                adapt2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);

                spiTkzng.setAdapter(adapt2);

              spiTkzng.setSelection(selectioned);



            }
        });
        viewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        lspT=(LinearLayout)findViewById(R.id.lyspTac);
        /////

        if (phoneNumber.getNumber().equals("Empty")) {
            edtPhoneNumber.setHint("شماره را وارد کنید");
        } else {
            edtPhoneNumber.setText(phoneNumber.getNumber());

            edtPhoneNumber.setSelection(edtPhoneNumber.getText().length());
        }



        if (phoneNumber.getSmsControlP1().equals("1")){
            chxP1.setChecked(true);
        }else {
            chxP1.setChecked(false);

        }
        if (phoneNumber.getSmsControlP2().equals("1")){
            chxP2.setChecked(true);
        }else {
            chxP2.setChecked(false);

        }

        if (phoneNumber.getSmsControlExit().equals("1")){
            chxControl.setChecked(true);
        }else {
            chxControl.setChecked(false);

        }

        if (phoneNumber.getEnDisP1().equals("1")){
            chxEnDisP1.setChecked(true);
        }else {
            chxEnDisP1.setChecked(false);

        }
        if (phoneNumber.getEnDisP2().equals("1")){
            chxEnDisP2.setChecked(true);
        }else {
            chxEnDisP2.setChecked(false);

        }
        if (phoneNumber.getAlarmP1().equals("1")){
            chxAlarmP1.setChecked(true);
        }else {
            chxAlarmP1.setChecked(false);

        }
        if (phoneNumber.getAlarmP2().equals("1")){
            chxAlarmP2.setChecked(true);
        }else {
            chxAlarmP2.setChecked(false);

        }
        if (phoneNumber.getCommonArea().equals("1")){
            chxCommonArea.setChecked(true);
        }else {
            chxCommonArea.setChecked(false);

        }
        if (phoneNumber.getTwoArea().equals("1")){
            chxTwoArea.setChecked(true);
        }else {
            chxTwoArea.setChecked(false);

        }


        if (phoneNumber.getSystemReports() != null && phoneNumber.getSystemReports().equals("1")){
            chxSystemReports.setChecked(true);
        }else {
            chxSystemReports.setChecked(false);

        }
        ///new option
        if ( phoneNumber.getElectCity()!= null &&phoneNumber.getElectCity().equals("1")){
            chxElectCity.setChecked(true);
        }else {
            chxElectCity.setChecked(false);

        }
        if (phoneNumber.getAux() != null &&phoneNumber.getAux().equals("1")){
            chxAux.setChecked(true);
        }else {
            chxAux.setChecked(false);

        }
        if ( phoneNumber.getCutVoice()!= null &&phoneNumber.getCutVoice().equals("1")){
            chxCutVoice.setChecked(true);
        }else {
            chxCutVoice.setChecked(false);

        }
        if ( phoneNumber.getCutPhone()!= null &&phoneNumber.getCutPhone().equals("1")){
            chxCutPhoneLine.setChecked(true);
        }else {
            chxCutPhoneLine.setChecked(false);

        }






        if (phoneNumber.getVoiceCallP1().equals("1")){
            chxCallP1.setChecked(true);
        }else {
            chxCallP1.setChecked(false);

        }
        if (phoneNumber.getVoiceCallP2().equals("1")){
            chxCallP2.setChecked(true);
        }else {
            chxCallP2.setChecked(false);

        }






//edtPhoneNumber.requestFocus();
//        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
//        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);


        main=new ActivityMain();

        txtMamoryEdit.setText("حافظه " + phoneNumber.getNumMemory());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {









        }

        ///.............................................................

spiTkzng.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        hidekeyboard();
        return false;
    }
});





        spiTkzng.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
               // mediaPlayer.start();
                phoneNumber.setMisCallControl(arg0.getItemAtPosition(arg2).toString());


            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }

        });

        ///.............................................................


        ///.............................................................






        edtPhoneNumber.addTextChangedListener(new TextWatcher() {
            private Pattern sPatternMobile1
                    = Pattern.compile("09(.\\d+)");
            private Pattern sPatternMobile2
                    = Pattern.compile("09(.\\d)");
            private Pattern sPatternMobile3
                    = Pattern.compile("09(.)");
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
                txtPhoneCn.setText("16/" + String.valueOf(edtPhoneNumber.getText().toString().length()));


                if (sPatternMobile1.matcher(edtPhoneNumber.getText().toString()).matches() ||
                        sPatternMobile2.matcher(edtPhoneNumber.getText().toString()).matches() ||
                        sPatternMobile3.matcher(edtPhoneNumber.getText().toString()).matches()


                ){
                    borderTopControlSms.setVisibility(View.VISIBLE);
                    txtControlSms.setVisibility(View.VISIBLE);
                    lch.setVisibility(View.VISIBLE);
                    txtReportSms.setVisibility(View.VISIBLE);
                    linReportSms.setVisibility(View.VISIBLE);
                    borderTopMissCall.setVisibility(View.VISIBLE);

                    linVoiceCall.setVisibility(View.VISIBLE);
                    lyspTac.setVisibility(View.VISIBLE);
                }else {
                    borderTopControlSms.setVisibility(View.GONE);
                    txtControlSms.setVisibility(View.GONE);
                    lch.setVisibility(View.GONE);
                    txtReportSms.setVisibility(View.GONE);
                    linReportSms.setVisibility(View.GONE);
                    borderTopMissCall.setVisibility(View.GONE);
                    if (edtPhoneNumber.getText().toString().length()>0){
                        linVoiceCall.setVisibility(View.VISIBLE);
                        lyspTac.setVisibility(View.VISIBLE);
                    }else {
                        linVoiceCall.setVisibility(View.GONE);
                        lyspTac.setVisibility(View.GONE);
                    }

                }


            }
        });

        ///.............................................................

        btnExit.setOnClickListener(
        new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                
hidekeyboard();
                G.currentActivity.finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {




//                if (chkSmsControl.isChecked()) {
//
//                } else {
//
//                }

                Tkzng();
                phoneNumber.setSmsControlP1(chxP1.isChecked() ? 1+"" : 0+"");
                phoneNumber.setSmsControlP2(chxP2.isChecked() ? 1+"" : 0+"");
                phoneNumber.setSmsControlExit(chxControl.isChecked() ? 1+"" : 0+"");
                phoneNumber.setEnDisP1(chxEnDisP1.isChecked() ? 1+"" : 0+"");
                phoneNumber.setEnDisP2(chxEnDisP2.isChecked() ? 1+"" : 0+"");
                phoneNumber.setAlarmP1(chxAlarmP1.isChecked() ? 1+"" : 0+"");
                phoneNumber.setAlarmP2(chxAlarmP2.isChecked() ? 1+"" : 0+"");
                phoneNumber.setCommonArea(chxCommonArea.isChecked() ? 1+"" : 0+"");
                phoneNumber.setTwoArea(chxTwoArea.isChecked() ? 1+"" : 0+"");

                phoneNumber.setSystemReports(chxSystemReports.isChecked() ? 1+"" : 0+"");
                phoneNumber.setElectCity(chxElectCity.isChecked() ? 1+"" : 0+"");
                phoneNumber.setAux(chxAux.isChecked() ? 1+"" : 0+"");
                phoneNumber.setCutVoice(chxCutVoice.isChecked() ? 1+"" : 0+"");
                phoneNumber.setCutPhone(chxCutPhoneLine.isChecked() ? 1+"" : 0+"");




                phoneNumber.setVoiceCallP1(chxCallP1.isChecked() ? 1+"" : 0+"");
                phoneNumber.setVoiceCallP2(chxCallP2.isChecked() ? 1+"" : 0+"");

                String str = "";
                if(!G.versionNameMainSoftWareDevice.equals("") &&
                        Integer.parseInt(G.versionNameMainSoftWareDevice)>1 ){
                    str = ("SavePhon," + phoneNumber.getNumMemory()+ "," + (edtPhoneNumber.getText().toString()) +
                            ","+ phoneNumber.getVoiceCallP1()+phoneNumber.getVoiceCallP2()+
                            phoneNumber.getSmsControlP1()+phoneNumber.getSmsControlP2()
                            +phoneNumber.getSmsControlExit()+phoneNumber.getEnDisP1()+phoneNumber.getEnDisP2()
                            +phoneNumber.getAlarmP1()+phoneNumber.getAlarmP2()+phoneNumber.getCommonArea()+phoneNumber.getTwoArea()


                            +phoneNumber.getElectCity()
                            +phoneNumber.getAux()
                            +phoneNumber.getCutVoice()
                            +phoneNumber.getCutPhone()

                            +phoneNumber.getMisCallControl() );
                }else {
                    str = ("SavePhon," + phoneNumber.getNumMemory()+ "," + (edtPhoneNumber.getText().toString()) +
                            ","+ phoneNumber.getVoiceCallP1()+phoneNumber.getVoiceCallP2()+
                            phoneNumber.getSmsControlP1()+phoneNumber.getSmsControlP2()
                            +phoneNumber.getSmsControlExit()+phoneNumber.getEnDisP1()+phoneNumber.getEnDisP2()
                            +phoneNumber.getAlarmP1()+phoneNumber.getAlarmP2()+phoneNumber.getCommonArea()+phoneNumber.getTwoArea()
                            +phoneNumber.getSystemReports()+phoneNumber.getMisCallControl() );
                }





                main.SendBt(str);
                G.currentActivity.finish();
            }
        });







        view_descips.add(new view_descip(lspT,"توضیحات"
                ,"در این قسمت مشخص کنید این شماره اجازه فعال کردن دستگاه با تک زنگ را دارد یا خیر"));





        spiTkzng.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(3));
                return true;
            }
        });
        txtsp2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(3));
                return true;
            }
        });



    }

    public void setviewHelp(view_descip view){
        TapTargetView.showFor(dialog,                 // `this` is an Activity
                TapTarget.forView(view.getView(), view.getTitle(), view.getDesc())

                        // All options below are optional
                        .outerCircleColor(R.color.blue)      // Specify a color for the outer circle
                        .outerCircleAlpha(0.96f)            // Specify the alpha amount for the outer circle
                        .targetCircleColor(R.color.white)   // Specify a color for the target circle
                        .titleTextSize(20)                  // Specify the size (in sp) of the title text
                        .titleTextColor(R.color.white)      // Specify the color of the title text
                        .descriptionTextSize(15)            // Specify the size (in sp) of the description text
                        .descriptionTextColor(R.color.red)  // Specify the color of the description text
                        .textColor(R.color.black)            // Specify a color for both the title and description text
                        .textTypeface(Typeface.SANS_SERIF)  // Specify a typeface for the text
                        .dimColor(R.color.black)// If set, will dim behind the view with 30% opacity of the given color
                        .drawShadow(true)               // Whether to draw a drop shadow or not
                        .cancelable(true)                  // Whether tapping outside the outer circle dismisses the view

                        .tintTarget(true)
                        // Whether to tint the target view's color
                        .transparentTarget(true)// Specify whether the target is transparent (displays the content underneath)
                        // Specify a custom drawable to draw as the target
                        .targetRadius(30)// Specify the target radius (in dp)
                ,  new TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
                    @Override
                    public void onTargetClick(TapTargetView view) {
                        super.onTargetClick(view);      // This call is optional





                    }



                });
    }



    public void s(view_descip view){
        SimpleTarget firstTarget = new SimpleTarget.Builder(ActivityEditSmsNumberMGZ8.this)
                .setShape(new Circle(200f))
                .setPoint(view.getView())
                .setTitle(view.getTitle())
                .setDescription(view.getDesc())
                .build();




        Spotlight.with(ActivityEditSmsNumberMGZ8.this)
                .setOverlayColor(R.color.background)
                .setDuration(100L)
                .setAnimation(new DecelerateInterpolator(2f))
                .setTargets(firstTarget)

                .setClosedOnTouchedOutside(true)
                .setOnSpotlightStateListener(new OnSpotlightStateChangedListener() {
                    @Override
                    public void onStarted() {
                        //  Toast.makeText(ActivityEditSmsNumberMG4.this, "spotlight is started", Toast.LENGTH_SHORT)                                .show();

                    }

                    @Override
                    public void onEnded() {
                      //  Toast.makeText(ActivityEditSmsNumberMG4.this, "spotlight is ended", Toast.LENGTH_SHORT).show();
                    }
                })
                .start();




    }




    @Override
    protected void onDestroy() {
        hidekeyboard();
        super.onDestroy();
    }

    private void Tkzng() {

        if (phoneNumber.getMisCallControl().equals( "غیرفعال")) {
            phoneNumber.setMisCallControl("0");

        }
        else if (phoneNumber.getMisCallControl() .equals( "تغییر حالت پارتیشن یک")) {
            phoneNumber.setMisCallControl("1");

        }
        else if (phoneNumber.getMisCallControl() .equals( "تغییر حالت پارتیشن دو")) {
            phoneNumber.setMisCallControl("2");

        }
        else if (phoneNumber.getMisCallControl() .equals( "روشن کردن پارتیشن یک")) {
            phoneNumber.setMisCallControl("3");

        }
        else if (phoneNumber.getMisCallControl() .equals( "روشن کردن پارتیشن دو")) {
            phoneNumber.setMisCallControl("4");

        }
        else if (phoneNumber.getMisCallControl() .equals( "خاموش کردن پارتیشن یک")) {
            phoneNumber.setMisCallControl("5");

        }else {
            phoneNumber.setMisCallControl("6");


        }


    }


    ///.................................................



    public void   hidekeyboard(){
        try {

            InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(edtPhoneNumber.getWindowToken(), 0);

        }catch (Exception e){

        }}

    public void setSpinerTxtCenert(){

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

    @Override
    protected void onPause() {
        super.onPause();

    }
}
