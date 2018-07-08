package com.example.android.jpmc_cwp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SanitationActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    int DISE;
    SQLiteDatabase db;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanitation);
        Intent intent = getIntent();
        DISE = intent.getIntExtra("DISE_Code",0);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        ed4=(EditText)findViewById(R.id.editText4);
        ed5=(EditText)findViewById(R.id.editText5);
        ed6=(EditText)findViewById(R.id.editText6);

        b1=(Button)findViewById(R.id.button);



        db=openOrCreateDatabase("cwf2.db",MODE_PRIVATE,null);
        db.execSQL("create table if not exists sanitary(dise integer primary key,toiletb varchar(10),urinalb varchar(10), toiletg varchar(10) , urinalg varchar(10), toiletcw varchar(10), toiletst varchar(50))");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("")||ed2.getText().toString().equals("") ||ed3.getText().toString().equals("")||ed4.getText().toString().equals("")||ed5.getText().toString().equals("")||ed6.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"You haven't entered details completely.",Toast.LENGTH_LONG).show();
                }
                else
                {
                    db.execSQL("insert into  sanitary values('"+ 100+"','"+ed1.getText().toString()+"','"+ed2.getText().toString()+"', '"+ed3.getText().toString()+"', '"+ed4.getText().toString()+"'," +
                            " '"+ed5.getText().toString()+"', '"+ed6.getText().toString()+"');");
                   String str = "";
                    Cursor cursor = db.rawQuery("SELECT * FROM sanitary", null);
                if(cursor.moveToFirst())
                {
                    do {
                        str += "dise  : " +cursor.getString(0) + "\n" +"toiletb : "+ cursor.getString(1) + "\n" + "urinalb  : "+cursor.getString(2) + "\n" +"toiletg  : "+ cursor.getString(3) + "\n" +"urinalg  : "+ cursor.getString(4) + "\n" +"toiletcw  : "+ cursor.getString(5) + "\n" +"toiletst  : "+cursor.getString(6);

                    }while (cursor.moveToNext());

                    Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
               //    String str = "Details are \n";
                 //   Cursor c=db.rawQuery("select * from sanitary ",null);
                   // while (c.moveToNext()) {
                     //   str+= c.getString(0) + "\n" + c.getString(1) + "\n" +c.getString(2) + "\n" + c.getString(3) + "\n" +c.getString(4) + "\n" + c.getString(5) + "\n";
                    }

            //  Toast.makeText(getApplicationContext(),"Inserted Computer Lab Details successfully",Toast.LENGTH_LONG).show();
                //    Intent i = new Intent(SanitationActivity.this,Main2Activity.class);
                  //  startActivity(i);


                }

            }
        });
    }
}


