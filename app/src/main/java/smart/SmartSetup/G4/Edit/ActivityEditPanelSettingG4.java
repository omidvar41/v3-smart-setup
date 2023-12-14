package smart.SmartSetup.G4.Edit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.R;

/**
 * Created by Roholah on 30/06/2017.
 */

public class ActivityEditPanelSettingG4 extends EnhancedActivity {
    public static ActivityEditPanelSettingG4 activityEditPanelSettingG4;
    String           ss, strSend;
    Button btnExit1;
    Button           btnSave1;
    private Switch mySwitch;
    String           item;
    String           status;
    private TextView txtSetted;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g4_activity_edit_panel_setting);
        activityEditPanelSettingG4=this;
        //  unicod1 = new byte[3];
        txtSetted = (TextView) findViewById(R.id.txtSetted);
        btnExit1 = (Button) findViewById(R.id.btnExit1);
        btnSave1 = (Button) findViewById(R.id.btnSave1);

        mySwitch = (Switch) findViewById(R.id.switch1);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("ITEM")) {
                item = extras.getString("ITEM");

            }
            if (extras.containsKey("STU")) {
                status = extras.getString("STU");
                txtSetted.setText(item + status);

                if (status.equals("فعال")) {
                    mySwitch.setChecked(true);
                    ss = "1";
                } else {
                    mySwitch.setChecked(false);
                    ss = "0";
                }
            }
        }
        //.................................................................

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    txtSetted.setText(item + "فعال");
                    ss = "1";
                } else {
                    txtSetted.setText(item + "غیرفعال");
                    ss = "0";
                }

            }
        });

        //................................................................
        btnExit1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                G.currentActivity.finish();
            }
        });

        btnSave1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (item.equals("هشدار قطع برق:")) {
                    item = "PowerAlarm,";
                }
                else if (item.equals("زون 24 ساعته:")) {
                    item = "Z24h,";
                }
                else if (item.equals("تک بوق:")) {
                    item = "Chirp,";
                }

                else {
                    item = "FF";
                }

                if (item != "FF") {
                    send_bt(ss);
                }
                G.currentActivity.finish();
            }
        });

    }
    private void send_bt(String str) {

        strSend = "forPANEL," + item + str;
        ActivityMain main=new ActivityMain();
        main.SendBt(strSend);

    }

}
