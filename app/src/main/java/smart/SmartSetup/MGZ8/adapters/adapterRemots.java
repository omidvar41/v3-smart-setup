package smart.SmartSetup.MGZ8.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.MGZ8.models.Remote;
import smart.SmartSetup.R;
import smart.SmartSetup.tools;


public abstract   class adapterRemots extends RecyclerView.Adapter<adapterRemots.viewHolder> {
    private Context context;
    private List<Remote> modelTestList;
    public abstract void click(Remote remote);
    public abstract void longClick (Remote remote);
    public abstract void delete (Remote remote);


     public adapterRemots(Context context, List<Remote> modelTestList) {

        this.context = context;


        this.modelTestList = modelTestList;

    }

    @Override
    public adapterRemots.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mgz8_item_remote, parent, false);


        return new adapterRemots.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final adapterRemots.viewHolder holder, final int position) {
        Log.e("rmmAdapter",modelTestList.get(position).getPartitionName()+"");
        Log.e("rmmAdapter",modelTestList.get(position).getNumRemote()+" nnn");
       // holder.txtName.setTypeface(G.typeface);
        String a = modelTestList.get(position).getName();
        holder.nameRemote.setText(tools.StringToChar(a));

         holder.numRemote.setText("ریموت "+modelTestList.get(position).getNumRemote()+" : ");

    //     if (modelTestList.get(position).getPartitionName() == 1){
        //     holder.layRemote.setBackgroundResource(R.drawable.back_btn_clik1);

//         }else {
//             holder.layRemote.setBackgroundResource(R.drawable.btn_click2);
//
//         }


         holder.layRemote.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 click(modelTestList.get(position));
             }
         });

         holder.btnDelete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 delete(modelTestList.get(position));
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

         TextView nameRemote,numRemote;
         LinearLayout layRemote;
         ImageView btnDelete;


        public viewHolder(View itemView) {
            super(itemView);
            nameRemote = itemView.findViewById(R.id.txtRemot1);
            numRemote = itemView.findViewById(R.id.textView1);
            layRemote = itemView.findViewById(R.id.layRemote);
            btnDelete = itemView.findViewById(R.id.btnDelete);




        }
    }




    public void removeItem(int position) {
        modelTestList.remove(position); // this is what you need
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }
}