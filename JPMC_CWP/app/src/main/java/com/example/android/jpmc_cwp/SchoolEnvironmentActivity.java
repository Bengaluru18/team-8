package com.example.android.jpmc_cwp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SchoolEnvironmentActivity extends AppCompatActivity {
    int DISE;
    SQLiteDatabase db;
    public Button mSubmit;
    public String rooms[] = {"Classroom/Office","Staff Room","Computer Lab","Store Room","Kitchen"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_environment);
        Intent intent = getIntent();
        DISE = intent.getIntExtra("DISE_Code",0);
        db = openOrCreateDatabase("cwf.db",MODE_PRIVATE,null);
        db.execSQL("create table if not exists schoolenvironmentrooms(id integer primary key autoincrement, room varchar(20) )");
        mSubmit = (Button) findViewById(R.id.submit);
        db.execSQL("create table if not exists schoolenvironmentdetails(id integer primary key autoincrement, roomno integer, totalno integer, flooring varchar(50), plastering varchar(50), waterproofing varchar(50), renovation varchar(50))");
        final EditText classRoom = (EditText) findViewById(R.id.classRoom);
        final EditText classTotal = (EditText) findViewById(R.id.classTotal);
        final EditText classFlooring = (EditText) findViewById(R.id.classFlooring);
        final EditText classPlastering = (EditText) findViewById(R.id.classPlastering);
        final EditText classWaterproofing = (EditText) findViewById(R.id.classWaterproofing);
        final EditText classRenovation = (EditText) findViewById(R.id.classRenovation);

        final EditText staffRoom = (EditText) findViewById(R.id.staffRoom);
        final EditText staffTotal = (EditText) findViewById(R.id.staffTotal);
        final EditText staffFlooring = (EditText) findViewById(R.id.staffFlooring);
        final EditText staffPlastering = (EditText) findViewById(R.id.staffPlastering);
        final EditText staffWaterproofing = (EditText) findViewById(R.id.staffWaterproofing);
        final EditText staffRenovation = (EditText) findViewById(R.id.staffRenovation);

        final EditText computerRoom = (EditText) findViewById(R.id.computerRoom);
        final EditText computerTotal = (EditText) findViewById(R.id.computerTotal);
        final EditText computerFlooring = (EditText) findViewById(R.id.computerFlooring);
        final EditText computerPlastering = (EditText) findViewById(R.id.computerPlastering);
        final EditText computerWaterproofing = (EditText) findViewById(R.id.computerWaterproofing);
        final EditText computerRenovation = (EditText) findViewById(R.id.computerRenovation);

        final EditText storeRoom = (EditText) findViewById(R.id.storeRoom);
        final EditText storeTotal = (EditText) findViewById(R.id.storeTotal);
        final EditText storeFlooring = (EditText) findViewById(R.id.storeFlooring);
        final EditText storePlastering = (EditText) findViewById(R.id.storePlastering);
        final EditText storeWaterproofing = (EditText) findViewById(R.id.storeWaterproofing);
        final EditText storeRenovation = (EditText) findViewById(R.id.storeRenovation);

        final EditText kitchenRoom = (EditText) findViewById(R.id.kitchenRoom);
        final EditText kitchenTotal = (EditText) findViewById(R.id.kitchenTotal);
        final EditText kitchenFlooring = (EditText) findViewById(R.id.kitchenFlooring);
        final EditText kitchenPlastering = (EditText) findViewById(R.id.kitchenPlastering);
        final EditText kitchenWaterproofing = (EditText) findViewById(R.id.kitchenWaterproofing);
        final EditText kitchenRenovation = (EditText) findViewById(R.id.kitchenRenovation);


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<5;i++)
                    db.execSQL("insert into schoolenvironmentrooms values('" + i + "','" + rooms[i] + "')");

                db.execSQL("insert into schoolenvironmentdetails values('" + 0 + "','" + Integer.parseInt(classRoom.getText().toString()) + "','" + Integer.parseInt(classTotal.getText().toString()) + "','" + classFlooring.getText().toString() + "','" + classPlastering.getText().toString() + "','" + classWaterproofing.getText().toString() + "','" + classRenovation.getText().toString() +"')");
                db.execSQL("insert into schoolenvironmentdetails values('" + 1 + "','" + Integer.parseInt(staffRoom.getText().toString()) + "','" + Integer.parseInt(staffTotal.getText().toString()) + "','" + staffFlooring.getText().toString() + "','" + staffPlastering.getText().toString() + "','" + staffWaterproofing.getText().toString() + "','" + staffRenovation.getText().toString() +"')");
                db.execSQL("insert into schoolenvironmentdetails values('" + 2 + "','" + Integer.parseInt(computerRoom.getText().toString()) + "','" + Integer.parseInt(computerTotal.getText().toString()) + "','" + computerFlooring.getText().toString() + "','" + computerPlastering.getText().toString() + "','" + computerWaterproofing.getText().toString() + "','" + computerRenovation.getText().toString() +"')");
                db.execSQL("insert into schoolenvironmentdetails values('" + 3 + "','" + Integer.parseInt(storeRoom.getText().toString()) + "','" + Integer.parseInt(storeTotal.getText().toString()) + "','" + storeFlooring.getText().toString() + "','" + storePlastering.getText().toString() + "','" + storeWaterproofing.getText().toString() + "','" + storeRenovation.getText().toString() +"')");
                db.execSQL("insert into schoolenvironmentdetails values('" + 4 + "','" + Integer.parseInt(kitchenRoom.getText().toString()) + "','" + Integer.parseInt(kitchenTotal.getText().toString()) + "','" + kitchenFlooring.getText().toString() + "','" + kitchenPlastering.getText().toString() + "','" + kitchenWaterproofing.getText().toString() + "','" + kitchenRenovation.getText().toString() +"')");
                startActivity(new Intent(SchoolEnvironmentActivity.this,Main2Activity.class));
            }
        });
    }

}
