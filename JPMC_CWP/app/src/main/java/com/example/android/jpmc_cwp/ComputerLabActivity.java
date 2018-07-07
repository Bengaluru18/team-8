package com.example.android.jpmc_cwp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ComputerLabActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    SQLiteDatabase db;
    int DISE;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_lab);
        Intent intent = getIntent();
        DISE = intent.getIntExtra("DISE_Code",0);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        ed4=(EditText)findViewById(R.id.editText4);
        ed5=(EditText)findViewById(R.id.editText5);
        ed6=(EditText)findViewById(R.id.editText6);

        b1=(Button)findViewById(R.id.button);


        db=openOrCreateDatabase("cwf.db",MODE_PRIVATE,null);
        db.execSQL("create table if not exists computerlab(dise integer primary key,computers varchar(10),ups varchar(10), comptables varchar(10) , compchairs varchar(10), projector varchar(10), renovation varchar(50))");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("")||ed2.getText().toString().equals("") ||ed3.getText().toString().equals("")||ed4.getText().toString().equals("")||ed5.getText().toString().equals("")||ed6.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"You haven't entered details completely.",Toast.LENGTH_LONG).show();
                }
                else
                {
                    db.execSQL("insert into  computerlab values('"+ DISE + "','" + ed1.getText().toString()+"','"+ed2.getText().toString()+"', '"+ed3.getText().toString()+"', '"+ed4.getText().toString()+"', '"+ed5.getText().toString()+"', '"+ed6.getText().toString()+"');");
                    Toast.makeText(getApplicationContext(),"Inserted Computer Lab Details successfully",Toast.LENGTH_LONG).show();
                }
                startActivity(new Intent(ComputerLabActivity.this,Main2Activity.class));
            }
        });

    }
}
