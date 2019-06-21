package com.example.demo2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;


public class House extends MainActivity {

    DatabaseHelper myDB ;
    ImageView imageView;
    TextView text2;
    Spinner spinner4;
    Spinner spinner5;

    public void goBack(View view) {
        Intent intent = new Intent(getApplicationContext(),welcome.class);
        startActivity(intent);
    }


    public void fetch(View view) {
        text2.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        String room = spinner5.getSelectedItem().toString();
        String furnish = spinner4.getSelectedItem().toString();
        Cursor res2 = myDB.finalData(room,furnish);
        if(res2.getCount() == 0) {
            text2.setText("Data Not Found");
        }
        else {
            StringBuffer buffer2 = new StringBuffer();
            while (res2.moveToNext()){
                buffer2.append("Location : " + res2.getString(0) + "\n");
                buffer2.append("Tenant : " + res2.getString(1) + "\n");
                buffer2.append("Type : " + res2.getString(2) + "\n");
                buffer2.append("Rooms : " + res2.getString(3) + "\n");
                buffer2.append("Status : " + res2.getString(4) + "\n\n");
            }
            text2.setText(buffer2.toString());
            text2.setMovementMethod(new ScrollingMovementMethod());

        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.house);
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.animate().alpha(0.6f).setDuration(2000);

        text2 = (TextView) findViewById(R.id.textView5);

        ArrayList<String> furnish = new ArrayList<String>();
        furnish.add("Full Furnished");
        furnish.add("Semi Furnished");
        furnish.add("Non Furnished");

        ArrayList<String> rooms = new ArrayList<String>();
        rooms.add("1BHK");
        rooms.add("2BHK");
        rooms.add("3BHK");

        spinner4 = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, furnish);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        spinner5 = (Spinner) findViewById(R.id.spinner5);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rooms);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);

        myDB = new DatabaseHelper(this);

    }
}
