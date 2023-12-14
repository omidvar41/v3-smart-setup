package smart.SmartSetup.MGZ8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.MG4.Edit.ActivivtyEditselectTypeCall;
import smart.SmartSetup.MG4.view_descip;
import smart.SmartSetup.R;

public class dialog_select_type_call_MGZ8 extends EnhancedActivity {
    Button btnExit;
    Button   btnSave;
    RadioButton chlevel,chEage,chSms;
    int falgChek;
    ActivityMain main;
    Dialog dialog;
    public static dialog_select_type_call_MGZ8 dialog_select_type_call_MGZ8;
    ArrayList<view_descip> view_descips=new ArrayList<>();
    String number,selection;

    TextView txtNumber;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.activity_dialog_select_type_call__mgz8);

        dialog=new Dialog(this);
        dialog_select_type_call_MGZ8=this;
        btnExit = (Button) findViewById(R.id.btnExit);
        btnSave = (Button) findViewById(R.id.btnSave);
        chEage = (RadioButton) findViewById(R.id.chEage);
        chlevel = (RadioButton) findViewById(R.id.chlevel);
        chSms = (RadioButton) findViewById(R.id.chSms);
        txtNumber =  findViewById(R.id.txtNumber);
        main=new ActivityMain();

        Intent intent=getIntent();
        final String code=intent.getStringExtra("code");
        number = intent.getStringExtra("number");
        txtNumber.setText(number+"");
        selection = intent.getStringExtra("selection");

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chlevel.isChecked()){
                    main.SendBt("CallGsm,"+code);
                }if (chEage.isChecked()){
                    main.SendBt("CallPhon,"+code);

                }if (chSms.isChecked()){
                                    String str = ("TestSms,"+code);

                main.SendBt(str);
                }

//showorhideDialog();
                finish();

            }
        });

        view_descips.add(new smart.SmartSetup.MG4.view_descip(chEage,"",""));
        view_descips.add(new view_descip(chlevel,"",""));


//        chEage.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                setviewHelp(view_descips.get(0));
//                return true;
//            }
//        });
//
//        chlevel.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                setviewHelp(view_descips.get(1));
//                return true;
//            }
//        });
    }
}