package com.example.sensors;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

//THIS IS TO TRY THE CAPABILITIES OF SENSORS
public class SensorCapability extends Activity {

    private TextView textview2;
    private SensorManager sensorManager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle SaveInstanceState) {

        super.onCreate(SaveInstanceState);
        setContentView(R.layout.sensor_capability);

        textview2 = findViewById(R.id.textView2);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(android.hardware.Sensor.TYPE_MAGNETIC_FIELD);

        textview2.setText(String.valueOf(sensor.getPower()) + "\n" +
                String.valueOf(sensor.getVersion()) + "\n" +
                String.valueOf(sensor.getVendor()));

    }
}
