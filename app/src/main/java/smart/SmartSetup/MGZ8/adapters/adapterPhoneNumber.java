package smart.SmartSetup.MGZ8.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import smart.SmartSetup.G;
import smart.SmartSetup.MGZ8.Edit.ActivityEditRemotNameMGZ8;
import smart.SmartSetup.MGZ8.models.Remote;
import smart.SmartSetup.MGZ8.models.partitionRemote;
import smart.SmartSetup.MGZ8.models.phoneNumber;
import smart.SmartSetup.R;
import smart.SmartSetup.tools;


public  abstract    class adapterPhoneNumber extends RecyclerView.Adapter<adapterPhoneNumber.viewHolder> {
    private Context context;
    private List<phoneNumber> modelTestList;
    public abstract void click(phoneNumber phoneNumber);
    public abstract void clickTest(phoneNumber phoneNumber);


     public adapterPhoneNumber(Context context, List<phoneNumber> modelTestList) {

        this.context = context;


        this.modelTestList = modelTestList;

    }

    @Override
    public adapterPhoneNumber.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mgz8_item_phone_number, parent, false);


        return new adapterPhoneNumber.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final adapterPhoneNumber.viewHolder holder, final int position) {
    //    Log.e("rmmAdapter",modelTestList.get(position).getPartitionName()+"");


        holder.txtNumber.setText(modelTestList.get(position).getNumber());
        holder.numMemory.setText(" : "+modelTestList.get(position).getNumMemory().trim());
        if (modelTestList.get(position).getNumber().equals("Empty")){
            holder.btnTest.setVisibility(View.GONE);
        }else {
            holder.btnTest.setVisibility(View.VISIBLE);

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(modelTestList.get(position));
            }
        });
        holder.btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickTest(modelTestList.get(position));

            }
        });



    }


    public String moneyFormat(String number){
        try {
            NumberFormat formatter = new DecimalFormat("#,###");
            return formatter.format(Integer.parseInt(number));
        }catch (Exception e){
            return number;
        }

    }

    @Override
    public int getItemCount() {
        return modelTestList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

         TextView txtNumber,numMemory;
         Button btnTest;



        public viewHolder(View itemView) {
            super(itemView);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            numMemory = itemView.findViewById(R.id.numMemory);
            btnTest = itemView.findViewById(R.id.btnTest);




        }
    }




    public void removeItem(int position) {
        modelTestList.remove(position); // this is what you need
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }
}