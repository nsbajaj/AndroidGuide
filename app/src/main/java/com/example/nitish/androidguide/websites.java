package com.example.nitish.androidguide;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;


public class websites extends ActionBarActivity {
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);

        listview();
        getLink();

    }
    private void listview() {
        String[] website = getResources().getStringArray(R.array.website);
        ListView listview = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> codeLearnArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, website);
        listview.setAdapter(codeLearnArrayAdapter);
    }
    private void getLink() {
        ListView listview = (ListView)findViewById(R.id.listView);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] website = getResources().getStringArray(R.array.website);
                String[] urls = getResources().getStringArray(R.array.urls);
                String input = (String) parent.getItemAtPosition(position);
                for(int i = 0; i < website.length; i++){
                    if(input.equals(website[i])){
                        Intent intent = new Intent(websites.this, browser.class);
                        String temp = urls[i];
                        intent.putExtra("url",temp);
                        startActivity(intent);
                        break;
                    }
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_websites, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
