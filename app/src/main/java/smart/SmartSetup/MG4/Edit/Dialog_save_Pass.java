package smart.SmartSetup.MG4.Edit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.R;

import static java.lang.Thread.sleep;

public class Dialog_save_Pass extends EnhancedActivity {
    ImageView imageView;
    public static Dialog_save_Pass dialog_save_pass;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dialog_save__pass);
        dialog_save_pass=this;
        imageView=(ImageView)findViewById(R.id.img);
        textView=(TextView)findViewById(R.id.message);
        Intent intent=getIntent();
        if (intent!=null) {
            String code=intent.getStringExtra("code");
            if (code.equals("1")){
                imageView.setImageResource(R.drawable.okpass);
                textView.setText("تغییر رمز با موفقیت انجام شد");
            }else {
                imageView.setImageResource(R.drawable.errorpass);
                textView.setText("خطا !! \n"+"اطلاعات وارد شده صحیح نیست !!");
            }




        }


        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
        thread.start();



    }
}
