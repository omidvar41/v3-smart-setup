package smart.SmartSetup.MGZ8.Edit;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.ArrayList;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.MG4.view_descip;
import smart.SmartSetup.R;

public class ActivivtyEditselectTypeCall extends EnhancedActivity {
    Button btnExit;
    Button   btnSave;
    RadioButton chlevel,chEage;
    int falgChek;
    ActivityMain main;
    Dialog dialog;
public static ActivivtyEditselectTypeCall activivtyEditselectTypeCall;
    Handler handler3;

    ArrayList<view_descip> view_descips=new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mgz8_activivty_editselect_type_call);


        dialog=new Dialog(this);
activivtyEditselectTypeCall=this;
        btnExit = (Button) findViewById(R.id.btnExit);
        btnSave = (Button) findViewById(R.id.btnSave);
        chEage = (RadioButton) findViewById(R.id.chEage);
        chlevel = (RadioButton) findViewById(R.id.chlevel);
        main=new ActivityMain();

        Intent intent=getIntent();
        final String code=intent.getStringExtra("code");

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chlevel.isChecked()){
                    main.SendBt("CallGsm,"+code);
                }if (chEage.isChecked()){
                    main.SendBt("CallPhon,"+code);

                }

//showorhideDialog();
                finish();

            }
        });

        view_descips.add(new view_descip(chEage,"",""));
        view_descips.add(new view_descip(chlevel,"",""));


        chEage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(0));
                return true;
            }
        });

        chlevel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setviewHelp(view_descips.get(1));
                return true;
            }
        });


    }


    public void setviewHelp(view_descip view){
        TapTargetView.showFor(dialog,                 // `this` is an Activity
                TapTarget.forView(view.getView(), view.getTitle(), view.getDesc())

                        // All options below are optional
                        .outerCircleColor(R.color.blue)      // Specify a color for the outer circle
                        .outerCircleAlpha(0.96f)            // Specify the alpha amount for the outer circle
                        .targetCircleColor(R.color.white)   // Specify a color for the target circle
                        .titleTextSize(20)                  // Specify the size (in sp) of the title text
                        .titleTextColor(R.color.white)      // Specify the color of the title text
                        .descriptionTextSize(15)            // Specify the size (in sp) of the description text
                        .descriptionTextColor(R.color.red)  // Specify the color of the description text
                        .textColor(R.color.black)            // Specify a color for both the title and description text
                        .textTypeface(Typeface.SANS_SERIF)  // Specify a typeface for the text
                        .dimColor(R.color.black)// If set, will dim behind the view with 30% opacity of the given color
                        .drawShadow(true)               // Whether to draw a drop shadow or not
                        .cancelable(true)                  // Whether tapping outside the outer circle dismisses the view

                        .tintTarget(true)
                        // Whether to tint the target view's color
                        .transparentTarget(true)// Specify whether the target is transparent (displays the content underneath)
                        // Specify a custom drawable to draw as the target
                        .targetRadius(30)// Specify the target radius (in dp)
                ,  new TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
                    @Override
                    public void onTargetClick(TapTargetView view) {
                        super.onTargetClick(view);      // This call is optional





                    }



                });
    }

    @Override
    protected void onDestroy() {


        super.onDestroy();
    }

    @Override
    public void onBackPressed() {


        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
