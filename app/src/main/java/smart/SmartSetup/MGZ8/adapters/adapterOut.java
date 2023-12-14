package smart.SmartSetup.MGZ8.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import smart.SmartSetup.MGZ8.models.OutName;
import smart.SmartSetup.MGZ8.models.Zon;
import smart.SmartSetup.R;
import smart.SmartSetup.tools;


public abstract   class adapterOut extends RecyclerView.Adapter<adapterOut.viewHolder> {
    private Context context;
    private List<OutName> modelTestList;
    public abstract void click(OutName OutName,int pos);
    public abstract void longClick (OutName OutName);


     public adapterOut(Context context, List<OutName> modelTestList) {

        this.context = context;


        this.modelTestList = modelTestList;

    }

    @Override
    public adapterOut.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_oute_name_mgz8, parent, false);


        return new adapterOut.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final adapterOut.viewHolder holder, final int position) {

           holder.textOutName.setText(tools.StringToChar(modelTestList.get(position).getName())+"");
           holder.numOut.setText("OUT"+(position+1));

           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   click(modelTestList.get(position),position+1);
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

         TextView  textOutName,numOut;

        public viewHolder(View itemView) {
            super(itemView);

            textOutName= itemView.findViewById(R.id.textOutName);
            numOut= itemView.findViewById(R.id.numOut);





        }
    }




    public void removeItem(int position) {
        modelTestList.remove(position); // this is what you need
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }
}