package smart.SmartSetup;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

/**
 * Created by Roholah on 30/06/2017.
 */

public class CustomDialogClass extends Dialog implements View.OnClickListener {


    public boolean valu = false;
    public Activity c;
    public Dialog d;
    public Button yes, no;
    TextView txt_dia;

    public CustomDialogClass(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.bt_custom_dialog);
        yes = (Button) findViewById(R.id.btn_yes);
        no = (Button) findViewById(R.id.btn_no);
        txt_dia = findViewById(R.id.txt_dia);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            txt_dia.setText("لطفا بلوتوث دستگاه خود را روشن کنید");
            no.setVisibility(View.GONE);
            yes.setText("تأیید");
        }






    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:
                valu = true;
                //BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                //bluetoothAdapter.enable();


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                        ActivityCompat.checkSelfPermission(getContext(),
                                Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {

                    c.requestPermissions(new String[]{Manifest.permission.BLUETOOTH_CONNECT},
                            49);



                    return;
                }





                ActivityMain.mBluetoothAdapter.enable();

                break;
            case R.id.btn_no:
                valu = true;
                c.finish();

                break;

            default:



                break;
        }



        dismiss();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();



    }
}
