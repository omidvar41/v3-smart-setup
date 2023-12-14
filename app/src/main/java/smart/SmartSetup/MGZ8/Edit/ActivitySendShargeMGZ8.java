package smart.SmartSetup.MGZ8.Edit;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.R;

public class ActivitySendShargeMGZ8 extends EnhancedActivity {
    Button btnSendCharge;
    Button   btnExitCharge;
    EditText edtCharge;
    String   Mamory;
    public  static ActivitySendShargeMGZ8 activitySendShargeMGZ8;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.mgz8_activity_send_sharge);
        activitySendShargeMGZ8 =this;
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
                    String str = ("AddCharge," + (edtCharge.getText().toString()));
                    ActivityMain main=new ActivityMain();
                    main.SendBt(str);
                    hidekeyboard();

                    G.currentActivity.finish();
                } else {

                }
            }
        });

        btnExitCharge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                G.currentActivity.finish();hidekeyboard();
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
