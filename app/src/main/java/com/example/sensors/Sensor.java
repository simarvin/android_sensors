package com.example.sensors;

import android.app.Activity;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;


public class Sensor extends Activity {
    private TextView textview;
    private SensorManager sensorManager;
    private List<android.hardware.Sensor> deviceSensors;
    @Override
     protected void onCreate(Bundle SaveInstanceState) {

        super.onCreate(SaveInstanceState);
        setContentView(R.layout.layout_sensor);

        textview = findViewById(R.id.textView);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        deviceSensors = sensorManager.getSensorList(android.hardware.Sensor.TYPE_ALL);

//        textview.setText(deviceSensors.toString());

//        printSensors();
        specificSensor();
    }

    private void specificSensor() {
        if(sensorManager.getDefaultSensor(android.hardware.Sensor.TYPE_MAGNETIC_FIELD) != null){
            textview.setText("This device has a magnetic field sensor");
        }else{
            textview.setText("this device does not have this specific sensor feature");
        }
    }

//    private void printSensors() {
//        for(android.hardware.Sensor sensor : deviceSensors){
//            textview.setText(textview.getText()+"\n" + sensor.getName());
//        }
//    }
}
