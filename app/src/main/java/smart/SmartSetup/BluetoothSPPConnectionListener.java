package smart.SmartSetup;

/**
 * Created by Roholah on 30/06/2017.
 */

public interface BluetoothSPPConnectionListener {

    public void bluetoothWrite(int bytes, byte[] buffer);
    public void onConnecting();
    public void onConnected();
    public void onConnectionFailed();
    public void onConnectionLost();
}
