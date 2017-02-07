package com.k3ench.mygreetings;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
ImageButton b1,b2;
    Button ni;
  Button fab_plus;
    Animation  FabOpen,FabClose,FabRotate,FabAnti;
    boolean isOPen=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        b1=(ImageButton) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Birthday.class);
                startActivity(i);
            }
        });
        b2=(ImageButton) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Annevarsary.class);
                startActivity(i);
            }
        });
        ni=(Button) findViewById(R.id.button2);
        ni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(MainActivity.this,Admin1.class);
                startActivity(j);
            }
        });

    fab_plus = (Button) findViewById(R.id.button3);
                    fab_plus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {



                     Intent i=new Intent(MainActivity.this,Admin.class);
                     startActivity(i);


            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
           getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
               int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.i1) {
            // Handle the camera action
        } else if (id == R.id.i2) {

            Intent i=new Intent(MainActivity.this,Features.class);
            startActivity(i);
        } else if (id == R.id.i3) {

        } else if (id == R.id.i4) {
            Intent sendIntent=new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(sendIntent.EXTRA_TEXT,"I am happy with this app.Please click the link to download" +
                    " https://play.google.com/store/apps/details?id=com.askchitvish.activity.prem&hl=en");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.i5) {
            Intent intentm=new Intent(Intent.ACTION_SEND);
            intentm.setData(Uri.parse("mailto:"));
            String[ ] to={"appchitwish@gmail.com"};
            intentm.putExtra(Intent.EXTRA_EMAIL,to);
            intentm.putExtra(Intent.EXTRA_SUBJECT,"FeedBack");
            intentm.putExtra(Intent.EXTRA_TEXT,"");
            intentm.setType("message/rfc822");
            Intent chooser=null;
            chooser=Intent.createChooser(intentm,"send mail");
            startActivity(chooser);

        } else if (id == R.id.i6) {
            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("EXIT");
            builder.setMessage("Do you wnat to Exit?");
            builder.setCancelable(true);
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
finish();                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();               }
            });
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
            alertDialog.setTitle("Exit");
            alertDialog.setMessage("Are you sure to exit?");
            alertDialog.setCancelable(false);
            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Categories.super.onBackPressed();
                    finish();
                }
            });
            AlertDialog alert=alertDialog.create();
            alert.show();
        }
    }
}
