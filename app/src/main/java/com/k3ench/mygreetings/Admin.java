package com.k3ench.mygreetings;

import android.app.DatePickerDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Admin extends AppCompatActivity {

    EditText e1, e2,e3,e4,e5,e6;
    Button b1,dob,dom;
    String s1, s2,s3,s4,s5,s6;
    int mYear,mMonth,mDay;
        MediaPlayer mp;
    String url="http://kusuma0543.tk/wishes.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });
        e1 = (EditText) findViewById(R.id.Name);
        e2 = (EditText) findViewById(R.id.email);
        e3 = (EditText) findViewById(R.id.phno);
        e4 = (EditText) findViewById(R.id.dob);
        e5 = (EditText) findViewById(R.id.dom);
        e6 = (EditText) findViewById(R.id.partnername);
mp=MediaPlayer.create(this, R.raw.at);
        b1=(Button) findViewById(R.id.btn1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (e1.getText().toString().equals("") && e2.getText().toString().equals("") && e3.getText().toString().equals("") && e4.getText().toString().equals("")) {
                    Toast.makeText(Admin.this, "Please enter some details", Toast.LENGTH_SHORT).show();
                } else {
                    s1 = e1.getText().toString();
                    s2 = e2.getText().toString();
                    s3 = e3.getText().toString();
                    s4 = e4.getText().toString();
                    s5 = e5.getText().toString();
                    s6 = e6.getText().toString();
                    mp.start();
                    insertme(s1, s2, s3, s4, s5, s6);
                    Toast.makeText(Admin.this, "THANK YOU!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dob=(Button) findViewById(R.id.btn2);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datepic();}
        });
        dom=(Button) findViewById(R.id.btn3);
        dom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datepics();}
        });
    }
    public void datepic() {
        final Calendar c=Calendar.getInstance();
        mYear=c.get(Calendar.YEAR);
        mMonth=c.get(Calendar.MONTH);
        mDay=c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog=new DatePickerDialog(Admin.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                e4.setText(dayOfMonth+"/"+month+"/"+year);
            }
        },mDay,mMonth,mYear);
        datePickerDialog.show();
    }
    public void datepics() {
        final Calendar c=Calendar.getInstance();
        mYear=c.get(Calendar.YEAR);
        mMonth=c.get(Calendar.MONTH);
        mDay=c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog=new DatePickerDialog(Admin.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                e5.setText(dayOfMonth+"/"+month+"/"+year);
            }
        },mDay,mMonth,mYear);
        datePickerDialog.show();
    }
    public void insertme(final String s1, final String s2,final String s3,final String s4,final String s5,final String s6) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AllUrl.url, new Response.Listener<String>() {
            public void onResponse(String response) {
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            { }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("na", s1);
                params.put("ji", s2);
                params.put("bo",s3);
                params.put("va",s4);
                params.put("la",s5);
                params.put("pa",s6);
                return params;
            }
        };
        Demo.getInstance().addToRequestQueue(stringRequest);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}