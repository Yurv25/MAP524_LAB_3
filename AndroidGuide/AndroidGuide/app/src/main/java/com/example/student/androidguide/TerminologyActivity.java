package com.example.student.androidguide;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.AdapterView;

public class TerminologyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminology);

        String[] termino = getResources().getStringArray(R.array.terms_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, termino);
        AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.terminologies);
        //Set the number of characters the user must type before the drop down list is shown
        acTextView.setThreshold(3);
        //Set the adapter
        acTextView.setAdapter(adapter);

        showDefinition();
        /*String country=acTextView.getText().toString();
        final TextView  textViewSelected=(TextView)findViewById(R.id.termview);
        textViewSelected.setText("something "+ country );*/
    }

    public void showDefinition(){
        AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.terminologies);
        acTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                String [] definitions= getResources().getStringArray(R.array.def_array);
                TextView mytext = (TextView)findViewById(R.id.termview);
                TextView def = (TextView) viewClicked;
                String defi= def.getText().toString();
                if(defi.equals("adb")) {
                    mytext.setText(definitions[0]);
                }
                if(defi.equals("emulator")) {
                    mytext.setText(definitions[1]);
                }
                if(defi.equals("android")) {
                    mytext.setText(definitions[2]);
                }
                if(defi.equals("screenshot2")) {
                    mytext.setText(definitions[3]);
                }
                if(defi.equals("pm")) {
                    mytext.setText(definitions[4]);
                }
                if(defi.equals("lint")) {
                    mytext.setText(definitions[5]);
                }
                if(defi.equals("project")) {
                    mytext.setText(definitions[6]);
                }
                if(defi.equals("panel")) {
                    mytext.setText(definitions[7]);
                }
                if(defi.equals("Toolbar")) {
                    mytext.setText(definitions[8]);
                }
                if(defi.equals("Preview pane")) {
                    mytext.setText(definitions[9]);
                }
                if(defi.equals("Android pane")) {
                    mytext.setText(definitions[10]);
                }
                if(defi.equals("Project Explorer")) {
                    mytext.setText(definitions[11]);
                }
                if(defi.equals("idea folder")) {
                    mytext.setText(definitions[12]);
                }
                if(defi.equals("Intellesense")) {
                    mytext.setText(definitions[13]);
                }
                if(defi.equals("Module")) {
                    mytext.setText(definitions[14]);
                }
                if(defi.equals("Live layout")) {
                    mytext.setText(definitions[15]);
                }
                if(defi.equals("Init")) {
                    mytext.setText(definitions[16]);
                }
                if(defi.equals("commit")) {
                    mytext.setText(definitions[17]);
                }
                if(defi.equals("Push")) {
                    mytext.setText(definitions[18]);
                }
                if(defi.equals("Add")) {
                    mytext.setText(definitions[19]);
                }
                if(defi.equals("Pull")) {
                    mytext.setText(definitions[20]);
                }
                if(defi.equals("Branch")) {
                    mytext.setText(definitions[21]);
                }
                if(defi.equals("Clone")) {
                    mytext.setText(definitions[22]);
                }
            }
        });
     }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_terminology, menu);
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
