package smart.SmartSetup.G4.Edit;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.R;

/**
 * Created by Roholah on 30/06/2017.
 */

public class ActivitySendChargeG4 extends EnhancedActivity {
    public  static  ActivitySendChargeG4 activitySendChargeG4;
    Button btnSendCharge;
    Button   btnExitCharge;
    EditText edtCharge;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g4_activity_send_charge);
activitySendChargeG4=this;
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);

        btnSendCharge = (Button) findViewById(R.id.btnSendCharge);
        btnExitCharge = (Button) findViewById(R.id.btnExitCharge);
        edtCharge = (EditText) findViewById(R.id.edtCharge);

        ///.............................................................
        btnSendCharge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (0 != edtCharge.length()) {
                    hidekeyboard();
                    String str = ("AddCharge," + (edtCharge.getText().toString()));
                    ActivityMain main=new ActivityMain();
                    main.SendBt(str);
                    G.currentActivity.finish();
                } else {

                }
            }
        });

        btnExitCharge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                hidekeyboard();
                G.currentActivity.finish();
            }
        });



    }
    public void   hidekeyboard(){
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtCharge.getWindowToken(), 0);
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
