package smart.SmartSetup.MGZ8.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
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

import smart.SmartSetup.G;
import smart.SmartSetup.MGZ8.models.Remote;
import smart.SmartSetup.MGZ8.models.Zon;
import smart.SmartSetup.R;
import smart.SmartSetup.tools;


public abstract   class adapterZon extends RecyclerView.Adapter<adapterZon.viewHolder> {
    private Context context;
    private List<Zon> modelTestList;
    public abstract void click(Zon zon);
    public abstract void longClick (Zon zon);


     public adapterZon(Context context, List<Zon> modelTestList) {

        this.context = context;


        this.modelTestList = modelTestList;

    }

    @Override
    public adapterZon.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mgz8_item_zon, parent, false);


        return new adapterZon.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final adapterZon.viewHolder holder, final int position) {

           holder.txtNumber.setText(modelTestList.get(position).getNumber()+"");
            holder.txtName.setText(tools.StringToChar(modelTestList.get(position).getName()+""));

           holder.txtMode.setText(modelTestList.get(position).getMode()+"");
           if (modelTestList.get(position).getDingDang().equals("1")){
               holder.ImageDingDang.setVisibility(View.VISIBLE);

               holder.ImageDingDang.setImageResource(R.drawable.song);

           }else {
               holder.ImageDingDang.setVisibility(View.INVISIBLE);
           }


           if (modelTestList.get(position).getMode().equals("0")){
               holder.txtMode.setText("نرمال");

           }else if (modelTestList.get(position).getMode().equals("1")){
               holder.txtMode.setText("نیمه فعال");

           }else if (modelTestList.get(position).getMode().equals("2")){
               holder.txtMode.setText("24 ساعته");

           }else if (modelTestList.get(position).getMode().equals("3")){
               holder.txtMode.setText("24 ساعته بیصدا");

           }

           else {
               holder.txtMode.setText("تاخیری");


           }


           if (modelTestList.get(position).getStatus().equals("1")){

               holder.viewStatus.setBackgroundResource(R.drawable.circle_red);

           }else{
               holder.viewStatus.setBackgroundResource(R.drawable.circle_border_white);



           }
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   click(modelTestList.get(position));
               }
           });

           if (modelTestList.get(position).getIsDelete().equals("1")){
               holder.layZon.setBackground(context.getResources().getDrawable(R.drawable.btn_left_blu_circle));

           }else {
               holder.layZon.setBackground(context.getResources().getDrawable(R.drawable.back_btn_clik1));
           }




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

         TextView  txtName,txtNumber,txtMode;
         ImageView ImageDingDang;
         View viewStatus;
         LinearLayout layZon;


        public viewHolder(View itemView) {
            super(itemView);
            layZon = itemView.findViewById(R.id.layZon);

            txtName= itemView.findViewById(R.id.txtName);
            txtNumber= itemView.findViewById(R.id.txtNumber);

            txtMode = itemView.findViewById(R.id.txtMode);
            ImageDingDang = itemView.findViewById(R.id.ImageDingDang);
            viewStatus = itemView.findViewById(R.id.viewStatus);





        }
    }




    public void removeItem(int position) {
        modelTestList.remove(position); // this is what you need
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }
}