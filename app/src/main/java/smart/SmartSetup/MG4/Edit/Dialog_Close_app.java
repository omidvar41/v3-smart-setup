package smart.SmartSetup.MG4.Edit;

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
import smart.SmartSetup.MG4.About_System;
import smart.SmartSetup.MG4.ActivityChargeMG4;
import smart.SmartSetup.MG4.ActivityOutNameMG4;
import smart.SmartSetup.MG4.ActivityPanelMG4;
import smart.SmartSetup.MG4.ActivityPasswordMG4;
import smart.SmartSetup.MG4.ActivityPhoneNumberMG4;
import smart.SmartSetup.MG4.ActivityRemoteNameMG4;
import smart.SmartSetup.MG4.ActivitySmsNumberMG4;
import smart.SmartSetup.MG4.ActivityWlNameMG4;
import smart.SmartSetup.MG4.ActivityZonNameMG4;
import smart.SmartSetup.MG4.Activity_List_MG4;
import smart.SmartSetup.R;

public class Dialog_Close_app extends EnhancedActivity {

    TextView textView;
    Button btnclose;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog__close_app);
        removeActivity(ActivityEditChargeMG4.activityEditChargeMG4);
        removeActivity(ActivityEditOutNameMG4.activityEditOutNameMG4);
        removeActivity(ActivityEditpanelSettingMG4.activityEditpanelSettingMG4);
        removeActivity(ActivityEditPhoneNumberMG4.activityEditPhoneNumberMG4);
        removeActivity(ActivityEditRemotNameMG4.activityEditRemotNameMG4);
        removeActivity(ActivityEditSmsNumberMG4.activityEditSmsNumberMG4);
        removeActivity(ActivityEditTimeAlarmMG4.activityEditTimeAlarmMG4);
        removeActivity(ActivityEditTypeTrigMG4.activityEditTypeTrigMG4);
        removeActivity(ActivityEditWlNameMG4.activityEditWlNameMG4);
        removeActivity(ActivityEditZonNameMG4.activityEditZonNameMG4);
        removeActivity(ActivitySendShargeMG4.activitySendShargeMG4);
        removeActivity(Edit_Panel_Zon24.edit_panel_zon24);
        removeActivity(Progress_dialog_wait.progress_dialog_wait);
        removeActivity(Select_type_modelSim.select_type_modelSim);
        removeActivity(ActivivtyEditselectTypeCall.activivtyEditselectTypeCall);
        removeActivity(Dialog_save_Pass.dialog_save_pass);
        removeActivity(About_System.about_system);
        removeActivity(Activity_List_MG4.activity_list_MG4);
        removeActivity(ActivityChargeMG4.activityChargeMG4);
        removeActivity(ActivityOutNameMG4.activityOutNameMG4);
        removeActivity(ActivityPanelMG4.activityPanelMG4);
        removeActivity(ActivityPasswordMG4.activityPasswordMG4);
        removeActivity(ActivityPhoneNumberMG4.activityPhoneNumberMG4);
        removeActivity(ActivityRemoteNameMG4.activityRemoteNameMG4);
        removeActivity(ActivitySmsNumberMG4.activitySmsNumberMG4);
        removeActivity(ActivityWlNameMG4.activityWlNameMG4);
        removeActivity(ActivityZonNameMG4.activityZonNameMG4);
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
        removeActivity(ActivityWlNameMG4.activityWlNameMG4);
        removeActivity(ActivityZonNameG4.activityZonNameG4);
        removeActivity(select_type_sim.select_type_sim);



        removeActivity(ActivityEditChargeG4.activityEditChargeG4);
        removeActivity(ActivityEditOutNameG4.activityEditOutNameG4);

        removeActivity(ActivityEditPanelSettingG4.activityEditPanelSettingG4);
        removeActivity(ActivityEditPhoneNumberG4.activityEditPhoneNumberG4);
        removeActivity(ActivityEditRemotNameG4.activityEditRemotNameG4);
        removeActivity(ActivityEditSmsNumberG4.activityEditSmsNumberG4);
        removeActivity(ActivityEditTimeAlarmMG4.activityEditTimeAlarmMG4);
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
