package com.example.sensors;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class AmbientTemperature extends Activity implements SensorEventListener {
    private TextView textview4;
    private SensorManager sensorManager;
    private Sensor tempSensor;
    private Boolean isTempSensorAvailable;

    @Override
    protected void onCreate(Bundle SaveInstanceState) {

        super.onCreate(SaveInstanceState);
        setContentView(R.layout.ambient_temperature);

        textview4 = findViewById(R.id.textView4);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null)
           {
        tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
           isTempSensorAvailable = true;

            } else {
                textview4.setText("Ambient Temperature Sensor is Not Available");
                isTempSensorAvailable = false;
            }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            float temperature = event.values[1];
            textview4.setText(temperature + " °C");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (isTempSensorAvailable) {
            sensorManager.registerListener(this, tempSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isTempSensorAvailable) {
            sensorManager.unregisterListener(this);
        }
    }
}
