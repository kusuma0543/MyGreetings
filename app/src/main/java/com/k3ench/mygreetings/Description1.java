package com.k3ench.mygreetings;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Description1 extends AppCompatActivity {

    EditText edi;
    ImageButton img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView myimage = (ImageView) findViewById(R.id.imageView);
        myimage.setImageResource(R.drawable.aniversary);
        edi = (EditText) findViewById(R.id.t4);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        Intent intent = getIntent();
        String tint = intent.getStringExtra("Partner_name");
        String tint1 = intent.getStringExtra("name");
        final String h="Real relationships are when you don’t have to pretend to be someone else, just to be liked for being someone you’re not. Happy anniversary.";
        edi.setText("Hi " + tint +" & "+ tint1 +" "+ h);


        img = (ImageButton) findViewById(R.id.btn1);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=edi.getText().toString();
                Bitmap bitmap;
                OutputStream output;
                bitmap = BitmapFactory.decodeResource(getResources(),
                        R.drawable.aniversary);
                File filepath = Environment.getExternalStorageDirectory();
                File dir = new File(filepath.getAbsolutePath() + "/Share Image Tutorial/");
                dir.mkdirs();
                File file = new File(dir, "aniversary.gif");
                try {
                    Intent share = new Intent(Intent.ACTION_SEND);
                    share.setAction(Intent.ACTION_SEND);

                    share.putExtra(share.EXTRA_TEXT, h);
                    share.putExtra(share.EXTRA_TEXT, n);
                    share.setType("text/plain");

                    share.setType("image/gif");
                    output = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
                    output.flush();
                    output.close();
                    Uri uri = Uri.fromFile(file);
                    share.putExtra(Intent.EXTRA_STREAM, uri);
                    startActivity(Intent.createChooser(share, "Share Image Tutorial"));
                    startActivity(share);
                } catch (Exception e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        Thread mythread = new Thread() {
            @Override
            public void run() {
                try {

                    sleep(1000000000);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        mythread.start();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



}


