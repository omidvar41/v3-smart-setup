package smart.SmartSetup.MGZ8.Edit;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.ramotion.fluidslider.FluidSlider;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.R;

public class ActivityEditpanelSettingMGZ8 extends EnhancedActivity {
    public  static ActivityEditpanelSettingMGZ8 activityEditpanelSettingMGZ8;
    String           ss, strSend;
    Button btnExit1;
    Button           btnSave1;
    ActivityMain main;
    String           item;
    String           status;
    private TextView txtSetted;
    SeekBar SeekBarTak;
    int seekBarProgress=1000;
    ImageButton iconSeekBar,btnMine,btnPlus;

    private Handler repeatUpdateHandler = new Handler();
    private boolean mAutoIncrement = false;
    private boolean mAutoDecrement = false;
    public int mValue;

    class RptUpdater implements Runnable {
        public void run() {
            if( mAutoIncrement ){
                increment();
                repeatUpdateHandler.postDelayed( new RptUpdater(), 50 );
            } else if( mAutoDecrement ){
                decrement();
                repeatUpdateHandler.postDelayed( new RptUpdater(), 50 );
            }
        }
    }
    public void increment(){
        SeekBarTak.setProgress(SeekBarTak.getProgress()+1);

    }


    public void decrement(){
        SeekBarTak.setProgress(SeekBarTak.getProgress()-1);

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.mgz8_activity_editpanel);
        activityEditpanelSettingMGZ8 =this;
        //  unicod1 = new byte[3];
        txtSetted = (TextView) findViewById(R.id.txtSetted);
        btnMine =  findViewById(R.id.btnMine);
        btnPlus =  findViewById(R.id.btnPlus);
        btnExit1 = (Button) findViewById(R.id.btnExit1);
        btnSave1 = (Button) findViewById(R.id.btnSave1);
        SeekBarTak =   findViewById(R.id.SeekBarTak);
        iconSeekBar =   findViewById(R.id.iconSeekBar);
          main=new ActivityMain();




        btnPlus.setOnLongClickListener(
                new View.OnLongClickListener(){
                    public boolean onLongClick(View arg0) {
                        mAutoIncrement = true;
                        repeatUpdateHandler.post( new RptUpdater() );
                        return false;
                    }
                }
        );

        btnPlus.setOnTouchListener( new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if( (event.getAction()==MotionEvent.ACTION_UP || event.getAction()==MotionEvent.ACTION_CANCEL)
                        && mAutoIncrement ){
                    mAutoIncrement = false;
                }
                return false;
            }
        });



        btnMine.setOnLongClickListener(
                new View.OnLongClickListener(){
                    public boolean onLongClick(View arg0) {
                        mAutoDecrement = true;
                        repeatUpdateHandler.post( new RptUpdater() );
                        return false;
                    }
                }
        );

        btnMine.setOnTouchListener( new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if( (event.getAction()==MotionEvent.ACTION_UP || event.getAction()==MotionEvent.ACTION_CANCEL)
                        && mAutoDecrement ){
                    mAutoDecrement = false;
                }
                return false;
            }
        });






        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("ITEM")) {
                item = extras.getString("ITEM");
                String progress = extras.getString("progress");


                if (item.equals("تک بوق:")){
                    iconSeekBar.setVisibility(View.VISIBLE);
                    SeekBarTak.setMax(100);
                    SeekBarTak.setProgress(Integer.parseInt(progress));

                    txtSetted.setText(item+"  "+progress+" % ");

                }else if (item.equals("تاخیر ورود:")){
                    iconSeekBar.setVisibility(View.GONE);
                    SeekBarTak.setMax(50);
                    SeekBarTak.setProgress(Integer.parseInt(progress)-10);

                    txtSetted.setText(item+"  "+progress+" ثانیه");


                }else if (item.equals("تاخیر خروج:")){
                    iconSeekBar.setVisibility(View.GONE);
                    SeekBarTak.setMax(100);

                    SeekBarTak.setProgress(Integer.parseInt(progress)-20);

                    txtSetted.setText(item+"  "+progress+"ثانیه");

                } else {
                    SeekBarTak.setProgress(Integer.parseInt(progress)-1);

                    iconSeekBar.setVisibility(View.GONE);
                    SeekBarTak.setMax(6);
                    txtSetted.setText(item+"  "+progress+" دقیقه");

                }
               // SeekBarTak.setProgress(Integer.parseInt(progress));
                if (progress.equals("0")){
                    iconSeekBar.setImageDrawable(getResources().getDrawable(R.drawable.muteblack));

                }else {
                    iconSeekBar.setImageDrawable(getResources().getDrawable(R.drawable.unmuteblack));

                }
            }
            if (extras.containsKey("STU")) {
                status = extras.getString("STU");
                txtSetted.setText(item + status);

                if (status.equals("فعال")) {
                   // mySwitch.setChecked(true);
                    ss = "1";
                } else {
                 //   mySwitch.setChecked(false);
                    ss = "0";
                }
            }
        }


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeekBarTak.setProgress(SeekBarTak.getProgress()+1);
            }
        });

        btnMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeekBarTak.setProgress(SeekBarTak.getProgress()-1);
            }
        });



        SeekBarTak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtSetted.setText(item+"  "+progress);


                        if (item.equals("تک بوق:")){

                            SeekBarTak.setMax(100);
                            txtSetted.setText(item+"  "+progress+" % ");

                        }else if (item.equals("تاخیر ورود:")){

                            SeekBarTak.setMax(50);
                            txtSetted.setText(item+"  "+(progress+10)+" ثانیه");


                        }else if (item.equals("تاخیر خروج:")){
                            iconSeekBar.setVisibility(View.GONE);
                            SeekBarTak.setMax(100);
                            txtSetted.setText(item+"  "+(progress+20)+"ثانیه");

                        } else {
                            iconSeekBar.setVisibility(View.GONE);
                            SeekBarTak.setMax(6);
                            txtSetted.setText(item+"  "+(progress+1)+" دقیقه");

                        }

                    }
                });

                if (progress == 0){
                    iconSeekBar.setImageDrawable(getResources().getDrawable(R.drawable.muteblack));
                }else {
                    iconSeekBar.setImageDrawable(getResources().getDrawable(R.drawable.unmuteblack));

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        //.................................................................

//        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView,
//                                         boolean isChecked) {
//
//                if (isChecked) {
//                    txtSetted.setText(item + "فعال");
//                    ss = "1";
//                } else {
//                    txtSetted.setText(item + "غیرفعال");
//                    ss = "0";
//                }
//
//            }
//        });

        //................................................................
        btnExit1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                G.currentActivity.finish();
            }
        });


        iconSeekBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SeekBarTak.getProgress() != 0) {

                    main.SendBt("ChripTest," + SeekBarTak.getProgress());
                }
            }
        });

        btnSave1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (  seekBarProgress != 1000) {
                    if (item.equals("تاخیر ورود:")) {
                        item = "EnterDelay," + (SeekBarTak.getProgress() + 10);
                    } else if (item.equals("تاخیر خروج:")) {
                        item = "ExitDelay," + (SeekBarTak.getProgress() + 20);
                    } else if (item.equals("تک بوق:")) {
                        item = "ChripVolum," + SeekBarTak.getProgress();
                    } else {
                        item = "TimeAlarm," + (SeekBarTak.getProgress() + 1);

                    }
                    main.SendBt(item);

                }
//                else {
//                    item = "FF";
//                }
//
//                if (item != "FF") {
//                    send_bt(ss);
//                }
                G.currentActivity.finish();
            }
        });

    }


}
