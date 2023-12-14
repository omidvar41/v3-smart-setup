package smart.SmartSetup.MGZ8.Edit;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.R;

public class Edit_Panel_Zon24 extends EnhancedActivity {

    Button btnExit;
    Button btnSave;
    RadioButton active, twoactive, notactive;

    ActivityMain main;
    public static Edit_Panel_Zon24 edit_panel_zon24;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.mgz8_activity_edit__panel__zon24);
        edit_panel_zon24 = this;

        btnExit = (Button) findViewById(R.id.btnExit);
        btnSave = (Button) findViewById(R.id.btnSave);
        active = (RadioButton) findViewById(R.id.Active);
        twoactive = (RadioButton) findViewById(R.id.twoActive);
        notactive = (RadioButton) findViewById(R.id.notActive);

        main = new ActivityMain();


        Intent intent = getIntent();
        if (intent != null) {
            String code = intent.getStringExtra("code");

            switch (code) {
                case "1":
                    active.setChecked(true);

                    break;
                case "2":
                    twoactive.setChecked(true);

                    break;
                case "3":
                    notactive.setChecked(true);

                    break;
                default:
            }

        }

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (active.isChecked()){
                   String strSend = "forPANEL," + "Z24h," + "1";

                    main.SendBt(strSend);

                }if (twoactive.isChecked()){
                    String strSend = "forPANEL," + "Z24h," + "2";

                    main.SendBt(strSend);


                 }if (notactive.isChecked()){
                    String strSend = "forPANEL," + "Z24h," + "0";

                    main.SendBt(strSend);
                }


finish();

            }
        });
    }
}
