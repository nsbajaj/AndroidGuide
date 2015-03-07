package com.example.nitish.androidguide;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.button_1);
        Button b2 = (Button) findViewById(R.id.button_2);

        final Intent myIntent1 = new Intent(this, terminology.class);
        final Intent myIntent2 = new Intent(this, websites.class);

        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(myIntent1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(myIntent2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Overflow Menu
        RelativeLayout main_view = (RelativeLayout) findViewById(R.id.main_view);

        switch(item.getItemId()){
            case R.id.menu_help:
                if(item.isChecked()){
                    item.setChecked(false);
                }
                else{
                    item.setChecked(true);
                    final Intent myIntentHelp = new Intent(this, help.class);
                    startActivity(myIntentHelp);
                    return true;
                }
            case R.id.menu_about:
                if(item.isChecked()){
                    item.setChecked(false);
                }
                else{
                    item.setChecked(true);
                    final Intent myIntentAbout = new Intent(this, about.class);
                    startActivity(myIntentAbout);
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
