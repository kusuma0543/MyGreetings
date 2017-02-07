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

public class Description extends AppCompatActivity {
    EditText edi;
    ImageButton img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView myimage = (ImageView) findViewById(R.id.imageView);
        myimage.setImageResource(R.drawable.bday1);
        edi = (EditText) findViewById(R.id.t4);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        Intent intent = getIntent();
        String tint = intent.getStringExtra("name");
        final String h=" Birthday is the time of celebration,I hope u have a wonderful day with loads of love  and surprises.May Your birthday gives you the best memories till the next one,may you have success waiting ahead";
        edi.setText("Hi " + tint + h);


        img = (ImageButton) findViewById(R.id.btn);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                String n=edi.getText().toString();


                Bitmap bitmap;
                OutputStream output;
                bitmap = BitmapFactory.decodeResource(getResources(),
                        R.drawable.bday1);
                File filepath = Environment.getExternalStorageDirectory();
                File dir = new File(filepath.getAbsolutePath() + "/Share Image Tutorial/");
                dir.mkdirs();
                File file = new File(dir, "bday1.gif");
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
