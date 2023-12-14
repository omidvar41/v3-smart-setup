package smart.SmartSetup.G4.Edit;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G;
import smart.SmartSetup.R;

/**
 * Created by Roholah on 30/06/2017.
 */

public class ActivityEditPhoneNumberG4 extends EnhancedActivity {
public static ActivityEditPhoneNumberG4 activityEditPhoneNumberG4;
    TextView txtMamoryEdit,txtPhoneCn;
    Button btnExit;
    Button   btnSave;
    EditText edtPhoneNumber;
    String   Mamory,desc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g4_activity_edit_phone_numbe);
        activityEditPhoneNumberG4=this;
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
        txtMamoryEdit = (TextView) findViewById(R.id.txtMamoryEdit);

        btnExit = (Button) findViewById(R.id.btnExit);
        btnSave = (Button) findViewById(R.id.btnSave);
        edtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumber);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("MAMORY")) {
                Mamory = extras.getString("MAMORY");
                txtMamoryEdit.setText("حافظه " + Mamory);
            }
            if (extras.containsKey("desc")){
                desc=extras.getString("desc");
                edtPhoneNumber.setText(desc);
                edtPhoneNumber.setSelection(edtPhoneNumber.length());
            }
        }


        ///.............................................................
        txtPhoneCn = (TextView) findViewById(R.id.txtPhoneCn);

        if (Mamory.equals("0")){
            txtPhoneCn.setText("0/7");
            int maxLength = 7;
            InputFilter[] fArray = new InputFilter[1];
            fArray[0] = new InputFilter.LengthFilter(maxLength);
            edtPhoneNumber.setFilters(fArray);
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
                if (Mamory.equals("0")){
                    txtPhoneCn.setText("7/" + String.valueOf(edtPhoneNumber.length()));

                }else {
                    txtPhoneCn.setText("16/" + String.valueOf(edtPhoneNumber.length()));
                }

            }
        });
        ///.............................................................
        btnExit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                hidekeyboard();
                G.currentActivity.finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String str = ("Save," + (Mamory) + "," + (edtPhoneNumber.getText().toString()));
hidekeyboard();
                ActivityMain main=new ActivityMain();
                main.SendBt(str);
                G.currentActivity.finish();
            }
        });

    }
    public void   hidekeyboard(){
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtPhoneNumber.getWindowToken(), 0);
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
