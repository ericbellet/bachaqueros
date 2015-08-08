package com.ati.damlabs.dam_lab_android_2.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ati.damlabs.dam_lab_android_2.R;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listOnClick(View v) {
        Intent i = new Intent(this, ListActivity.class);

        startActivity(i);
    }

    public void localOnClick(View v) {
        Intent i = new Intent(this, LoginActivity.class);

        startActivity(i);
    }
}
