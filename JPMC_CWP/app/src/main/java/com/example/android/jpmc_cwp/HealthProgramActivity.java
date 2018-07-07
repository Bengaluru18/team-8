package com.example.android.jpmc_cwp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HealthProgramActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_program);
		db=openOrCreateDatabase("cwf.db",MODE_PRIVATE,null);
        db.execSQL("create table if not exists healthprogram(genaralCamp varchar(10),dentalCamp varchar(10),eyeCamp varchar(10),folic varchar(10),vitaminA varchar(10),deWorming varchar(10))");
        s1= (Spinner)findViewById(R.id.spinner);
        s2= (Spinner)findViewById(R.id.spinner2);
        s3= (Spinner)findViewById(R.id.spinner3);
        s4= (Spinner)findViewById(R.id.spinner4);
        s5= (Spinner)findViewById(R.id.spinner5);
        s6= (Spinner)findViewById(R.id.spinner6);
        b=(Button)findViewById(R.id.button);
        String[] items = new String[]{"Yes","No"};
        try {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,items);
            s1.setAdapter(adapter);
            s2.setAdapter(adapter);
            s3.setAdapter(adapter);
            s4.setAdapter(adapter);
            s5.setAdapter(adapter);
            s6.setAdapter(adapter);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //String s=s1.getSelectedItem().toString();

                    db.execSQL("insert into healthprogram values('" + s1.getSelectedItem().toString() + "','" + s2.getSelectedItem().toString() + "','" + s4.getSelectedItem().toString() + "','" + s5.getSelectedItem().toString() + "','" + s6.getSelectedItem().toString() + "','" + s3.getSelectedItem().toString() + "');");
                    Toast.makeText(getApplicationContext(),"succesfully inserted", Toast.LENGTH_LONG).show();
                }
            });
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();;
        }
    }
}
