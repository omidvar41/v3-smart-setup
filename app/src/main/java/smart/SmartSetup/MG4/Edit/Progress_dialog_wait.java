package smart.SmartSetup.MG4.Edit;

import android.os.Handler;
import android.os.Bundle;
import android.widget.TextView;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.R;

import static java.lang.Thread.sleep;

public class Progress_dialog_wait extends EnhancedActivity {
TextView massage;
Handler handler1;
   public static Progress_dialog_wait progress_dialog_wait;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mg4_activity_progress_dialog_wait);
        massage=(TextView)findViewById(R.id.message) ;
       // ActivityPhoneNumberMG4.handler3.removeCallbacksAndMessages(null);
progress_dialog_wait=this;


        handler1 = new Handler();
        handler1.postDelayed(new Runnable(){
            public void run(){

                handler1.postDelayed(this, 500);

                massage.setText(ActivityMain.LCD_DIALOG);
                if (ActivityMain.flagGO.equals("0")){
                    finish();
                }

            }
        }, 0);







    }
    @Override
    protected void onDestroy() {
        handler1.removeCallbacksAndMessages(null);

        finish();
        super.onDestroy();
    }
    @Override
    public void onBackPressed() {
        handler1.removeCallbacksAndMessages(null);
        finish();
        super.onBackPressed();
    }

}
