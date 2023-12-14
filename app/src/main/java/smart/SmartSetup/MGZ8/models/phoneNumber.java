package smart.SmartSetup.MGZ8.models;

import java.io.Serializable;

public class phoneNumber implements Serializable {
    String numMemory,number,
            smsControlP1,smsControlP2,smsControlExit,

         EnDisP1,EnDisP2,AlarmP1,AlarmP2,CommonArea,TwoArea,SystemReports,
    ElectCity,aux,cutVoice,cutPhone,

    misCallControl,voiceCallP1,voiceCallP2;

    public String getElectCity() {
        return ElectCity;
    }

    public void setElectCity(String electCity) {
        ElectCity = electCity;
    }

    public String getAux() {
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }

    public String getCutVoice() {
        return cutVoice;
    }

    public void setCutVoice(String cutVoice) {
        this.cutVoice = cutVoice;
    }

    public String getCutPhone() {
        return cutPhone;
    }

    public void setCutPhone(String cutPhone) {
        this.cutPhone = cutPhone;
    }

    public String getNumMemory() {
        return numMemory;
    }

    public void setNumMemory(String numMemory) {
        this.numMemory = numMemory;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSmsControlP1() {
        return smsControlP1;
    }

    public void setSmsControlP1(String smsControlP1) {
        this.smsControlP1 = smsControlP1;
    }

    public String getSmsControlP2() {
        return smsControlP2;
    }

    public void setSmsControlP2(String smsControlP2) {
        this.smsControlP2 = smsControlP2;
    }

    public String getSmsControlExit() {
        return smsControlExit;
    }

    public void setSmsControlExit(String smsControlExit) {
        this.smsControlExit = smsControlExit;
    }

    public String getEnDisP1() {
        return EnDisP1;
    }

    public void setEnDisP1(String enDisP1) {
        EnDisP1 = enDisP1;
    }

    public String getEnDisP2() {
        return EnDisP2;
    }

    public void setEnDisP2(String enDisP2) {
        EnDisP2 = enDisP2;
    }

    public String getAlarmP1() {
        return AlarmP1;
    }

    public void setAlarmP1(String alarmP1) {
        AlarmP1 = alarmP1;
    }

    public String getAlarmP2() {
        return AlarmP2;
    }

    public void setAlarmP2(String alarmP2) {
        AlarmP2 = alarmP2;
    }

    public String getCommonArea() {
        return CommonArea;
    }

    public void setCommonArea(String commonArea) {
        CommonArea = commonArea;
    }

    public String getTwoArea() {
        return TwoArea;
    }

    public void setTwoArea(String twoArea) {
        TwoArea = twoArea;
    }

    public String getSystemReports() {
        return SystemReports;
    }

    public void setSystemReports(String systemReports) {
        SystemReports = systemReports;
    }

    public String getMisCallControl() {
        return misCallControl;
    }

    public void setMisCallControl(String misCallControl) {
        this.misCallControl = misCallControl;
    }

    public String getVoiceCallP1() {
        return voiceCallP1;
    }

    public void setVoiceCallP1(String voiceCallP1) {
        this.voiceCallP1 = voiceCallP1;
    }

    public String getVoiceCallP2() {
        return voiceCallP2;
    }

    public void setVoiceCallP2(String voiceCallP2) {
        this.voiceCallP2 = voiceCallP2;
    }
}
