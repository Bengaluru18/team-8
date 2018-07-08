

package com.example.android.jpmc_cwp;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;


public class HealthProgramActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    SQLiteDatabase db;
    int DISE;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_program);
        Intent intent = getIntent();
        DISE = intent.getIntExtra("DISE_Code",0);
        db=openOrCreateDatabase("cwf.db",MODE_PRIVATE,null);
        try
        {
            db.execSQL("create table if not exists healthprogram(Davailibility varchar(10),Drequirement varchar(10),Dnew varchar(10),Eavailibility varchar(10),Erequirement varchar(10),Enew varchar(10), dise integer primary key)");
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"table not created",Toast.LENGTH_SHORT).show();
        }
        ed1=(EditText)findViewById(R.id.editText5);
        ed2=(EditText)findViewById(R.id.editText6);
        ed3=(EditText)findViewById(R.id.editText7);
        ed4=(EditText)findViewById(R.id.editText4);
        ed5=(EditText)findViewById(R.id.editText8);
        ed6=(EditText)findViewById(R.id.editText9);

        b1=(Button)findViewById(R.id.button5);

        db=openOrCreateDatabase("cwf2.db",MODE_PRIVATE,null);
        db.execSQL("create table if not exists healthprogram(dise integer primary key,davailability varchar(10), drequirement varchar(10), dnew varchar(10) ,eavailability  varchar(10), erequiement varchar(10), enew varchar(10))");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("")||ed2.getText().toString().equals("") ||ed3.getText().toString().equals("")||ed4.getText().toString().equals("")||ed5.getText().toString().equals("")||ed6.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"You haven't entered details completely.",Toast.LENGTH_LONG).show();
                }
                else
                {
                    db.execSQL("insert into  library values('"+ DISE + "','"+ ed1.getText().toString()+"','"+ed2.getText().toString()+"', '"+ed3.getText().toString()+"', '"+ed4.getText().toString()+"', '"+ed5.getText().toString()+"', '"+ed6.getText().toString()+"');");
                    Toast.makeText(getApplicationContext(),"Inserted Library Details successfully",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(HealthProgramActivity.this,Main2Activity.class));
                }

            }
        });

    }

}