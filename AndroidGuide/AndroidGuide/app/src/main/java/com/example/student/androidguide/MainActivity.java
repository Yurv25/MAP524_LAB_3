package com.example.student.androidguide;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
        addListenerOnButton1();
    }

    public void addListenerOnButton() {
        button = (Button) findViewById(R.id.buttonter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                btnTerminology();
            }

        });
    }

    public void addListenerOnButton1() {
        button = (Button) findViewById(R.id.buttonweb);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                btnWebsite();
            }

        });
    }
    public void btnTerminology(){
        final Intent inte2 = new Intent(this, TerminologyActivity.class);
        startActivity(inte2);
    }

    public void btnWebsite(){
        final Intent inten = new Intent(this, WebsiteActivity.class);
        startActivity(inten);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
