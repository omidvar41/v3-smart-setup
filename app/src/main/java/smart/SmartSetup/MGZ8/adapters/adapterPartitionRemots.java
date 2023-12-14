package smart.SmartSetup.MGZ8.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.G;
import smart.SmartSetup.MGZ8.Edit.ActivityEditRemotNameMGZ8;
import smart.SmartSetup.MGZ8.models.Remote;
import smart.SmartSetup.MGZ8.models.partitionRemote;
import smart.SmartSetup.R;
import smart.SmartSetup.tools;


public     class adapterPartitionRemots extends RecyclerView.Adapter<adapterPartitionRemots.viewHolder> {
    private Context context;
    private List<partitionRemote> modelTestList;


     public adapterPartitionRemots(Context context, List<partitionRemote> modelTestList) {

        this.context = context;


        this.modelTestList = modelTestList;

    }

    @Override
    public adapterPartitionRemots.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mgz8_item_main_remote_list, parent, false);


        return new adapterPartitionRemots.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final adapterPartitionRemots.viewHolder holder, final int position) {
    //    Log.e("rmmAdapter",modelTestList.get(position).getPartitionName()+"");

        holder.namePartition.setText(modelTestList.get(position).getName());
        if (modelTestList.get(position).getRemoteList().size() == 0){
            holder.consMain.setVisibility(View.GONE);
        }else {
            holder.consMain.setVisibility(View.VISIBLE);


        }



        if (modelTestList.get(position).getName().equals("پارتیشن یک")){
            holder.consMain.setBackgroundColor(Color.WHITE);


        }else {
            holder.consMain.setBackgroundColor(Color.LTGRAY);

        }



        adapterRemots adapterRemots = new adapterRemots(context, modelTestList.get(position).getRemoteList()) {
            @Override
            public void click(Remote remote) {
                Intent intent = new Intent(G.currentActivity, ActivityEditRemotNameMGZ8.class);
                intent.putExtra("REMOT", remote);
                G.currentActivity.startActivity(intent);
            }

            @Override
            public void longClick(Remote remote) {

            }

            @Override
            public void delete(final Remote remote) {
                AlertDialog.Builder builder = new AlertDialog.Builder(G.currentActivity);
                builder.setTitle("اخطار");
                builder.setMessage("از حذف ریموت اطمینان دارید؟");
                builder.setNegativeButton("انصراف", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("بله", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityMain main=new ActivityMain();
                        main.SendBt("RemoveRemote,"+remote.getNumRemote());
                    }
                });

                builder.create().show();
            }
        };
        holder.recycleView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.VERTICAL,false));

        holder.recycleView.setAdapter(adapterRemots);



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