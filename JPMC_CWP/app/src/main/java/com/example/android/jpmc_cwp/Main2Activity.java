package com.example.android.jpmc_cwp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    int DISE;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b = (Button) findViewById(R.id.button);
        Intent intent = getIntent();
        if(intent.getExtras()==null)
        {
            DISE = 0;
        }
        else
        {
            DISE = intent.getIntExtra("DISE_Code",0);
        }
    }
        public void btn(View v) {
            switch(v.getId()){
                case R.id.button:
                    startActivity(new Intent(Main2Activity.this, SchoolProfileActivity.class));
                    break;
                case R.id.button2:
                    startActivity(new Intent(Main2Activity.this, HealthProgramActivity.class).putExtra("DISE_Code",DISE));
                    break;
                case R.id.button3:
                    startActivity(new Intent(Main2Activity.this, ComputerLabActivity.class).putExtra("DISE_Code",DISE));
                    break;
                case R.id.button4:
                    startActivity(new Intent(Main2Activity.this, SchoolEnvironmentActivity.class).putExtra("DISE_Code",DISE));
                    break;
                case R.id.button5:
                    startActivity(new Intent(Main2Activity.this, SanitationActivity.class).putExtra("DISE_Code",DISE));
                    break;
                case R.id.button6:
                    startActivity(new Intent(Main2Activity.this, LibraryActivity.class).putExtra("DISE_Code",DISE));
                    break;



            }
}}
