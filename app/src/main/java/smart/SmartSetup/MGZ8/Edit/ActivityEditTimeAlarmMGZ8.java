package smart.SmartSetup.MGZ8.Edit;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.R;

public class ActivityEditTimeAlarmMGZ8 extends EnhancedActivity {
    public static ActivityEditTimeAlarmMGZ8 activityEditTimeAlarmMGZ8;
    String   ss, strSend;
    Button btnExit1;
    Button   btnSave1;
    Spinner spiTimeAlarm;
    String[] str = { "2 دقیقه", "3 دقیقه", "4 دقیقه", "5 دقیقه", "6 دقیقه", "7 دقیقه", "8 دقیقه", "9 دقیقه", "10 دقیقه" };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mgz8_activity_edit_time_alarm);
activityEditTimeAlarmMGZ8 =this;
        btnExit1 = (Button) findViewById(R.id.btnExit1);
        btnSave1 = (Button) findViewById(R.id.btnSave1);

        spiTimeAlarm = (Spinner) findViewById(R.id.spiTimeAlarm);
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, R.layout.spiner_item, str)
        {



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
        spiTimeAlarm.setAdapter(adap);
        //.................................................................
        spiTimeAlarm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                ss = arg0.getItemAtPosition(arg2).toString();

            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

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
                if (ss == "2 دقیقه") {
                    ss = "2";
                }
                else if (ss == "3 دقیقه") {
                    ss = "3";
                }
                else if (ss == "4 دقیقه") {
                    ss = "4";
                }
                else if (ss == "5 دقیقه") {
                    ss = "5";
                }
                else if (ss == "6 دقیقه") {
                    ss = "6";
                }
                else if (ss == "7 دقیقه") {
                    ss = "7";
                }
                else if (ss == "8 دقیقه") {
                    ss = "8";
                }
                else if (ss == "9 دقیقه") {
                    ss = "9";
                }
                else if (ss == "10 دقیقه") {
                    ss = "A";
                }
                else {
                    ss = "FF";
                }

                if (ss != "FF") {
                    send_bt(ss);
                }
                G.currentActivity.finish();
            }
        });


    }
    private void send_bt(String str) {

        strSend = "forPANEL," + "TimeAlarm," + str;
        ActivityMain main=new ActivityMain();
        main.SendBt(strSend);

    }
}