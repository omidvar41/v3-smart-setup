package smart.SmartSetup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import java.util.List;

import smart.SmartSetup.MGZ8.models.Remote;
import smart.SmartSetup.R;

public class dialog_device_list extends Dialog {
    RecyclerView recyclerView;
     List<BluetoothDevice> deviceList;
    Context context;
    Button btnExit;

    public dialog_device_list(@NonNull Context context,List<BluetoothDevice> deviceList) {
        super(context);
        this.context = context;
        this.deviceList = deviceList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);





        setContentView(R.layout.activity_dialog_device_list);
        recyclerView = findViewById(R.id.recycleView);
        btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(v -> dismiss());


        adapterDevices adapterDevices = new adapterDevices(context,deviceList) {
            @Override
            public void click(BluetoothDevice device) {
                ActivityMain.mBluetoothSPPConnection.open(device);
                dismiss();

            }
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapterDevices);

    }
}