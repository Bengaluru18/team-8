package com.example.android.jpmc_cwp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SchoolEnvironmentActivity extends AppCompatActivity {
    int DISE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        DISE = intent.getIntExtra("DISE_Code",0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_environment);
    }
}
