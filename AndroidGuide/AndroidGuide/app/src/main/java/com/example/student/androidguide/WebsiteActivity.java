package com.example.student.androidguide;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;


public class WebsiteActivity extends ActionBarActivity {
       private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);
        populateList();
        accessWebsite();
    }

    public void populateList(){
        String[] webs = getResources().getStringArray(R.array.webs_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, webs);

        ListView list = (ListView) findViewById(R.id.listViewWebsites);
        list.setAdapter(adapter);
    }

    public void accessWebsite(){
        final ListView list = (ListView) findViewById(R.id.listViewWebsites);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id){
                TextView url = (TextView) viewClicked;
                webView = (WebView) findViewById(R.id.websites);
                webView.setWebViewClient(new MyWebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(url.getText().toString());
            }
        });
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_website, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){

            case R.id.action_about :
                Intent inte = new Intent(this,AboutActivity.class);
                startActivity(inte);
                return true;
            case R.id.action_help:
                Intent inte1 = new Intent(this,HelpActivity.class);
                startActivity(inte1);
                return true;


        }

        return super.onOptionsItemSelected(item);
    }
}
