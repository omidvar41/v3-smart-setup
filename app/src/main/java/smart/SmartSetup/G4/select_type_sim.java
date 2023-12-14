package smart.SmartSetup.G4;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.R;

public class select_type_sim extends EnhancedActivity {

    Button btnExit;
    Button   btnSave;
    RadioButton daeemi,eetebarihamrah,eetebariirancel,eetebari;
    EditText editText;
    ActivityMain main;
    Dialog dialog;

    public static select_type_sim select_type_sim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.g4_activity_select_type_sim);


        select_type_sim=this;
        dialog=new Dialog(this);
        btnExit = (Button) findViewById(R.id.btnExit);
        btnSave = (Button) findViewById(R.id.btnSave);
        daeemi = (RadioButton) findViewById(R.id.daeemi);
        eetebari = (RadioButton) findViewById(R.id.eetebari);
        eetebarihamrah = (RadioButton) findViewById(R.id.eetebarihamrah);
        eetebariirancel = (RadioButton) findViewById(R.id.eetebariirancel);

        editText=(EditText)findViewById(R.id.edtCharge);

        main=new ActivityMain();





        Intent intent=getIntent();
        if (intent!=null) {

            String number=intent.getStringExtra("number");


                if (number.equals("    ")) {
                    daeemi.setChecked(true);
                    editText.setVisibility(View.GONE);
                }
            else if (number.equals("")) {
                daeemi.setChecked(true);
                editText.setVisibility(View.GONE);
            } else if(number.equals("*140*11#")) {
                    eetebarihamrah.setChecked(true);
                    editText.setVisibility(View.VISIBLE);
                    editText.setText("*140*11#");
                    editText.requestFocus();
                    editText.setSelection(editText.length());
                    openkeyboard();
                } else if(number.equals("*141*1#")) {
                    eetebariirancel.setChecked(true);
                    editText.setVisibility(View.VISIBLE);
                    editText.setText("*141*1#");
                    editText.requestFocus();
                    editText.setSelection(editText.length());
                    openkeyboard();
                } else {
                    eetebari.setChecked(true);
                    editText.setVisibility(View.VISIBLE);
                    editText.setText(number);
                    editText.requestFocus();
                    editText.setSelection(editText.length());
                    openkeyboard();

                }


        }
        daeemi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setVisibility(View.GONE);
                hidekeyboard();
            }
        });

        eetebarihamrah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setVisibility(View.VISIBLE);
                editText.setText("*140*11#");
                editText.setFocusable(true);
                editText.requestFocus();
                editText.setSelection(editText.length());

                openkeyboard();

            }
        });


        eetebariirancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setVisibility(View.VISIBLE);
                editText.setText("*141*1#");

                editText.setFocusable(true);
                editText.requestFocus();
                editText.setSelection(editText.length());

                openkeyboard();
            }
        });

        eetebari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setVisibility(View.VISIBLE);
                editText.setText("");

                editText.setFocusable(true);
                editText.requestFocus();
                editText.setSelection(editText.length());

                openkeyboard();
            }
        });



        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidekeyboard();
                finish();
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (daeemi.isChecked()){
                    String str ="";
                    String unicod2 = "SaveCharge," + "1" + "," + str;
                    main.SendBt(unicod2);
                    ActivityMain.Cusd="";

                    hidekeyboard();
                    G.currentActivity.finish();




                    //   main.SendBt("LEVEL");
                }else if (eetebarihamrah.isChecked()){
                    ///  main.SendBt("EDGE");


                    if (0 != editText.length()) {
                        String str = editText.getText().toString();
                        String unicod2 = "SaveCharge," + "1" + "," + str;
                        ActivityMain.CodeChekCharge=" ";
                        main.SendBt(unicod2);

                        hidekeyboard();

                        G.currentActivity.finish();
                    }
                    else {

                        editText.setError("فرمول کنترل شارژ را وارد کنید");
                    }

                }

                ///////////////
                else if (eetebariirancel.isChecked()){
                    ///  main.SendBt("EDGE");


                    if (0 != editText.length()) {
                        String str = editText.getText().toString();
                        String unicod2 = "SaveCharge," + "1" + "," + str;
                        ActivityMain.CodeChekCharge=" ";
                        main.SendBt(unicod2);

                        hidekeyboard();

                        G.currentActivity.finish();
                    }
                    else {

                        editText.setError("فرمول کنترل شارژ را وارد کنید");
                    }

                }
                ///////////////////
                else if (eetebari.isChecked()){
                    ///  main.SendBt("EDGE");


                    if (0 != editText.length()) {
                        String str = editText.getText().toString();
                        String unicod2 = "SaveCharge," + "1" + "," + str;
                        ActivityMain.CodeChekCharge=" ";
                        main.SendBt(unicod2);

                        hidekeyboard();

                        G.currentActivity.finish();
                    }
                    else {

                        editText.setError("فرمول کنترل شارژ را وارد کنید");
                    }

                }


            }
        });


    }
    public void   hidekeyboard(){
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public void   openkeyboard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);

    }
}
