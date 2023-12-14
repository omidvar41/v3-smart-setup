package smart.SmartSetup.MG4.Edit;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
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

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.takusemba.spotlight.OnSpotlightStateChangedListener;
import com.takusemba.spotlight.Spotlight;
import com.takusemba.spotlight.shape.Circle;
import com.takusemba.spotlight.target.SimpleTarget;

import java.util.ArrayList;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.MG4.view_descip;
import smart.SmartSetup.R;

public class ActivityEditSmsNumberMG4 extends EnhancedActivity  {

public static smart.SmartSetup.MG4.Edit.ActivityEditSmsNumberMG4 activityEditSmsNumberMG4;
    TextView txtMamoryEdit,txtsp1,txtsp2;
    Button btnExit;
    Button   btnSave;
    EditText edtPhoneNumber;
    String   Mamory, Namber, Control, Tkzng, Report;

    Spinner spiTkzng;
    String[] str1 = { "غیرفعال", "فعال کردن دزدگیر", "غیرفعال کردن دزدگیر", "تغییر حالت دزدگیر" };

    Spinner  spiReport;
    String[] str2 = { "غیرفعال", "همه گزارش ها(Full)", "فقط هشدارها(Economy)" };

    String   SelectedReport, SelectedTkzng, SelectedSmsControl;
    ActivityMain main;
    Button   btnsendSmsResult;

    CheckBox chkSmsControl;

    ArrayList<view_descip> view_descips=new ArrayList<>();
    LinearLayout lch,lspT,lspR;

    Dialog dialog;
MediaPlayer mediaPlayer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mg4_activity_edit_sms_number);



        dialog=new Dialog(this);
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
        activityEditSmsNumberMG4 =this;
        btnsendSmsResult=(Button)findViewById(R.id.btnsendSmsResult);

        txtMamoryEdit = (TextView) findViewById(R.id.txtMamoryEdit);

        btnExit = (Button) findViewById(R.id.btnExit);
        btnSave = (Button) findViewById(R.id.btnSave);
        edtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumber);
        chkSmsControl = (CheckBox) findViewById(R.id.chkSmsControl);
        chkSmsControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidekeyboard();
            }
        });

        lch=(LinearLayout)findViewById(R.id.lycheakbox);
        lspR=(LinearLayout)findViewById(R.id.lyspRep);
        lspT=(LinearLayout)findViewById(R.id.lyspTac);

//edtPhoneNumber.requestFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);

        ///.............................................................
        spiTkzng = (Spinner) findViewById(R.id.spiTkzng);
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, R.layout.spiner_item, str1){



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

        ///..............................................................

        main=new ActivityMain();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("MAMORY")) {
                Mamory = extras.getString("MAMORY");
                txtMamoryEdit.setText("حافظه " + Mamory);
            }

            if (extras.containsKey("NAMBER")) {
                Namber = extras.getString("NAMBER");
                if (Namber.equals("Empty")) {
                    edtPhoneNumber.setHint("شماره را وارد کنید");
                } else {
                    edtPhoneNumber.setText(Namber);
                    edtPhoneNumber.setSelection(edtPhoneNumber.getText().length());
                }

            }

            if (extras.containsKey("CONTROL")) {
                Control = extras.getString("CONTROL");
                if (Control.equals("0")) {
                    chkSmsControl.setChecked(false);
                } else {
                    chkSmsControl.setChecked(true);
                }
            }

            if (extras.containsKey("TKZNG")) {
                Tkzng = extras.getString("TKZNG");
                if (Tkzng.equals("0")) {
                    spiTkzng.setSelection(0);
                }

                else if (Tkzng.equals("B")) {
                    spiTkzng.setSelection(1);
                }
                else if (Tkzng.equals("C")) {
                    spiTkzng.setSelection(2);
                }
                else if (Tkzng.equals("D")) {
                    spiTkzng.setSelection(3);
                }

            }

            if (extras.containsKey("REPORT")) {
                Report = extras.getString("REPORT");
                if (Report.equals("0")) {
                    spiReport.setSelection(0);
                }
                if (Report.equals("1")) {
                    spiReport.setSelection(1);
                }
                if (Report.equals("2")) {
                    spiReport.setSelection(2);
                }
            }
        }

        ///.............................................................

spiTkzng.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        
        hidekeyboard();
        return false;
    }
});
        spiReport.setOnTouchListener(new View.OnTouchListener() {
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
                SelectedTkzng = arg0.getItemAtPosition(arg2).toString();


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

                if (str.equals("همه گزارش ها(Full)")){
                    SelectedReport="Full";
                }else if (str.equals("فقط هشدارها(Economy)")){
                    SelectedReport="Economy";
                }else {
                    SelectedReport="غیرفعال";
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });
        ///.............................................................


        if (edtPhoneNumber.getText().toString().equals("")){
            btnsendSmsResult.setVisibility(View.GONE);
        }else {
            btnsendSmsResult.setVisibility(View.VISIBLE);
        }



        edtPhoneNumber.addTextChangedListener(new TextWatcher() {

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
                TextView txtPhoneCn = (TextView) findViewById(R.id.txtPhoneCn);
                txtPhoneCn.setText("16/" + String.valueOf(edtPhoneNumber.length()));

                if (edtPhoneNumber.getText().toString().equals("")){
                    btnsendSmsResult.setVisibility(View.GONE);
                }else {
                    btnsendSmsResult.setVisibility(View.VISIBLE);
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



hidekeyboard();

                if (chkSmsControl.isChecked()) {
                    SelectedSmsControl = "1";
                } else {
                    SelectedSmsControl = "0";
                }

                Tkzng();
                Report();

                String str = ("Save1," + (Mamory) + "," + (edtPhoneNumber.getText().toString()) +
                        "," + SelectedSmsControl + "," + SelectedTkzng + "," + SelectedReport);
             //  ActivityMain main=new ActivityMain();
                main.SendBt(str);
                G.currentActivity.finish();
            }
        });

        btnsendSmsResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
hidekeyboard();

                if (chkSmsControl.isChecked()) {
                    SelectedSmsControl = "1";
                } else {
                    SelectedSmsControl = "0";
                }

                Tkzng();
                Report();


                String str = ("Save&Test," + (Mamory) + "," + (edtPhoneNumber.getText().toString())
                        + "," + SelectedSmsControl + "," + SelectedTkzng + "," + SelectedReport);

                main.SendBt(str);
                finish();

            }
        });




        view_descips.add(new view_descip(btnsendSmsResult,
                "توضیحات","به شماره وارد شده یک پیامک آزمایشی جهت تست ارسال میکند"));

        view_descips.add(new view_descip(chkSmsControl,
                "توضیحات"," اگر میخواهید شماره وارد شده در این حافظه،دستگاه را با پیامک کنترل کند" +
                "این قسمت را فعال کنید"));

        view_descips.add(new view_descip(lspR,
                "توضیحات","در این قسمت مشخص کنید گزارش های دستگاه برای این شماره ارسال شود یا خیر"));

        view_descips.add(new view_descip(lspT,"توضیحات"
                ,"در این قسمت مشخص کنید این شماره اجازه فعال کردن دستگاه با تک زنگ را دارد یا خیر"));


        btnsendSmsResult.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(0));
                return true;
            }
        });
        chkSmsControl.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(1));
                return true;
            }
        });

        spiReport.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(2));
                return true;
            }
        });

        txtsp1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(2));
                return true;
            }
        });
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
        SimpleTarget firstTarget = new SimpleTarget.Builder(smart.SmartSetup.MG4.Edit.ActivityEditSmsNumberMG4.this)
                .setShape(new Circle(200f))
                .setPoint(view.getView())
                .setTitle(view.getTitle())
                .setDescription(view.getDesc())
                .build();




        Spotlight.with(smart.SmartSetup.MG4.Edit.ActivityEditSmsNumberMG4.this)
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

        if (SelectedTkzng.equals( "غیرفعال")) {
            SelectedTkzng = "0";
        }
        else if (SelectedTkzng .equals( "فعال کردن OUT1")) {
            SelectedTkzng = "1";
        }

        else if (SelectedTkzng .equals( "فعال کردن OUT2") ){
            SelectedTkzng = "2";
        }
        else if (SelectedTkzng .equals( "غیرفعال کردن OUT2")) {
            SelectedTkzng = "3";
        }
        else if (SelectedTkzng .equals( "تغییر حالت OUT2") ){
            SelectedTkzng = "4";
        }

        else if (SelectedTkzng .equals( "فعال کردن OUT3")) {
            SelectedTkzng = "5";
        }
        else if (SelectedTkzng .equals( "غیرفعال کردن OUT3")) {
            SelectedTkzng = "6";
        }
        else if (SelectedTkzng .equals( "تغییر حالت OUT3")) {
            SelectedTkzng = "7";
        }

        else if (SelectedTkzng .equals( "فعال کردن OUT4")) {
            SelectedTkzng = "8";
        }
        else if (SelectedTkzng .equals( "غیرفعال کردن OUT4")) {
            SelectedTkzng = "9";
        }
        else if (SelectedTkzng .equals( "تغییر حالت OUT4")) {
            SelectedTkzng = "A";
        }

        else if (SelectedTkzng .equals( "فعال کردن دزدگیر")) {
            SelectedTkzng = "B";
        }
        else if (SelectedTkzng .equals( "غیرفعال کردن دزدگیر")) {
            SelectedTkzng = "C";
        }
        else if (SelectedTkzng .equals( "تغییر حالت دزدگیر")) {
            SelectedTkzng = "D";
        }
    }


    ///.................................................

    private void Report() {

        if (SelectedReport .equals( "Full") ){
            SelectedReport = "1";
        }
        else if (SelectedReport .equals( "Economy")) {
            SelectedReport = "2";
        }
        else if (SelectedReport .equals( "غیرفعال")) {
            SelectedReport = "0";
        }

    }

    public void   hidekeyboard(){
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtPhoneNumber.getWindowToken(), 0);
    }

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
