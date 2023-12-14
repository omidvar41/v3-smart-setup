package smart.SmartSetup;

import android.Manifest;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import smart.SmartSetup.MGZ8.models.OutName;


public abstract class adapterDevices extends RecyclerView.Adapter<adapterDevices.viewHolder> {
    private Context context;
    private List<BluetoothDevice> modelTestList;

    public abstract void click(BluetoothDevice device);


    public adapterDevices(Context context, List<BluetoothDevice> modelTestList) {

        this.context = context;


        this.modelTestList = modelTestList;

    }

    @Override
    public adapterDevices.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_device_bind, parent, false);


        return new adapterDevices.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final adapterDevices.viewHolder holder, int position) {

        if (ActivityCompat.checkSelfPermission(context,
                Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        holder.textOutName.setText(modelTestList.get(position).getName());

           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   click(modelTestList.get(position));
               }
           });




    }




    @Override
    public int getItemCount() {
        return modelTestList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

         TextView  textOutName;

        public viewHolder(View itemView) {
            super(itemView);

            textOutName= itemView.findViewById(R.id.txt_device_name);






        }
    }



}