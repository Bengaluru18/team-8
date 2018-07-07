package com.example.android.jpmc_cwp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class SchoolProfileActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Button mSubmit;
    String schoolName, schoolAddress, schoolLocality, schoolMedium, schoolState, totalClasses, schoolGender;
    int DISE, totalStudents, totalTeachers;
    EditText editName, editAddress, editState, editTotalStudents, editSchoolDISE, editTotalTeachers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = openOrCreateDatabase("cwf.db",MODE_PRIVATE,null);
        db.execSQL("create table if not exists schoolprofile(name varchar(30),locality varchar(30),address varchar(150), state varchar(30), totalclasses varchar(20), gender varchar(10), mediumofinstruction varchar(20), totalstudents integer, dise integer primary key, totalteachers integer)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_profile);
//        ActionBar ab = getActionBar();
//        ab.setTitle(R.string.school_profile);
        mSubmit = (Button) findViewById(R.id.submit);
        //get the spinner from the xml.
        final Spinner locality = (Spinner) findViewById(R.id.spinnerLocality);
        //create a list of items for the spinner.
        String[] localityItems = new String[]{"Rural", "Urban", "Tribal"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> localityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, localityItems);
        //set the spinners adapter to the previously created one.
        locality.setAdapter(localityAdapter);

        final Spinner gender = (Spinner) findViewById(R.id.spinnerGender);
        String[] genderItems = new String[]{"Male", "Female", "Co-Ed"};
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, genderItems);
        gender.setAdapter(genderAdapter);

        final Spinner spinnerTotalClasses = (Spinner) findViewById(R.id.spinnerTotalClasses);
        String[] totalClassesItems = new String[]{"LPS (Lower Primary) 1-5th Std", "HPS (Higher Primary) 1-7th Std", "HPS (Higher Primary) 1-8th Std"};
        ArrayAdapter<String> totalClassesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, totalClassesItems);
        spinnerTotalClasses.setAdapter(totalClassesAdapter);

        final Spinner medium = (Spinner) findViewById(R.id.spinnerMedium);
        String[] mediumItems = new String[]{"Kannada", "English"};
        ArrayAdapter<String> mediumAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mediumItems);
        medium.setAdapter(mediumAdapter);

        editName = (EditText) findViewById(R.id.editName);
        editAddress = (EditText) findViewById(R.id.editAddress);
        editState = (EditText) findViewById(R.id.editState);
        editTotalStudents = (EditText) findViewById(R.id.editTotalStudents);
        editTotalTeachers = (EditText) findViewById(R.id.editTotalTeachers);
        editSchoolDISE = (EditText) findViewById((R.id.editSchoolDISE));

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                schoolName = editName.getText().toString();
                schoolAddress = editAddress.getText().toString();
                schoolState = editState.getText().toString();
                totalStudents = Integer.parseInt(editTotalStudents.getText().toString());
                totalTeachers = Integer.parseInt(editTotalTeachers.getText().toString());
                DISE = Integer.parseInt(editSchoolDISE.getText().toString());
                schoolLocality = locality.getSelectedItem().toString();
                schoolMedium = medium.getSelectedItem().toString();
                totalClasses = spinnerTotalClasses.getSelectedItem().toString();
                schoolGender = gender.getSelectedItem().toString();
                Log.e("School Profile",schoolName+schoolAddress+schoolState+totalStudents+totalTeachers+DISE+schoolLocality+schoolMedium+totalClasses+schoolGender);
                db.execSQL("insert into schoolprofile values('" + schoolName + "','" + schoolLocality + "','" + schoolAddress  + "','" +  schoolState  + "','" +  totalClasses  + "','" +  schoolGender  + "','" +  schoolMedium  + "','" +  totalStudents  + "','" +  DISE  + "','" +  totalTeachers + "')");

                Intent i = new Intent(SchoolProfileActivity.this,Main2Activity.class);
                i.putExtra("DISE_Code",DISE);
                startActivity(i);

            }
        });
    }
}
