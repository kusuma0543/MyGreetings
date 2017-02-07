package com.k3ench.mygreetings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Features extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView =(TextView)findViewById(R.id.te2);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    String text = "<p align=\"justify\"><br><font color=\"black\"># Simple and easy importing of birthdays.<br>" +
            "# Contacts are shown with pictures, in case you have 1000 friends on Facebook.<br>" +
            "# Shows remaining days till birthday.</font></p>"+
            "            <p><font color=\"black\"># A seamless and smooth interface.<br>" +
            "# Main page has good management implemented.<br>" +
            "# Available in multiple languages.</font></p><br>" +
            "            <font color=\"black\"> # Easy import from social media.<br>" +
            "# The app doesn’t have ads, a great plus in my book.<br>" +
            "# Set the time for the reminders.</font><br><br><br>" +
            "              <h4><u><font color=\"black\">             Reviews</font></u><h4><br>";
    String text1="<h4><a href='http://www.playstore.com'><font color=\"red\">Playstore</font></a>";
    textView.setText(Html.fromHtml(text+text1));
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
}

}