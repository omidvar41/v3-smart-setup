package smart.SmartSetup.MGZ8.Edit;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import smart.SmartSetup.ActivityMain;
import smart.SmartSetup.EnhancedActivity;
import smart.SmartSetup.G4.ActivityChargeG4;
import smart.SmartSetup.G4.ActivityListG4;
import smart.SmartSetup.G4.ActivityOutNameG4;
import smart.SmartSetup.G4.ActivityPanelG4;
import smart.SmartSetup.G4.ActivityPaswordG4;
import smart.SmartSetup.G4.ActivityPhoneNumberG4;
import smart.SmartSetup.G4.ActivityRemotNameG4;
import smart.SmartSetup.G4.ActivitySmsNumberG4;
import smart.SmartSetup.G4.ActivityTrigText;
import smart.SmartSetup.G4.ActivityZonNameG4;
import smart.SmartSetup.G4.Edit.ActivityEditChargeG4;
import smart.SmartSetup.G4.Edit.ActivityEditOutNameG4;
import smart.SmartSetup.G4.Edit.ActivityEditPanelSettingG4;
import smart.SmartSetup.G4.Edit.ActivityEditPhoneNumberG4;
import smart.SmartSetup.G4.Edit.ActivityEditRemotNameG4;
import smart.SmartSetup.G4.Edit.ActivityEditSmsNumberG4;
import smart.SmartSetup.G4.Edit.ActivityEditTrigNameG4;
import smart.SmartSetup.G4.Edit.ActivityEditWlNameG4;
import smart.SmartSetup.G4.Edit.ActivityEditZonNameG4;
import smart.SmartSetup.G4.Edit.ActivitySendChargeG4;
import smart.SmartSetup.G4.select_type_sim;
import smart.SmartSetup.MG4.Edit.Progress_dialog_wait;
import smart.SmartSetup.MGZ8.About_System;
import smart.SmartSetup.MGZ8.ActivityChargeMGZ8;
import smart.SmartSetup.MGZ8.ActivityOutNameMGZ8;
import smart.SmartSetup.MGZ8.ActivityPanelMGZ8;
import smart.SmartSetup.MGZ8.ActivityPasswordMGZ8;
import smart.SmartSetup.MGZ8.ActivityPhoneNumberMGZ8;
import smart.SmartSetup.MGZ8.ActivityRemoteNameMGZ8;
import smart.SmartSetup.MGZ8.ActivitySmsNumberMGZ8;
import smart.SmartSetup.MGZ8.ActivityWlNameMGZ8;
import smart.SmartSetup.MGZ8.ActivityZonNameMGZ8;
import smart.SmartSetup.MGZ8.Activity_List_MGZ8;
import smart.SmartSetup.R;

public class Dialog_Close_app extends EnhancedActivity {

    TextView textView;
    Button btnclose;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog__close_app);
        removeActivity(ActivityEditChargeMGZ8.activityEditChargeMGZ8);
        removeActivity(ActivityEditOutNameMGZ8.activityEditOutNameMGZ8);
        removeActivity(ActivityEditpanelSettingMGZ8.activityEditpanelSettingMGZ8);
        removeActivity(ActivityEditPhoneNumberMGZ8.activityEditPhoneNumberMGZ8);
        removeActivity(ActivityEditRemotNameMGZ8.activityEditRemotNameMGZ8);
        removeActivity(ActivityEditSmsNumberMGZ8.activityEditSmsNumberMGZ8);
        removeActivity(ActivityEditTimeAlarmMGZ8.activityEditTimeAlarmMGZ8);
        removeActivity(ActivityEditTypeTrigMGZ8.activityEditTypeTrigMGZ8);
        removeActivity(ActivityEditWlNameMGZ8.activityEditWlNameMGZ8);
        removeActivity(ActivityEditZonNameMGZ8.activityEditZonNameMGZ8);
        removeActivity(ActivitySendShargeMGZ8.activitySendShargeMGZ8);
        removeActivity(Edit_Panel_Zon24.edit_panel_zon24);
        removeActivity(Progress_dialog_wait.progress_dialog_wait);
        removeActivity(Select_type_modelSim.select_type_modelSim);
        removeActivity(ActivivtyEditselectTypeCall.activivtyEditselectTypeCall);
        removeActivity(Dialog_save_Pass.dialog_save_pass);
        removeActivity(About_System.about_system);
        removeActivity(Activity_List_MGZ8.activity_list_MGZ8);
        removeActivity(ActivityChargeMGZ8.activityChargeMGZ8);
        removeActivity(ActivityOutNameMGZ8.activityOutNameMGZ8);
        removeActivity(ActivityPanelMGZ8.activityPanelMGZ8);
        removeActivity(ActivityPasswordMGZ8.activityPasswordMGZ8);
        removeActivity(ActivityPhoneNumberMGZ8.activityPhoneNumberMGZ8);
        removeActivity(ActivityRemoteNameMGZ8.activityRemoteNameMGZ8);
        removeActivity(ActivitySmsNumberMGZ8.activitySmsNumberMGZ8);
        removeActivity(ActivityWlNameMGZ8.activityWlNameMGZ8);
        removeActivity(ActivityZonNameMGZ8.activityZonNameMGZ8);
        ////////////////G4
        removeActivity(ActivityChargeG4.activityChargeG4);
        removeActivity(ActivityListG4.activityListG4);
        removeActivity(ActivityOutNameG4.activityOutNameG4);
        removeActivity(ActivityPanelG4.activityPanelG4);
        removeActivity(ActivityPaswordG4.activityPaswordG4);
        removeActivity(ActivityPhoneNumberG4.activityPhoneNumberG4);
        removeActivity(ActivityRemotNameG4.activityRemotNameG4);
        removeActivity(ActivitySmsNumberG4.activitySmsNumberG4);
        removeActivity(ActivityTrigText.activityTrigText);
        removeActivity(ActivityWlNameMGZ8.activityWlNameMGZ8);
        removeActivity(ActivityZonNameG4.activityZonNameG4);
        removeActivity(select_type_sim.select_type_sim);



        removeActivity(ActivityEditChargeG4.activityEditChargeG4);
        removeActivity(ActivityEditOutNameG4.activityEditOutNameG4);

        removeActivity(ActivityEditPanelSettingG4.activityEditPanelSettingG4);
        removeActivity(ActivityEditPhoneNumberG4.activityEditPhoneNumberG4);
        removeActivity(ActivityEditRemotNameG4.activityEditRemotNameG4);
        removeActivity(ActivityEditSmsNumberG4.activityEditSmsNumberG4);
        removeActivity(ActivityEditTimeAlarmMGZ8.activityEditTimeAlarmMGZ8);
        removeActivity(ActivityEditTrigNameG4.activityEditTrigNameG4);
        removeActivity(ActivityEditWlNameG4.activityEditWlNameG4);
        removeActivity(ActivityEditZonNameG4.activityEditZonNameG4);
        removeActivity(ActivitySendChargeG4.activitySendChargeG4);
        ///////////////////
textView=(TextView)findViewById(R.id.message);
        if (getIntent().getBooleanExtra("disconnect", false)) {

            textView.setText("اتصال قطع شد !!!");
        }

        if (getIntent().getBooleanExtra("close", false)) {
            removeActivity(ActivityMain.activityMain);

            textView.setText("اتصال قطع شد !!!\n"+"آژیر به صدا درآمد\n دراین حالت ارتباط بلوتوث قطع میشود\n");
        }
btnclose=(Button)findViewById(R.id.btnclose);
btnclose.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        finish();
    }
});
    }
    public void removeActivity(Activity activity){
        if (activity!=null){
            activity.finish();
        }
    }

    @Override
    public void onBackPressed() {

        finish();
        super.onBackPressed();
    }
}
