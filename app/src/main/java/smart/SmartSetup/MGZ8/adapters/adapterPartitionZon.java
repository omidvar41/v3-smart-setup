package smart.SmartSetup.MGZ8.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import smart.SmartSetup.G;
import smart.SmartSetup.MGZ8.Edit.ActivityEditRemotNameMGZ8;
import smart.SmartSetup.MGZ8.Edit.ActivityEditZonNameMGZ8;
import smart.SmartSetup.MGZ8.models.Remote;
import smart.SmartSetup.MGZ8.models.Zon;
import smart.SmartSetup.MGZ8.models.partitionRemote;
import smart.SmartSetup.MGZ8.models.partitionZon;
import smart.SmartSetup.R;


public     class adapterPartitionZon extends RecyclerView.Adapter<adapterPartitionZon.viewHolder> {
    private Context context;
    private List<partitionZon> modelTestList;


     public adapterPartitionZon(Context context, List<partitionZon> modelTestList) {

        this.context = context;


        this.modelTestList = modelTestList;

    }

    @Override
    public adapterPartitionZon.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mgz8_item_main_zon_list, parent, false);


        return new adapterPartitionZon.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final adapterPartitionZon.viewHolder holder, final int position) {
    //    Log.e("rmmAdapter",modelTestList.get(position).getPartitionName()+"");

        holder.namePartition.setText(modelTestList.get(position).getName());
        if (modelTestList.get(position).getZonList().size() == 0){
            holder.consMain.setVisibility(View.GONE);
        }else {
            holder.consMain.setVisibility(View.VISIBLE);


        }



        if (modelTestList.get(position).getName().equals("پارتیشن یک")){
            holder.consMain.setBackgroundColor(Color.WHITE);


        }else if (modelTestList.get(position).getName().equals("پارتیشن دو")){

            holder.consMain.setBackgroundColor(Color.LTGRAY);


        }else if (modelTestList.get(position).getName().equals("مشترک")){
            holder.consMain.setBackgroundColor(Color.WHITE);



        }else {
            holder.consMain.setBackgroundColor(Color.LTGRAY);

        }



        adapterZon adapterZon = new adapterZon(context, modelTestList.get(position).getZonList()) {
            @Override
            public void click(Zon zon) {



                Intent intent = new Intent(G.currentActivity, ActivityEditZonNameMGZ8.class);
                intent.putExtra("ZON", zon);
                G.currentActivity.startActivity(intent);

            }

            @Override
            public void longClick(Zon zon) {

            }
        };
        holder.recycleView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.VERTICAL,false));

        holder.recycleView.setAdapter(adapterZon);



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

         TextView namePartition;
         ConstraintLayout consMain;
         RecyclerView recycleView;


        public viewHolder(View itemView) {
            super(itemView);
            consMain = itemView.findViewById(R.id.consMain);
            namePartition = itemView.findViewById(R.id.namePartition);
            recycleView = itemView.findViewById(R.id.recycleView);




        }
    }




    public void removeItem(int position) {
        modelTestList.remove(position); // this is what you need
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }
}