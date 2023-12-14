package smart.SmartSetup;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

/**
 * Created by Roholah on 30/06/2017.
 */

public class ActivityDeviceList1 extends EnhancedActivity {
    public static String         EXTRA_DEVICE_ADDRESS = "device_address";
    boolean flag=true;
            String dviceName,dviceName2,dviceName3,defaulDevicetName;
    ListView newDevicesListView;

    private ArrayAdapter<String> mNewDevicesArrayAdapter;
    ArrayList<String> deviceAddress        = new ArrayList<String>();

    private BluetoothAdapter mBtAdapter;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_device_list);
        setTitleColor(Color.BLACK);

        // Set result CANCELED incase the user backs out
        setResult(Activity.RESULT_CANCELED);

        Animation animation = AnimationUtils.loadAnimation(ActivityDeviceList1.this, R.anim.animation2);
        final ListView listView = (ListView) findViewById(R.id.new_devices);
        listView.startAnimation(animation);

        //........................................................... Initialize the button to perform device discovery


        mNewDevicesArrayAdapter = new ArrayAdapter<String>(this, R.layout.bt_device_name);


        newDevicesListView = (ListView) findViewById(R.id.new_devices);
        newDevicesListView.setAdapter(mNewDevicesArrayAdapter);

        newDevicesListView.setOnItemClickListener(mDeviceClickListener);
        ///.............................................................................................................

        // Register for broadcasts when a device is discovered
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        this.registerReceiver(mReceiver, filter);

        // Register for broadcasts when discovery has finished
        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        this.registerReceiver(mReceiver, filter);
        ///.............................................................................................................

        // Get the local Bluetooth adapter
         mBtAdapter = BluetoothAdapter.getDefaultAdapter();



        doDiscovery();










        final Thread thread=new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(14000);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                            ActivityCompat.checkSelfPermission(getApplicationContext(),
                                    Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {

                        requestPermissions(new String[]{Manifest.permission.BLUETOOTH_SCAN,Manifest.permission.BLUETOOTH_CONNECT},
                                49);



                        return;
                    }

                String name = mNewDevicesArrayAdapter.getItem(0);
                    if (name.equals(getString(R.string.device_1)) || name.equals(getString(R.string.device_2))
                    || name.equals(getString(R.string.device_3)) ) {
                        mBtAdapter.cancelDiscovery();


                        String address = deviceAddress.get(0);

                        Intent intent = new Intent();
                        intent.putExtra(EXTRA_DEVICE_ADDRESS, address);

                        setResult(Activity.RESULT_OK, intent);
                        finish();


                    }

                    //گرفتن دیفالت نیم نسخه جدید
                    if (name.equals(getString(R.string.default_name))) {
                        mBtAdapter.cancelDiscovery();


                        String address = deviceAddress.get(0);

                        Intent intent = new Intent();
                        intent.putExtra(EXTRA_DEVICE_ADDRESS, address);

                        setResult(G.ResultCodeDefaultNameDevice, intent);
                        finish();


                    }



                    if(!name.equals(getString(R.string.device_1))){
                        mBtAdapter.cancelDiscovery();
                        Intent intent = new Intent();
                        intent.putExtra("Subject", "notdevice");
                        setResult(Activity.RESULT_CANCELED, intent);
                        ActivityDeviceList1.this.finish();
                    }

            } catch (Exception e) {
                // e.printStackTrace();
                    finish();
             }


            }


        });
        thread.start();


}



    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        // Make sure we're not doing discovery anymore
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{Manifest.permission.BLUETOOTH_SCAN,Manifest.permission.BLUETOOTH_CONNECT},
                    49);



            return;
        }


        if (mBtAdapter != null)
        {
            mBtAdapter.cancelDiscovery();
        }
        // Unregister broadcast listeners
        this.unregisterReceiver(mReceiver);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }


    /**
     * Start device discover with the BluetoothAdapter
     */
    private void doDiscovery() {
        setTitleColor(Color.BLACK);

        // Indicate scanning in the title
      // setProgressBarIndeterminateVisibility(true);
        setTitle(R.string.scanning);
        // Turn on sub-title for new devices
        //    findViewById(R.id.title_new_devices).setVisibility(View.VISIBLE);

        // If we're already discovering, stop it
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {

             requestPermissions(new String[]{Manifest.permission.BLUETOOTH_SCAN,Manifest.permission.BLUETOOTH_CONNECT},
                    49);



            return;
        }


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
              requestPermissions(
                        new String[]{Manifest.permission.BLUETOOTH_CONNECT
                        }, 49);

            }






        if (mBtAdapter.isDiscovering()) {
            mBtAdapter.cancelDiscovery();
        }

        // Request discover from BluetoothAdapter
        mBtAdapter.startDiscovery();
    }

    // The on-click listener for all devices in the ListViews
    private AdapterView.OnItemClickListener mDeviceClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> av, View v, int arg2, long arg3) {
            // Cancel discovery because it's costly and we're about to connect
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                    ActivityCompat.checkSelfPermission(getApplicationContext(),
                            Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{Manifest.permission.BLUETOOTH_SCAN,Manifest.permission.BLUETOOTH_CONNECT},
                        49);



                return;
            }

            mBtAdapter.cancelDiscovery();

            // Get the device MAC address, which is the last 17 chars in the View
            // String info = ((TextView) v).getText().toString();
            // String address = info.substring(info.length() - 17);

            ///////////////////////////////////////////////////////////////
            //  String info = ((TextView) v).geti
            String address = deviceAddress.get(arg2);
//Toast.makeText(ActivityDeviceList1.this,""+arg2+"",Toast.LENGTH_LONG).show();
            ///////////////////////////////////////////////////////////////

            // Create the result Intent and include the MAC address
            Intent intent = new Intent();
            intent.putExtra(EXTRA_DEVICE_ADDRESS, address);

            // Set result and finish this Activity
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    };

    // The BroadcastReceiver that listens for discovered devices and
    // changes the title when discovery is finished
    private final BroadcastReceiver mReceiver            = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            ProgressBar progressBar=(ProgressBar)findViewById(R.id.progress);
            // When discovery finds a device
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Get the BluetoothDevice object from the Intent
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                        ActivityCompat.checkSelfPermission(getApplicationContext(),
                                Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {

                    requestPermissions(new String[]{Manifest.permission.BLUETOOTH_SCAN,Manifest.permission.BLUETOOTH_CONNECT},
                            49);



                    return;
                }


                String name = device.getName();
                try {
                    if (name != null &&
                            name.equals(getString(R.string.device_1)) || name.equals(getString(R.string.device_2))
                            || name.equals(getString(R.string.device_3)) ||
                            name.equals(getString(R.string.default_name))){
                        setTitle("در حال اتصال به دستگاه...");
                        setTitleColor(Color.BLACK);

                        mBtAdapter.cancelDiscovery();
                        dviceName=getString(R.string.device_1);
                        dviceName2=getString(R.string.device_2);
                        dviceName3=getString(R.string.device_3);
                        defaulDevicetName=getString(R.string.default_name);
                        deviceAddress.add(device.getAddress());
                        mNewDevicesArrayAdapter.add(name);

                    }
                }catch (Exception e){
                    Toast.makeText(context, "دستگاه یافت نشد", Toast.LENGTH_SHORT).show();
                }


            }
            else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
              //  setProgressBarIndeterminateVisibility(false);
              if (mNewDevicesArrayAdapter.getCount() == 0) {
                    String noDevices = getResources().getText(R.string.none_found).toString();
                    mNewDevicesArrayAdapter.add(noDevices);


                }


            }



        }
    };





}
