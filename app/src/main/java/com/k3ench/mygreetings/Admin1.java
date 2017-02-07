package com.k3ench.mygreetings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import static android.R.attr.id;

public class Admin1 extends AppCompatActivity {
    EditText ec, th;
    String s1, s2;
    ImageButton n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ec = (EditText) findViewById(R.id.ed);
        th = (EditText) findViewById(R.id.ed1);
        n = (ImageButton) findViewById(R.id.bn);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ec.getText().toString().equals("") &&  th.getText().toString().equals("")) {
                    Toast.makeText(Admin1.this, "please enter either one detail ", Toast.LENGTH_SHORT).show();
                } else {
                    s1 = ec.getText().toString();
                    s2 = th.getText().toString();
                    delete(s1, s2);
                    Toast.makeText(Admin1.this, "DELETED SUCCESSFULLY!!!", Toast.LENGTH_SHORT).show();

                }

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void delete(final String s1, final String s2) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://kusuma0543.tk/dele.php", new Response.Listener<String>() {
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
                //params.put("id", s1);
               // params.put("name", s2);
                params.get(id);
                return params;
            }
        };
        Demo.getInstance().addToRequestQueue(stringRequest);
    }

}
