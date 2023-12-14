package smart.SmartSetup;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class Dialog_tabligh extends EnhancedActivity {
    ImageView imageView,close;
    TextView textView;
    public  static String code;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.activity_dialog_tabligh);


        imageView=(ImageView)findViewById(R.id.imagedevice);
        close=(ImageView)findViewById(R.id.close);
        textView=(TextView)findViewById(R.id.description);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        switch (code){
            case "1":
                imageView.setImageResource(R.drawable.zfour);
                textView.setText("سیستم حفاظتی چهار زون ساده\n" +
                        "چهار زون باسیم باقابلیت اتصال سنسور های بیسیم\n" +
                        "اتصال با چهار سیم به تلفن کننده سیمکارتی G4\n" +
                        "کنترل از راه دور توسط تلفن کننده \n" +
                        "آژیر پر قدرت");
                break;

            case "2":
                imageView.setImageResource(R.drawable.g_one);
                textView.setText("تلفن کننده سیمکارت و خط ثابت\n" +
                        "گزارش قطع و وصل برق و قطع خط تلفن\n" +
                        "نامگذاری هر زون به صورت مجزا (فارسی و انگلیسی)\n" +
                        "ارسال نام زون و شماره چشم بی سیم \n" +
                        "قابلیت برنامه ریزی دستگاه از طریق بلوتوث و پیام کوتاه\n" +
                        "قابلیت ارسال پیام کوتاه فارسی\n" +
                        "گزارش گیری ورود و خروج \n" +
                        "شماره گذاری ریموت ها \n" +
                        "ارسال شماره ریموت در گزارش\n" +
                        "نام گذاری ریموتها، زونها و سنسورهای بیسیم\n" +
                        "۴ خروجی قابل کنترل با پیام کوتاه و تماس صوتی\n" +
                        "قابلیت برنامه ریزی و کنترل دستگاه از طریق نرم افزار اندروید \n" +
                        "۷۰ حافظه شماره تلفن \n" +
                        "تماس از طریق سیم کارت و خط تلفن\n" +
                        "امکان فعال و غیرفعال کردن دزدگیر از طریق پیام کوتاه ، تماس و نرم افزار اندروید و IOS\n" +
                        "گزارش دوره ای شارژ");
                break;


            case "3":
                imageView.setImageResource(R.drawable.tsten);
                textView.setText("تلفن کننده خط ثابت\n" +
                        "۱۰ حافظه\n" +
                        "۳۰ ثانیه ضبط پیام صوتی\n" +
                        "کنترل از راه دور\n" +
                        "استراق سمع");
                break;
                default:
                    break;
        }



    }
}
