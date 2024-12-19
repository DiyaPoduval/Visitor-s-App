package com.example.visitorapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Addvisitor extends AppCompatActivity {

    Button b5;
    EditText e1,e2,e3,e4;
    String getfn,getln,getp,getwtm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_addvisitor);


        b5=(Button)findViewById(R.id.menu);
        e1=(EditText)findViewById(R.id.fn);
        e2=(EditText)findViewById(R.id.ln);
        e3=(EditText)findViewById(R.id.p);
        e4=(EditText)findViewById(R.id.wtm);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfn=e1.getText().toString();
                getln=e2.getText().toString();
                getp= e3.getText().toString();
                getwtm=e4.getText().toString();

                Intent as=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(as);


                if(getfn.isEmpty()||getln.isEmpty()||getp.isEmpty()||getwtm.isEmpty()) {
            Toast.makeText(getApplication(), )
        }
        else
        {
            callApi();
        }
            
    }

    private void callApi() {
        String apiUrl="https://log-app-demo-api.onrender.com/addvisitor";
        JSONObject data=new JSONObject();
        try {
            data.put("firstname", getfn);
            data.put("lastname",getln);
            data.put("purpose",getp);
            data.put("whomToMeet",getwtm);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JsonObjectRequest request=new JsonObjectRequest(
                Request.Method.POST,
                apiUrl,
                data,
                Response -> Toast.makeText(getApplication(),"successfully added",Toast.LENGTH_LONG).show();
                error -> Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_LONG).show();
);
        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);

    }

}