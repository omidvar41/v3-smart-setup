package smart.SmartSetup;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.glide.slider.library.SliderLayout;
import com.glide.slider.library.SliderTypes.BaseSliderView;
import com.glide.slider.library.SliderTypes.TextSliderView;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import info.hoang8f.widget.FButton;
import smart.SmartSetup.G4.ActivityListG4;
import smart.SmartSetup.MG4.Activity_List_MG4;

import smart.SmartSetup.MG4.Edit.Dialog_Close_app;
import smart.SmartSetup.MG4.Edit.Dialog_save_Pass;
import smart.SmartSetup.MG4.Edit.Progress_dialog_wait;
import smart.SmartSetup.MG4.view_descip;
import smart.SmartSetup.MGZ8.About_System;
import smart.SmartSetup.MGZ8.ActivityOutNameMGZ8;
import smart.SmartSetup.MGZ8.ActivityRemoteNameMGZ8;
import smart.SmartSetup.MGZ8.ActivitySmsNumberMGZ8;
import smart.SmartSetup.MGZ8.ActivityZonNameMGZ8;
import smart.SmartSetup.MGZ8.Activity_List_MGZ8;
import smart.SmartSetup.MGZ8.Edit.ActivityEditSmsNumberMGZ8;
import smart.SmartSetup.MGZ8.Edit.ActivityEditZonNameMGZ8;
import smart.SmartSetup.MGZ8.models.OutName;
import smart.SmartSetup.MGZ8.models.Remote;
import smart.SmartSetup.MGZ8.models.Zon;
import smart.SmartSetup.MGZ8.models.phoneNumber;

import static smart.SmartSetup.MGZ8.ActivityPanelMGZ8.SeekBarAlarm;
import static smart.SmartSetup.MGZ8.ActivityPanelMGZ8.SeekBarExit;
import static smart.SmartSetup.MGZ8.ActivityPanelMGZ8.SeekBarStart;
import static smart.SmartSetup.MGZ8.ActivityPanelMGZ8.SeekBarTak;
import static smart.SmartSetup.MGZ8.ActivityPanelMGZ8.numDelayAlarm;
import static smart.SmartSetup.MGZ8.ActivityPanelMGZ8.numDelayExit;
import static smart.SmartSetup.MGZ8.ActivityPanelMGZ8.numDelayStart;
import static smart.SmartSetup.MGZ8.ActivityPanelMGZ8.numTakBib;

public class ActivityMain extends EnhancedActivity implements BluetoothSPPConnectionListener {
    public static ActivityMain activityMain;
    ProgressDialog dialog;
    boolean flaglostBl = false;
    int flag;
    int count = 0;
    boolean button = false;
    int NUMBER_ELEMENT_VIEW = 1;
    public static String flagGO = "0";

    public static FButton bt;
    public ActivityZonNameMGZ8 activityZonNameMGZ8;

    private byte[] dataBuffer;
    private byte[] dataBuffer1;
    public static BluetoothSPPConnection mBluetoothSPPConnection;
    static BluetoothAdapter mBluetoothAdapter = null;
    static byte[] command;
    AlertDialog alertDialog;
    public static String CodeChekCharge = "";
    public static String CodeCharge = "";
    public static String Cusd = "";
    public static String textZonMGZ8 = "";
    public static String bord = "";
    public static String dialer = "";
    public static String Iemi = "";
    public static String typeTriger = "";
    public static String cityCode = "";
    public static List<Zon> zonList = new ArrayList<>();

    private static final int REQUEST_CONNECT_DEVICE = 1;
    private static final int REQUEST_ENABLE_BT = 2;

    public static List<phoneNumber> phoneNumberList = new ArrayList<>();

    public static String[] NumberSmsMemory = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
    public static String[] ReportSmsMemory = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
    public static String[] TkzngSmsMemory = {" ", " ", "", "", " ", " ", " ", " ", " ", " ", " "};
    public static String[] ControlSmsMemory = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
    public static String[] Remot = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
    public static List<Remote> remoteList = new ArrayList<>();
    public static List<smart.SmartSetup.MGZ8.models.OutName> outNameList = new ArrayList<>();


    public static String[] Wireles = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};

    public static String[] OutName = {" ", " ", " ", " "};
    public static String[] ZonName = {" ", " ", " ", " "};
    public static String[] Panel = {" ", " ", " ", " "};
    public static String[] TrigText = {" ", " ", " ", " ", " "};
    public static String LCD = "SMART";
    public static String LCD_DIALOG = "";
    public static String nameOperator = "";
    public static String numAn = "";
    ImageView helpbtn;
    public static String[] NumberPhoneMemory = {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty",
            "Empty", "Empty", "Empty", "Empty", "Empty"};


    int numAllPartZon = 0;
    int numNowPartZon = 0;
    TextView gosite;

    public String falgProgress = "0";

    public String SEND_SMS = "1";
    public String SEND_OK = "2";
    public String SEND_ERROR = "3";
    public String OPEN_DIALOG = "1";
    public String CLOSE_DIALOG = "0";
    public String SAVE = "4";
    public String CALLING = "5";
    public String AZHIR_CALL = "6";
    public String MASSAGE_SEND = "7";
    public String CALLING_SIM = "8";
    public String SAVE_PASS = "9";
    MediaPlayer mediaPlayer;
    public static FButton go_list;
    ArrayList<view_descip> view_descips;
    TextView txt_version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMain = this;
        view_descips = new ArrayList<>();
        bt = (FButton) findViewById(R.id.connect);
        bt.setButtonColor(getResources().getColor(R.color.white));


        helpbtn = (ImageView) findViewById(R.id.help);
        gosite = (TextView) findViewById(R.id.goSite);
        txt_version = (TextView) findViewById(R.id.txtVersion);


        //write version app
        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String version = pInfo.versionName;
            txt_version.setText("Version : " + version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


        go_list = (FButton) findViewById(R.id.go_list);
        go_list.setButtonColor(getResources().getColor(R.color.white));


        view_descips.add(new view_descip(helpbtn, "توضیحات", "برای  راهنمایی روی هر آیتم انگشت خود را نگه دارید"));
        view_descips.add(new view_descip(gosite, "توضیحات", "با زدن این دکمه از سایت ما دیدن کنید"));
        view_descips.add(new view_descip(bt, "اتصال دستگاه", "بلوتوث دستگاه را روشن کنید و این دکمه را فشار دهید"));


        gosite.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setdviewHelp(view_descips.get(1));
                return true;
            }
        });
        bt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setdviewHelp(view_descips.get(2));

                return true;
            }
        });


        go_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // throw new RuntimeException("Test Crash");
                // Force a crash
                if (G.connected) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                            ActivityCompat.checkSelfPermission(getApplicationContext(),
                                    Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {

                        requestPermissions(new String[]{Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT},
                                49);


                        return;
                    }


                    if (mBluetoothSPPConnection.getDeviceName().equals(getString(R.string.device_1))) {
                        startActivity(new Intent(getApplicationContext(), ActivityListG4.class));

                    }


                    if (mBluetoothSPPConnection.getDeviceName().equals(getString(R.string.device_2))) {
                        startActivity(new Intent(getApplicationContext(), Activity_List_MG4.class));


                    }
                    if (mBluetoothSPPConnection.getDeviceName().equals(getString(R.string.device_3))) {
                        startActivity(new Intent(getApplicationContext(), Activity_List_MGZ8.class));


                    }
                    if (mBluetoothSPPConnection.getDeviceName().equals(getString(R.string.default_name))) {
                        SendBt("Model?");


                    }


                }
            }
        });

        helpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                NUMBER_ELEMENT_VIEW = 1;
                setdviewHelp(view_descips.get(0));
                SharedPreferences.Editor editor = getSharedPreferences("code_help_main", MODE_PRIVATE).edit();
                editor.putString("code", "1");
                editor.apply();
            }

        });
        dialog = new ProgressDialog(getApplicationContext());


        setslider();

        gosite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.smartalarm.ir")));
            }
        });
        mBluetoothSPPConnection = new BluetoothSPPConnection(this); // Registers
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


        TextView textView = (TextView) findViewById(R.id.textViewPass);
        final String NConect = textView.getText().toString();

//        if (!mBluetoothAdapter.isEnabled()) {
//
//            CustomDialogClass cdd = new CustomDialogClass(ActivityMain.this);
//            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            cdd.show();
//            cdd.setCancelable(false);
//            cdd.setCanceledOnTouchOutside(false);
//
//
//        }

        IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(mReceiver, filter);


        if (mBluetoothAdapter.isEnabled()) {


            SharedPreferences prefs = getSharedPreferences("code_help_main", MODE_PRIVATE);
            String restoredText = prefs.getString("code", null);
            if (restoredText != null) {

            } else {
                setdviewHelp(view_descips.get(0));
                SharedPreferences.Editor editor = getSharedPreferences("code_help_main", MODE_PRIVATE).edit();
                editor.putString("code", "1");
                editor.apply();
            }




            bt.setText("اتصال");


            bt.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {





                    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                        enableLocationSettings();
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                            ActivityCompat.checkSelfPermission(getApplicationContext(),
                                    Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {

                        requestPermissions(new String[]{Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT},
                                49);


                        return;
                    }


                    mBluetoothAdapter.enable();

                    if (!G.connected) {
                        //     bt.setCompoundDrawables(getResources().getDrawable(R.drawable.blutose_enable),null,null,null);
                        setdisBlIco();
                        Set<BluetoothDevice> c = mBluetoothAdapter.getBondedDevices();

                        BluetoothDevice[] myArray = new BluetoothDevice[c.size()];
                        c.toArray(myArray);


                        BluetoothDevice device;
                        List<BluetoothDevice> list = new ArrayList<>();

                        for (int i = 0; i < myArray.length; i++) {
                            device = myArray[i];
                            if (device.getName().equals(getString(R.string.device_1)) ||
                                    device.getName().equals(getString(R.string.device_2))
                                    || device.getName().equals(getString(R.string.device_3)) ||
                                    device.getName().equals(getString(R.string.default_name))) {

                                list.add(device);


                            }
                            Log.e("-------------", device.getName());
                        }


                        if (list.isEmpty()) {
                            Toast.makeText(getApplicationContext(), "دستگاهی جفت نشده است.", Toast.LENGTH_SHORT).show();

                        } else {
                            if(list.size() == 1){
                                ActivityMain.mBluetoothSPPConnection.open(list.get(0));

                            }else {
                                dialog_device_list dialog_device_list = new dialog_device_list(ActivityMain.this, list);
                                dialog_device_list.show();
                            }



                        }


                        // Intent serverIntent = new Intent(v.getContext(), ActivityDeviceList1.class);
//                        startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);
                        // When connected, close the bluetooth connection.
                    } else {
                        setdisBlIco();

                        mBluetoothSPPConnection.close();
                    }
                }
            });

            //.........................................................................

        } else {
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS));

                }
            });
        }

        /*
        if (getIntent().getBooleanExtra("EXIT", false)) {
            mBluetoothAdapter.enable();
            AlertDialog.Builder builder = new AlertDialog.Builder(G.currentActivity);
            builder.setTitle("توضیح");
            builder.setMessage("آژیر به صدا درآمد(در این حالت ارتباط بلوتوث قطع میشود)");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.create().show();
        }
        */

    }

    protected void enableLocationSettings() {
        LocationRequest locationRequest = LocationRequest.create()
                .setInterval(10000)
                .setFastestInterval(5000)
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);

        LocationServices
                .getSettingsClient(this)
                .checkLocationSettings(builder.build())
                .addOnSuccessListener(this, (LocationSettingsResponse response) -> {
                    // startUpdatingLocation(...);
                })
                .addOnFailureListener(this, ex -> {
                    if (ex instanceof ResolvableApiException) {
                        // Location settings are NOT satisfied,  but this can be fixed  by showing the user a dialog.
                        try {
                            // Show the dialog by calling startResolutionForResult(),  and check the result in onActivityResult().
                            ResolvableApiException resolvable = (ResolvableApiException) ex;
                            resolvable.startResolutionForResult(ActivityMain.this, 10);
                        } catch (IntentSender.SendIntentException sendEx) {
                            // Ignore the error.
                        }
                    }
                });
    }

    public void setEnBlIco() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            bt.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.blutose_enable), null, null, null);
        }
    }

    public void setdisBlIco() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            bt.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.blutose_disable), null, null, null);
        }
    }

    public void setslider() {
     /*
            arrMessages.add("Smart Security System");

            arrMessages.add("WWW.SmartAlarm.IR");

            arrMessages.add("Security");
            arrMessages.add("WWW.SmartAlarm.IR");
            rMessages.add("SMART ALARM");
    /*
            t1 = findViewById(R.id.goSite);
            t1.animateText(arrMessages.get(position));
            position++;

            handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {

                    handler.postDelayed(this, 4000);
                    if (position >= arrMessages.size())
                        position = 0;
                    //    textView.animateText(arrMessages.get(position));
                    t1.animateText(arrMessages.get(position));
                    // textViewRainBow.animateText(arrMessages.get(position));
                    //textViewTyper.animateText(arrMessages.get(position));
                    // textViewFade.animateText(arrMessages.get(position));
                    //  textViewLine.animateText(arrMessages.get(position));
                    position++;
                }
            }, 4000);

    */
        SliderLayout sliderShow = (SliderLayout) findViewById(R.id.slider);

        TextSliderView textSliderView = new TextSliderView(this);
        textSliderView
                .description("SMART Z4")
                .image(R.drawable.zfour).setBackgroundColor(Color.alpha(0)).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView baseSliderView) {
                        goDialogDescrip("1");

                    }
                });

        TextSliderView textSliderView2 = new TextSliderView(this);
        textSliderView2
                .description("SMART G4")
                .image(R.drawable.g_one).setBackgroundColor(Color.alpha(0)).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView baseSliderView) {
                        goDialogDescrip("2");
                    }
                });


        TextSliderView textSliderView3 = new TextSliderView(this);
        textSliderView3
                .description("SMART TS10")
                .image(R.drawable.tsten).setBackgroundColor(Color.alpha(0)).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView baseSliderView) {
                        goDialogDescrip("3");

                    }
                });


        sliderShow.addSlider(textSliderView);
        sliderShow.addSlider(textSliderView2);
        sliderShow.addSlider(textSliderView3);
        sliderShow.setPresetTransformer(SliderLayout.Transformer.FlipPage);


    }


    public void goDialogDescrip(String code) {
        Intent intent = new Intent(ActivityMain.this, Dialog_tabligh.class);
        //intent.putExtra("code",code);
        Dialog_tabligh.code = code;
        startActivity(intent);


    }


    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
                final int bluetoothState = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
                switch (bluetoothState) {
                    case BluetoothAdapter.STATE_ON:


                        SharedPreferences prefs = getSharedPreferences("code_help_main", MODE_PRIVATE);
                        String restoredText = prefs.getString("code", null);
                        if (restoredText != null) {

                        } else {
                            setdviewHelp(view_descips.get(0));
                            SharedPreferences.Editor editor = getSharedPreferences("code_help_main", MODE_PRIVATE).edit();
                            editor.putString("code", "1");
                            editor.apply();
                        }


                        bt.setText("اتصال");
                        bt.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                                        ActivityCompat.checkSelfPermission(getApplicationContext(),
                                                Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {

                                    requestPermissions(new String[]{Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT},
                                            49);


                                    return;
                                }

                                mBluetoothAdapter.enable();
                                // When not connected, start the ActivityMain that allows
                                // the user to select a device.
                                // The activity will return a bluetoothdevice and on that
                                // return, the onActivityResult() (see below)
                                // member function is called.
                                if (!G.connected) {

                                    setdisBlIco();

                                    Set<BluetoothDevice> c = mBluetoothAdapter.getBondedDevices();

                                    BluetoothDevice[] myArray = new BluetoothDevice[c.size()];
                                    c.toArray(myArray);


                                    BluetoothDevice device;
                                    List<BluetoothDevice> list = new ArrayList<>();

                                    for (int i = 0; i < myArray.length; i++) {
                                        device = myArray[i];
                                        if (device.getName().equals(getString(R.string.device_1)) ||
                                                device.getName().equals(getString(R.string.device_2))
                                                || device.getName().equals(getString(R.string.device_3)) ||
                                                device.getName().equals(getString(R.string.default_name))) {

                                            list.add(device);


                                        }
                                        Log.e("-------------", device.getName());
                                    }


                                    if (list.isEmpty()) {
                                        Toast.makeText(getApplicationContext(), "دستگاهی جفت نشده است.", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS));

                                    } else {
                                        if(list.size() == 1){
                                            ActivityMain.mBluetoothSPPConnection.open(list.get(0));

                                        }else {
                                            dialog_device_list dialog_device_list = new dialog_device_list(ActivityMain.this, list);
                                            dialog_device_list.show();
                                        }



                                    }

                                    // When connected, close the bluetooth connection.
                                } else {
                                    setdisBlIco();
                                    button = false;
                                    mBluetoothSPPConnection.close();
                                }
                            }
                        });
                        break;
                }
            }
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {

        // Close the bluetooth connection
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT},
                    49);


            return;
        }


        unregisterReceiver(mReceiver);
        mBluetoothAdapter.disable(); ///  خاموش کردن بلوتوث
        mBluetoothSPPConnection.close();
        unpairAllDevice();
        super.onDestroy();
    }


    ////...........................................................................
    public void SendBt(String str) {

        //Toast.makeText(getApplicationContext(),""+str+"",Toast.LENGTH_LONG).show();
        if (str != null) {
            command = str.getBytes();
            mBluetoothSPPConnection.write(command);


        }
    }


    ////...........................................................................

    private void PasswordAlertDialog(String name) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(ActivityMain.this);


        dialog.setTitle(name);
        dialog.setCancelable(true);
        dialog.setIcon(R.drawable.ic_launcher);
        dialog.setMessage("رمز را وارد کنید");
        final EditText editText = new EditText(this);


        editText.setGravity(Gravity.CENTER);

        editText.setTextSize(18);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            editText.setImportantForAutofill(View.IMPORTANT_FOR_AUTOFILL_YES);
        }


        dialog.setView(editText);

        int maxLength = 4;
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLength);
        editText.setFilters(fArray);

        editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                String pass = editText.getText().toString();
                if (pass.length() == 4) {
                    SendBt("Password," + editText.getText().toString());
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                    //  alertDialog.dismiss();

                }


            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //s is the current character in the eddittext after it is changed
            }
        });


        alertDialog = dialog.show();
        alertDialog.setCanceledOnTouchOutside(true);

        Window window = alertDialog.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        editText.requestFocus();


    }


    //..................................................................................

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (G.connected == true) {
            // go_list.setVisibility(View.VISIBLE);

        }
        if (G.connected == false) {
            go_list.setVisibility(View.GONE);

        }

        if (requestCode == 0) {
            //finish();
        }
        switch (requestCode) {

            case REQUEST_CONNECT_DEVICE:
                if (resultCode == Activity.RESULT_OK) {
                    String address = data.getExtras().getString(ActivityDeviceList1.EXTRA_DEVICE_ADDRESS);
                    //   bluetoothPairing(address);
                    BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
                    mBluetoothSPPConnection.open(device);

                    break;
                }


                if (resultCode == G.ResultCodeDefaultNameDevice) {
                    String address = data.getExtras().getString(ActivityDeviceList1.EXTRA_DEVICE_ADDRESS);
                    //   bluetoothPairing(address);
                    BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
                    mBluetoothSPPConnection.open(device);

                    break;
                }
                //String address = data.getExtras().getString("Subject");

                if (resultCode == Activity.RESULT_CANCELED) {
                    setdisBlIco();
                    Toast.makeText(ActivityMain.this, "دستگاهی یافت نشد", Toast.LENGTH_SHORT).show();
                    setdisBlIco();

                    break;
                }
            case REQUEST_ENABLE_BT:
                if (resultCode == Activity.RESULT_OK) {
                    button = false;
                }
                break;
        }
    }


    @Override
    public void bluetoothWrite(int bytes, byte[] buffer) {
        TextView connectionView = (TextView) findViewById(R.id.textViewPass);

        dataBuffer = new byte[bytes];
        dataBuffer1 = new byte[bytes];
        String resevStr = null;

        int i;


        for (i = 0; i < bytes; i++) {
            dataBuffer[i] = buffer[i];

        }

        try {
            resevStr = new String(dataBuffer, "US-ASCII");
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }

        // connectionView.setText(resevStr);
        String name = mBluetoothSPPConnection.getDeviceName();

        String[] multipleStrings = {};
        // String[] multipleStringsMgz8={};

//          if (name.equals(getString(R.string.device_3))) {
//                multipleStringsMgz8 = resevStr.split(",");
//
//          }else {
        multipleStrings = resevStr.split(",");

        //  }


        String commandCod = "";
        try {
            commandCod = multipleStrings[0];
            for (String s : multipleStrings) {
                Log.e("RmmLog", s + "");

            }
        } catch (Exception e) {

        }


        if (commandCod.equals("OkPassword")) {
            setEnBlIco();
            connectionView.setText("OK");
            button = true;
            name = mBluetoothSPPConnection.getDeviceName();
            alertDialog.dismiss();
            if (name.equals(getString(R.string.device_1))) {
                alertDialog.dismiss();

                removeValu();
                Intent intent = new Intent(ActivityMain.this, ActivityListG4.class);
                startActivity(intent);

            }

            if (name.equals(getString(R.string.device_2))) {
                alertDialog.dismiss();
                removeValu();
                Intent intent = new Intent(ActivityMain.this, Activity_List_MG4.class);
                startActivity(intent);
            }
            if (name.equals(getString(R.string.device_3))) {
                alertDialog.dismiss();
                removeValu();
                Intent intent = new Intent(ActivityMain.this, Activity_List_MGZ8.class);
                startActivity(intent);
            }
            if (name.equals(getString(R.string.default_name))) {

                SendBt("Model?");
//                alertDialog.dismiss();
//                removeValu();
//                Intent intent = new Intent(ActivityMain.this, Activity_List_MGZ8.class);
//                startActivity(intent);
            }
            // ActivityMain.this.finish();
        }


        if (commandCod.equals("PasswordSave")) {

            Intent intent = new Intent(this, Dialog_save_Pass.class);
            intent.putExtra("code", "1");
            startActivity(intent);
        }

        try {
            if (commandCod.equals("PasswordErorr")) {
                alertDialog.dismiss();
                setdisBlIco();
                Toast.makeText(G.context, "رمز اشتباه است", Toast.LENGTH_SHORT).show();
                PasswordAlertDialog(mBluetoothSPPConnection.getDeviceName());
                count++;
                if (count == 3) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                            ActivityCompat.checkSelfPermission(getApplicationContext(),
                                    Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {

                        requestPermissions(new String[]{Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT},
                                49);


                        return;
                    }

                    Toast.makeText(G.context, "شما بیش از حد مجاز اشتباه کد وارد کردید!!", Toast.LENGTH_SHORT).show();

                    finish();
                }


            } else if (commandCod.equals("Model")) {

                G.versionNameMainHardWareDevice = multipleStrings[2];
                G.versionNameSubHardWareDevice = multipleStrings[3];
                G.versionNameMainSoftWareDevice = multipleStrings[4];
                G.versionNameSubSoftWareDevice = multipleStrings[5];

                if (multipleStrings[1].equals(getString(R.string.device_g4))) {
                    alertDialog.dismiss();

                    removeValu();
                    Intent intent = new Intent(ActivityMain.this, ActivityListG4.class);
                    startActivity(intent);

                }

                if (multipleStrings[1].equals(getString(R.string.device_mg4))) {
                    alertDialog.dismiss();
                    removeValu();
                    Intent intent = new Intent(ActivityMain.this, Activity_List_MG4.class);
                    startActivity(intent);
                }
                if (multipleStrings[1].equals(getString(R.string.device_mgz8))) {
                    alertDialog.dismiss();
                    removeValu();
                    Intent intent = new Intent(ActivityMain.this, Activity_List_MGZ8.class);
                    startActivity(intent);
                }
                if (multipleStrings[1].equals(getString(R.string.default_name))) {


                    alertDialog.dismiss();
                    removeValu();
                    Intent intent = new Intent(ActivityMain.this, Activity_List_MGZ8.class);
                    startActivity(intent);
                }


            } else if (multipleStrings[0] != null &&

                    multipleStrings[0].equals("ErorrPassword")) {
                Intent intent = new Intent(this, Dialog_save_Pass.class);
                intent.putExtra("code", "0");
                startActivity(intent);

            } else if (multipleStrings[0] != null && multipleStrings[0].equals("CSQ")) {
                try {
                    numAn = multipleStrings[1];
                    nameOperator = multipleStrings[2];
                } catch (Exception e) {

                }


            } else if (multipleStrings[0] != null && multipleStrings[0].equals("MainBord")) {
                //  About_System.bord.setText(multipleStrings[1]);
                try {
                    bord = multipleStrings[1];
                } catch (Exception e) {

                }

            } else if (multipleStrings[0] != null && multipleStrings[0].equals("AutoDialer")) {
                //  About_System.dialer.setText(multipleStrings[1]);
                //About_System.Iemi.setText(multipleStrings[2]);
                try {
                    dialer = multipleStrings[1];
                    Iemi = multipleStrings[2];
                    SendBt("MainBord?");

                } catch (Exception e) {

                }


            } else if (multipleStrings[0] != null && multipleStrings[0].equals("CloseApp")) {
                flaglostBl = true;

                mBluetoothSPPConnection.close();

                Intent intent = new Intent(getApplicationContext(), Dialog_Close_app.class);


                intent.putExtra("close", true);
                startActivity(intent);


            } else if (commandCod.equals("MamorySms")) {
                try {


                    NumberSmsMemory[1] = multipleStrings[1];
                    ControlSmsMemory[1] = multipleStrings[2];
                    TkzngSmsMemory[1] = multipleStrings[3];
                    ReportSmsMemory[1] = multipleStrings[4];


                    NumberSmsMemory[2] = multipleStrings[5];
                    ControlSmsMemory[2] = multipleStrings[6];
                    TkzngSmsMemory[2] = multipleStrings[7];
                    ReportSmsMemory[2] = multipleStrings[8];


                    NumberSmsMemory[3] = multipleStrings[9];
                    ControlSmsMemory[3] = multipleStrings[10];
                    TkzngSmsMemory[3] = multipleStrings[11];
                    ReportSmsMemory[3] = multipleStrings[12];


                    NumberSmsMemory[4] = multipleStrings[13];
                    ControlSmsMemory[4] = multipleStrings[14];
                    TkzngSmsMemory[4] = multipleStrings[15];
                    ReportSmsMemory[4] = multipleStrings[16];


                    NumberSmsMemory[5] = multipleStrings[17];
                    ControlSmsMemory[5] = multipleStrings[18];
                    TkzngSmsMemory[5] = multipleStrings[19];
                    ReportSmsMemory[5] = multipleStrings[20];


                    NumberSmsMemory[6] = multipleStrings[21];
                    ControlSmsMemory[6] = multipleStrings[22];
                    TkzngSmsMemory[6] = multipleStrings[23];
                    ReportSmsMemory[6] = multipleStrings[24];

                    NumberSmsMemory[7] = multipleStrings[25];
                    ControlSmsMemory[7] = multipleStrings[26];
                    TkzngSmsMemory[7] = multipleStrings[27];
                    ReportSmsMemory[7] = multipleStrings[28];

                    NumberSmsMemory[8] = multipleStrings[29];
                    ControlSmsMemory[8] = multipleStrings[30];
                    TkzngSmsMemory[8] = multipleStrings[31];
                    ReportSmsMemory[8] = multipleStrings[32];

                    NumberSmsMemory[9] = multipleStrings[33];
                    ControlSmsMemory[9] = multipleStrings[34];
                    TkzngSmsMemory[9] = multipleStrings[35];
                    ReportSmsMemory[9] = multipleStrings[36];

                    NumberSmsMemory[10] = multipleStrings[37];
                    ControlSmsMemory[10] = multipleStrings[38];
                    ControlSmsMemory[10] = multipleStrings[38];
                    TkzngSmsMemory[10] = multipleStrings[39];
                    ReportSmsMemory[10] = multipleStrings[40];
                } catch (Exception e) {

                }
            } else if (commandCod.equals("About")) {

                try {

                    List<String> aboutString = new LinkedList<>(Arrays.asList(multipleStrings));
                    aboutString.remove(0);

                    for (String s : aboutString) {
                        About_System.txtAbout.setText(About_System.txtAbout.getText().toString() + "\n" +
                                s);
                    }


                } catch (Exception e) {

                }
            } else if (commandCod.equals("MAMORY")) {
                phoneNumberList.clear();
                try {
                    typeTriger = multipleStrings[1];
                    cityCode = multipleStrings[2];
                    for (int e = 3; e < multipleStrings.length; e++) {
                        smart.SmartSetup.MGZ8.models.phoneNumber phoneNumber = new phoneNumber();
                        String[] f = multipleStrings[e].split("_");
                        phoneNumber.setNumMemory(f[0]);
                        phoneNumber.setNumber(f[1]);
                        String v = f[2];
                        for (int t = 0; t < v.length(); t++) {
                            String c = Character.toString(v.charAt(t));
                            if (!G.versionNameMainSoftWareDevice.equals("") &&
                                    Integer.parseInt(G.versionNameMainSoftWareDevice) > 1) {
                                switch (t) {
                                    case 0:
                                        phoneNumber.setVoiceCallP1(c);
                                        break;
                                    case 1:
                                        phoneNumber.setVoiceCallP2(c);

                                        break;
                                    case 2:
                                        phoneNumber.setSmsControlP1(c);

                                        break;
                                    case 3:
                                        phoneNumber.setSmsControlP2(c);

                                        break;
                                    case 4:
                                        phoneNumber.setSmsControlExit(c);

                                        break;
                                    case 5:
                                        phoneNumber.setEnDisP1(c);

                                        break;
                                    case 6:
                                        phoneNumber.setEnDisP2(c);

                                        break;
                                    case 7:
                                        phoneNumber.setAlarmP1(c);

                                        break;
                                    case 8:
                                        phoneNumber.setAlarmP2(c);

                                        break;
                                    case 9:
                                        phoneNumber.setCommonArea(c);

                                        break;
                                    case 10:
                                        phoneNumber.setTwoArea(c);

                                        break;
                                    case 11:
                                        phoneNumber.setElectCity(c);

                                        break;
                                    case 12:
                                        phoneNumber.setAux(c);

                                        break;
                                    case 13:
                                        phoneNumber.setCutVoice(c);

                                        break;
                                    case 14:
                                        phoneNumber.setCutPhone(c);

                                        break;
                                    case 15:
                                        phoneNumber.setMisCallControl(c);

                                        break;

                                    default:
                                        break;
                                }
                            } else {
                                switch (t) {
                                    case 0:
                                        phoneNumber.setVoiceCallP1(c);
                                        break;
                                    case 1:
                                        phoneNumber.setVoiceCallP2(c);

                                        break;
                                    case 2:
                                        phoneNumber.setSmsControlP1(c);

                                        break;
                                    case 3:
                                        phoneNumber.setSmsControlP2(c);

                                        break;
                                    case 4:
                                        phoneNumber.setSmsControlExit(c);

                                        break;
                                    case 5:
                                        phoneNumber.setEnDisP1(c);

                                        break;
                                    case 6:
                                        phoneNumber.setEnDisP2(c);

                                        break;
                                    case 7:
                                        phoneNumber.setAlarmP1(c);

                                        break;
                                    case 8:
                                        phoneNumber.setAlarmP2(c);

                                        break;
                                    case 9:
                                        phoneNumber.setCommonArea(c);

                                        break;
                                    case 10:
                                        phoneNumber.setTwoArea(c);

                                        break;
                                    case 11:
                                        phoneNumber.setSystemReports(c);

                                        break;
                                    case 12:
                                        phoneNumber.setMisCallControl(c);

                                        break;

                                    default:
                                        break;
                                }
                            }

                        }

                        phoneNumberList.add(phoneNumber);
                        try {
                            new ActivitySmsNumberMGZ8().recyclerView.getAdapter().notifyDataSetChanged();

                        } catch (Exception e2) {

                        }


                    }

                } catch (Exception e) {

                }
            } else if (multipleStrings[0] != null && multipleStrings[0].equals("LCD")) {

                try {


                    if (multipleStrings[1].equals(SEND_SMS)) {
                        LCD_DIALOG = " ارسال پیامک به " + LCD_DIALOG + multipleStrings[2];
                    }
                    if (multipleStrings[1].equals(SEND_OK)) {
                        LCD_DIALOG = LCD_DIALOG + "\nارسال شد\n";
                    }
                    if (multipleStrings[1].equals(SEND_ERROR)) {
                        LCD_DIALOG = LCD_DIALOG + "خطا\n";
                    }

                    if (multipleStrings[1].equals(SAVE)) {
                        LCD_DIALOG = LCD_DIALOG + "ذخیره شد\n";
                    }
                    if (multipleStrings[1].equals("0")) {
                        LCD_DIALOG = "";
                    }
                    if (multipleStrings[1].equals(CALLING)) {
                        LCD_DIALOG = LCD_DIALOG + "دستگاه در حال شماره گیری " + multipleStrings[2] + "با خط ثابت \n";

                    }
                    if (multipleStrings[1].equals(AZHIR_CALL)) {
                        LCD_DIALOG = LCD_DIALOG + "پخش آژیر\n";
                    }

                    if (multipleStrings[1].equals(MASSAGE_SEND)) {
                        LCD_DIALOG = LCD_DIALOG + "پخش پیام\n";

                    }
                    if (multipleStrings[1].equals(CALLING_SIM)) {
                        LCD_DIALOG = LCD_DIALOG + "دستگاه درحال شماره گیری " + multipleStrings[2] + " با سیم کارت\n";

                    }
                    if (multipleStrings[1].equals(SAVE_PASS)) {
                        LCD_DIALOG = LCD_DIALOG + " تغییر رمز انجام شد\n";
                    }


                    //  flagGO = multipleStrings[3];
                    if (multipleStrings[3].equals(OPEN_DIALOG)) {
                        if (flagGO.equals(OPEN_DIALOG)) {

                        }

                        if (flagGO.equals(CLOSE_DIALOG)) {
                            //Toast.makeText(this, multipleStrings[3]+"", Toast.LENGTH_SHORT).show();
                            flagGO = OPEN_DIALOG;
                            startActivity(new Intent(getApplicationContext(), Progress_dialog_wait.class));
                        }

                    } else {
                        flagGO = CLOSE_DIALOG;

                    }
                } catch (Exception e) {

                }
            } else if (commandCod.equals("MamoryPho")) {

                try {


                    NumberPhoneMemory[1] = multipleStrings[1];
                    NumberPhoneMemory[2] = multipleStrings[2];
                    NumberPhoneMemory[3] = multipleStrings[3];
                    NumberPhoneMemory[4] = multipleStrings[4];
                    NumberPhoneMemory[5] = multipleStrings[5];
                    NumberPhoneMemory[6] = multipleStrings[6];
                    NumberPhoneMemory[7] = multipleStrings[7];
                    NumberPhoneMemory[8] = multipleStrings[8];
                    NumberPhoneMemory[9] = multipleStrings[9];
                    NumberPhoneMemory[10] = multipleStrings[10];
                    if (multipleStrings.length > 11) {
                        NumberPhoneMemory[11] = multipleStrings[11];

                        NumberPhoneMemory[12] = multipleStrings[12];
                    }

                } catch (Exception e) {

                }


            } else if (commandCod.equals("ZONS")) {
                try {
                    if (zonList.size() != 0) {
                        if (multipleStrings.length > 0) {
                            String statusString = multipleStrings[1];
                            for (int g = 0; g < zonList.size(); g++) {
                                char a = statusString.charAt(g);
                                zonList.get(g).setStatus(Character.toString(a));
                            }
                            activityZonNameMGZ8.recycleView.getAdapter().notifyDataSetChanged();

                        }

                    }
                } catch (Exception e) {

                }


            } else if (commandCod.equals("ZONNAME")) {

                textZonMGZ8 = resevStr;
                String[] zonListt = ActivityMain.textZonMGZ8.split(",");
                // List<String> zonListString = Arrays.asList(zonListt);
                List<String> zonListString = new LinkedList<>(Arrays.asList(zonListt));


                zonListString.remove(0);
                numAllPartZon = Integer.parseInt(zonListString.get(0));
                zonListString.remove(0);

                numNowPartZon = Integer.parseInt(zonListString.get(0));
                zonListString.remove(0);
                if (numNowPartZon == 1) {
                    zonList.clear();

                }


                for (String zon : zonListString) {
                    String[] zonDetail = zon.split("_");
                    Zon zon1 = new Zon();
                    zon1.setNumber(zonDetail[0]);
                    zon1.setName(zonDetail[1]);


                    zon1.setPartition(Character.toString(zonDetail[2].toCharArray()[0]));
                    zon1.setMode(Character.toString(zonDetail[2].toCharArray()[1]));
                    zon1.setDingDang(Character.toString(zonDetail[2].toCharArray()[2]));
                    zon1.setStatus(Character.toString(zonDetail[2].toCharArray()[3]));
                    zon1.setIsDelete(Character.toString(zonDetail[2].toCharArray()[4]));


                    zonList.add(zon1);


                }
                if (numAllPartZon == numNowPartZon) {
                    activityZonNameMGZ8.startShowListZon(getApplicationContext());
                    // activityZonNameMGZ8.startHandler();
                }

            } else if (commandCod.equals("ZonName")) {
                String text;
                text = StringToChar(multipleStrings[1]);
                // ActivityZonNameG4.txtZon1.setText(text);
                ZonName[0] = text;

                text = StringToChar(multipleStrings[2]);
                ZonName[1] = text;


                text = StringToChar(multipleStrings[3]);
                ZonName[2] = text;


                text = StringToChar(multipleStrings[4]);
                ZonName[3] = text;

            } else if (commandCod.equals("OUTNAME")) {
                outNameList.clear();
                for (int a = 1; a < multipleStrings.length; a++) {
                    OutName outName = new OutName();
                    outName.setName(multipleStrings[a]);
                    outNameList.add(outName);

                }
                try {
                    ActivityOutNameMGZ8.recycleView.getAdapter().notifyDataSetChanged();
                } catch (Exception e) {

                }

            } else if (commandCod.equals("OutName")) {
                String text;
                text = StringToChar(multipleStrings[1]);
                OutName[0] = text;

                text = StringToChar(multipleStrings[2]);
                OutName[1] = text;

                text = StringToChar(multipleStrings[3]);
                OutName[2] = text;

                text = StringToChar(multipleStrings[4]);
                OutName[3] = text;

            } else if (commandCod.equals("TrigText")) {
                String text;
                text = StringToChar(multipleStrings[1]);
                TrigText[0] = text;
                //ActivityTrigText.txtTrig4off.setText(text);

                text = StringToChar(multipleStrings[2]);
                TrigText[1] = text;

                //ActivityTrigText.txtTrig1.setText(text);

                text = StringToChar(multipleStrings[3]);
                TrigText[2] = text;

                // ActivityTrigText.txtTrig2.setText(text);

                text = StringToChar(multipleStrings[4]);
                TrigText[3] = text;

                // ActivityTrigText.txtTrig3.setText(text);

                text = StringToChar(multipleStrings[5]);
                TrigText[4] = text;

                // ActivityTrigText.txtTrig4on.setText(text);
            } else if (commandCod.equals("Remot")) {
                int num = 0;
                String text;

                for (int j = 1; j <= 10; j++) {

                    if (multipleStrings[1].equals(j + "")) {
                        num = Integer.parseInt(multipleStrings[1]);
                        Remot[11] = num + "";
                        break;
                    } else {
                        num = 0;
                        Remot[11] = num + "";

                    }

                }


                switch (num) {

                    case 10:
                        // ActivityRemotNameG4.layRemot10.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[2]);
                        Remot[10] = text;
                        // ActivityRemotNameG4.txtRemot10.setText(text);
                    case 9:
                        // ActivityRemotNameG4.layRemot9.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[11]);
                        Remot[9] = text;

                        // ActivityRemotNameG4.txtRemot9.setText(text);
                    case 8:
                        //ActivityRemotNameG4.layRemot8.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[10]);
                        Remot[8] = text;

                        //   ActivityRemotNameG4.txtRemot8.setText(text);
                    case 7:
                        // ActivityRemotNameG4.layRemot7.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[9]);
                        Remot[7] = text;

                        //    ActivityRemotNameG4.txtRemot7.setText(text);
                    case 6:
                        //  ActivityRemotNameG4.layRemot6.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[8]);
                        Remot[6] = text;

                        //    ActivityRemotNameG4.txtRemot6.setText(text);
                    case 5:
                        // ActivityRemotNameG4.layRemot5.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[7]);
                        Remot[5] = text;

                        //    ActivityRemotNameG4.txtRemot5.setText(text);
                    case 4:
                        //    ActivityRemotNameG4.layRemot4.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[6]);
                        Remot[4] = text;

                        //   ActivityRemotNameG4.txtRemot4.setText(text);
                    case 3:
                        // ActivityRemotNameG4.layRemot3.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[5]);
                        Remot[3] = text;

                        //    ActivityRemotNameG4.txtRemot3.setText(text);
                    case 2:
                        // ActivityRemotNameG4.layRemot2.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[4]);
                        Remot[2] = text;

                        //  ActivityRemotNameG4.txtRemot2.setText(text);
                    case 1:
                        // ActivityRemotNameG4.layRemot1.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[3]);
                        Remot[1] = text;

                        //  ActivityRemotNameG4.txtRemot1.setText(text);


                }


            } else if (commandCod.equals("REMOT")) {
                // Log.e("Remot",a+"");
                ActivityMain.remoteList.clear();

                Remote remote = null;
                for (int j = 1; j < multipleStrings.length; j++) {
                    if (j % 2 == 0) { // Even
                        remote.setPartitionName(Integer.parseInt(multipleStrings[j]));
                    } else { // Odd
                        remote = new Remote();
                        remote.setName(multipleStrings[j]);
                        Log.e("Remot", remote.getName() + " ddd");

                        remoteList.add(remote);
                    }

                }
                Log.e("Remot", remoteList.size() + "");

                try {
                    ActivityRemoteNameMGZ8.startShowListRemote(getApplicationContext());

                } catch (Exception e) {

                }


            } else if (commandCod.equals("Wireles")) {
                String text;
                int num = 0;

                for (int j = 1; j <= 8; j++) {

                    if (multipleStrings[1].equals(j + "")) {
                        num = Integer.parseInt(multipleStrings[1]);
                        Wireles[9] = num + "";
                        break;
                    } else {
                        num = 0;
                        Wireles[9] = num + "";

                    }

                }


                switch (num) {
                    case 8:
                        // ActivityWlNameG4.layWlName8.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[9]);
                        Wireles[8] = text;
                        //ActivityWlNameG4.txtWlName8.setText(text);
                    case 7:
                        //   ActivityWlNameG4.layWlName7.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[8]);
                        Wireles[7] = text;
                        // ActivityWlNameG4.txtWlName7.setText(text);
                    case 6:
                        // ActivityWlNameG4.layWlName6.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[7]);
                        Wireles[6] = text;
                        //  ActivityWlNameG4.txtWlName6.setText(text);
                    case 5:
                        // ActivityWlNameG4.layWlName5.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[6]);
                        Wireles[5] = text;


                        // ActivityWlNameG4.txtWlName5.setText(text);
                    case 4:
                        //  ActivityWlNameG4.layWlName4.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[5]);
                        Wireles[4] = text;

                        // ActivityWlNameG4.txtWlName4.setText(text);
                    case 3:
                        //  ActivityWlNameG4.layWlName3.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[4]);
                        Wireles[3] = text;

                        // ActivityWlNameG4.txtWlName3.setText(text);
                    case 2:
                        //    ActivityWlNameG4.layWlName2.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[3]);
                        Wireles[2] = text;

                        //  ActivityWlNameG4.txtWlName2.setText(text);
                    case 1:
                        //  ActivityWlNameG4.layWlName1.setVisibility(View.VISIBLE);
                        text = StringToChar(multipleStrings[2]);
                        Wireles[1] = text;

                        //   ActivityWlNameG4.txtWlName1.setText(text);

                }
            } else if (commandCod.equals("Charge")) {
                //  String text;

                CodeChekCharge = multipleStrings[1];

                CodeCharge = multipleStrings[2];
                falgProgress = "1";


            } else if (commandCod.equals("CUSDF")) {
                String text;
                text = StringToChar(multipleStrings[1]);
                Cusd = text;
                falgProgress = "1";


            } else if (commandCod.equals("CUSDE")) {

                String text;
                text = (multipleStrings[1]);
                //ActivityChargeG4.txtCusd.setText(text);
                Cusd = text;
                falgProgress = "1";


            } else if (commandCod.equals("Setting")) {
                SeekBarStart.setProgress(Integer.parseInt((multipleStrings[1])));
                SeekBarExit.setProgress(Integer.parseInt((multipleStrings[2])));
                SeekBarAlarm.setProgress(Integer.parseInt((multipleStrings[3])));
                SeekBarTak.setProgress(Integer.parseInt((multipleStrings[4])));
                numDelayStart.setText(multipleStrings[1] + " ثانیه ");
                numDelayExit.setText(multipleStrings[2] + " ثانیه ");
                numDelayAlarm.setText(multipleStrings[3] + "دقیقه");

                numTakBib.setText(multipleStrings[4] + " % ");

                Panel[0] = multipleStrings[1];
                Panel[1] = multipleStrings[2];
                Panel[2] = multipleStrings[3];
                Panel[3] = multipleStrings[4];


            }

            ///...................................
            else if (commandCod.equals("Panel")) {

                if (multipleStrings[1].equals("PANEL")) {

                    String text;
                    text = multipleStrings[7];
                    if (text.equals("A")) {
                        text = "10";
                    }
                    Panel[0] = text + "دقیقه";

                    // ActivityPanelG4.txtTaimAlarm.setText(text + "دقیقه");

                    text = multipleStrings[10];
                    if (text.equals("1")) {
                        Panel[1] = "فعال";
                        // ActivityPanelG4.txtPower.setText("فعال");
                    } else {
                        Panel[1] = "غیر فعال";

                        // ActivityPanelG4.txtPower.setText("غیر فعال");
                    }

                    text = multipleStrings[8];
                    if (text.equals("1")) {
                        Panel[2] = "فعال";

                        // ActivityPanelG4.txtZon24h.setText("فعال");
                    } else if (text.equals("2")) {
                        Panel[2] = "فعال دو مرحله ای";

                        // ActivityPanelG4.txtZon24h.setText("غیر فعال");
                    } else {
                        Panel[2] = "غیر فعال";

                        // ActivityPanelG4.txtZon24h.setText("غیر فعال");
                    }

                    text = multipleStrings[9];
                    if (text.equals("1")) {
                        Panel[3] = "فعال";

                        // ActivityPanelG4.txtChrip.setText("فعال");
                    } else {
                        Panel[3] = "غیر فعال";

                        // ActivityPanelG4.txtChrip.setText("غیر فعال");
                    }

                }
            }
            //
        } catch (Exception e) {

        }

    }


    public void clearAllData() {
        G.versionNameMainSoftWareDevice = "1";
        G.versionNameSubSoftWareDevice = "1";
        G.versionNameMainHardWareDevice = "1";
        G.versionNameSubHardWareDevice = "1";
        G.connected = false;
        G.btAdres = "";
        CodeChekCharge = "";
        CodeCharge = "";
        Cusd = "";
        textZonMGZ8 = "";
        bord = "";
        dialer = "";
        Iemi = "";
        typeTriger = "";
        cityCode = "";
        zonList = new ArrayList<>();


        phoneNumberList = new ArrayList<>();

        NumberSmsMemory = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
        ReportSmsMemory = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
        TkzngSmsMemory = new String[]{" ", " ", "", "", " ", " ", " ", " ", " ", " ", " "};
        ControlSmsMemory = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
        Remot = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
        remoteList = new ArrayList<>();
        outNameList = new ArrayList<>();


        Wireles = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};

        OutName = new String[]{" ", " ", " ", " "};
        ZonName = new String[]{" ", " ", " ", " "};
        Panel = new String[]{" ", " ", " ", " "};
        TrigText = new String[]{" ", " ", " ", " ", " "};
        LCD = "SMART";
        LCD_DIALOG = "";
        nameOperator = "";
        numAn = "";
        ImageView helpbtn;
        NumberPhoneMemory = new String[]{"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty",
                "Empty", "Empty", "Empty", "Empty", "Empty"};
    }


    ///..............................................................................

    ////...........................................................................در حال اتصال
    @Override
    public void onConnecting() {
        // This function is called on the moment the phone starts making a
        // connecting with the bluetooth module.
        // The function is executed in the main thread.

        // Change the text in the connectionInfo TextView
        TextView connectionView = (TextView) findViewById(R.id.textViewPass);
        connectionView.setText("درحال اتصال...");

    }


    ////..........................................................................اتصال برقرار شود
    @Override
    public void onConnected() {
        // This function is called on the moment a connection is realized
        // between the phone and the bluetooth module.
        // The function is executed in the main thread.
        //.............................
        clearAllData();

        SharedPreferences shared = getSharedPreferences("Prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("strBtAdres", G.btAdres);
        editor.apply();
        //...............................
        G.connected = true;
        if (G.connected == true) {
            // go_list.setVisibility(View.VISIBLE);

        }
        // Change the text in the connectionInfo TextView
        TextView connectionView = (TextView) findViewById(R.id.textViewPass);
        connectionView.setText("اتصال به... " + mBluetoothSPPConnection.getDeviceName());

        // Change the text in the connect button.
        // bt = (Button) findViewById(R.id.connect);

        bt.setText("قطع اتصال");
        setdisBlIco();

        // Send the 's' character so that the communication can start.

        //   bt.setVisibility(View.GONE);
        PasswordAlertDialog(mBluetoothSPPConnection.getDeviceName());


    }


    ///.............................................................................اگر اتصال برقرار نشود
    @Override
    public void onConnectionFailed() {
        // This function is called when the intended connection could not be
        // realized.
        // The function is executed in the main thread.

        G.connected = false;
        if (G.connected == true) {
            //  go_list.setVisibility(View.VISIBLE);

        }
        setdisBlIco();
        flagGO = "0";
        // Change the text in the connectionInfo TextView
        TextView connectionView = (TextView) findViewById(R.id.textViewPass);
        connectionView.setText("خطای اتصال");

        // Change the text in the connect button.
        //  Button bt = (Button) findViewById(R.id.connect);
        bt.setText("اتصال");
        bt.setVisibility(View.VISIBLE);


    }


    ///.............................................................................اتصال قطع شود
    @Override
    public void onConnectionLost() {
        // This function is called when the intended connection could not be
        // realized.
        // The function is executed in the main thread.

        G.connected = false;
        if (G.connected == false) {
            go_list.setVisibility(View.GONE);

        }

        setdisBlIco();
        flagGO = "0";
        // Change the text in the connectionInfo TextView
        TextView connectionView = (TextView) findViewById(R.id.textViewPass);
        connectionView.setText("متصل نیست");

        // Change the text in the connect button.
        //Button bt = (Button) findViewById(R.id.connect);
        bt.setText("اتصال");
        if (!flaglostBl) {
            Intent intent = new Intent(getApplicationContext(), Dialog_Close_app.class);

            intent.putExtra("disconnect", true);
            startActivity(intent);
            flaglostBl = false;
        }


    }


    //..............................................................................
    //..............................................................................................
    private String StringToChar(String str) {
        int i = 0;
        String text = "";
        int unicodInt;
        char c;
        while (i < str.length()) {

            c = str.charAt(i++);
            c = hexToInt(c);
            unicodInt = (c * 0x1000);

            c = str.charAt(i++);
            c = hexToInt(c);
            unicodInt = unicodInt + (c * 0x100);

            c = str.charAt(i++);
            c = hexToInt(c);
            unicodInt = unicodInt + (c * 0x10);

            c = str.charAt(i++);
            c = hexToInt(c);
            unicodInt = unicodInt + c;

            c = (char) unicodInt;

            String str1 = String.valueOf(c);
            text = text + str1;
        }
        return text;
    }


    //...............................................................................................
    private char hexToInt(char c) {
        switch (c) {
            case '0':
                c = 0;
                break;
            case '1':
                c = 1;
                break;
            case '2':
                c = 2;
                break;
            case '3':
                c = 3;
                break;
            case '4':
                c = 4;
                break;
            case '5':
                c = 5;
                break;
            case '6':
                c = 6;
                break;
            case '7':
                c = 7;
                break;
            case '8':
                c = 8;
                break;
            case '9':
                c = 9;
                break;
            case 'A':
                c = 10;
                break;
            case 'B':
                c = 11;
                break;
            case 'C':
                c = 12;
                break;
            case 'D':
                c = 13;
                break;
            case 'E':
                c = 14;
                break;
            case 'F':
                c = 15;
                break;
            case 'a':
                c = 10;
                break;
            case 'b':
                c = 11;
                break;
            case 'c':
                c = 12;
                break;
            case 'd':
                c = 13;
                break;
            case 'e':
                c = 14;
                break;
            case 'f':
                c = 15;
        }
        return c;
    }


    ///......................................................


    @Override
    public void onBackPressed() {
        if (G.connected == false) {
            go_list.setVisibility(View.GONE);

        }
        if (G.connected == true) {
            // go_list.setVisibility(View.VISIBLE);

        }

        flaglostBl = true;
        if (alertDialog != null) {
            if (alertDialog.isShowing()) {
                setdisBlIco();
            }
        }


        if (mBluetoothAdapter != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                    ActivityCompat.checkSelfPermission(getApplicationContext(),
                            Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT},
                        49);


                return;
            }



            mBluetoothSPPConnection.close();
        }


        finish();

    }

    void unpairAllDevice() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Set<BluetoothDevice> lst = mBluetoothAdapter.getBondedDevices();
        for (BluetoothDevice bainddvice : lst) {
            if (
                    bainddvice.getName().equals(getString(R.string.device_1)) ||
                            bainddvice.getName().equals(getString(R.string.device_2)) ||
                            bainddvice.getName().equals(getString(R.string.device_3)) ||
                            bainddvice.getName().equals(getString(R.string.default_name))
            ) {
                unpairDevice(bainddvice);

            }


        }

        mBluetoothSPPConnection.close();
    }

    private void unpairDevice(BluetoothDevice device) {
        try {
            Method m = device.getClass()
                    .getMethod("removeBond", (Class[]) null);
            m.invoke(device, (Object[]) null);
        } catch (Exception e) {
            //    Log.e(TAG, e.getMessage());
        }
    }


    public void removeValu() {

        bord = "";
        dialer = "";
        Iemi = "";
        CodeChekCharge = "";
        CodeCharge = "";
        Cusd = "";

        for (int j = 0; j < NumberSmsMemory.length; j++) {
            NumberSmsMemory[j] = " ";
            ReportSmsMemory[j] = " ";
            TkzngSmsMemory[j] = " ";
            ControlSmsMemory[j] = " ";

        }

        for (int j = 0; j < Remot.length; j++) {
            Remot[j] = " ";
            Wireles[j] = " ";

        }
        for (int j = 0; j < OutName.length; j++) {
            OutName[j] = " ";
            ZonName[j] = " ";
            Panel[j] = " ";

        }
        for (int j = 0; j < TrigText.length; j++) {
            TrigText[j] = " ";
        }


        LCD = "SMART";
        LCD_DIALOG = "";
        nameOperator = "";
        numAn = "";
        for (int j = 0; j < NumberPhoneMemory.length; j++) {
            NumberPhoneMemory[j] = "Empty";
        }

    }


    public void setdviewHelp(view_descip view) {
        TapTargetView.showFor(this,                 // `this` is an Activity
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

                        .tintTarget(true)                   // Whether to tint the target view's color
                        .transparentTarget(true)           // Specify whether the target is transparent (displays the content underneath)
                        // Specify a custom drawable to draw as the target
                        .targetRadius(30)// Specify the target radius (in dp)
                , new TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
                    @Override
                    public void onTargetClick(TapTargetView view) {
                        super.onTargetClick(view);      // This call is optional


                    }


                });
    }

    public void setbib() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bib);
        //  float log1 =((float)1/CONSTANT.SYSTEM_MAX_VOLUME) ;
        //mediaPlayer.setVolume(50f,50f);
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0);
        mediaPlayer.start();


    }


}