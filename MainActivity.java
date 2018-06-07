package com.tylerfishbone.wifitoggler;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    TextView statusMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = (ToggleButton) findViewById(R.id.button_toggleWifi);

        statusMessage = (TextView) findViewById(R.id.text_statusMessage);

//        if (toggleButton.isChecked()) {
//            statusMessage.setText("Wifi is on");
//        } else {
//            statusMessage.setText("Wifi is off");
//        }


        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {
                if (checked){
                    statusMessage.setText("Wifi is on");
//                    toggleButton.setTextOn("Turn Wifi Off");
                    WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(true);
                } else {
                    statusMessage.setText(("Wifi is off"));
//                    toggleButton.setTextOff("Turn Wifi On");
                    WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(false);
                }
            }
        });

//        if (toggleButton.isChecked()) {
//            statusMessage.setText("Wifi is ON");
//            WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//            wifi.setWifiEnabled(true);
//        } else {
//            statusMessage.setText("Wifi is off");
//            WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//            wifi.setWifiEnabled(false);
//        }



    }
}
