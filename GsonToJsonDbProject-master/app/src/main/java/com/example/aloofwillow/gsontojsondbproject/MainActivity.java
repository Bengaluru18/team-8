package com.example.aloofwillow.gsontojsondbproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> addList=new ArrayList<>();
        addList.add("Bangalore");
        addList.add("Tumkur");
        addList.add("Ranchi");

        //initialize your object with form data
        FormData formData=new FormData("ashank",21,addList);

        //convert object into json
        Gson gson=new Gson();
        String jsonString=gson.toJson(formData);
        Log.i("json",jsonString);

        //pass link of the website and jsonString here
//       new DownloadTask().execute("http://localhost/server2.php",jsonString);
     JsonArrayRequest jsonObjectRequest = new JsonArrayRequest("http://localhost/server2.php", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                // Do something with response
                //mTextView.setText(response.toString());

                // Process the JSON
                try{
                    // Loop through the array elements
                    System.out.println("Hello");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        // Do something when error occurred
                        System.out.println("asdasdasdasdasdassdsa");;
                    }
                });
    }
}
