package com.example.demo2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class welcome extends  House{
    ImageView imageView;
    Spinner spinner;
    Spinner spinner2;
    Spinner spinner3;
    DatabaseHelper myDB;
    TextView text;


    public void goBack(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void nextslide (View view) {
        Intent intent = new Intent(getApplicationContext(), House.class);
        startActivity(intent);
    }

    public void searchItem(View view) {

        text.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        String city = spinner.getSelectedItem().toString();
        String tenant = spinner2.getSelectedItem().toString();
        String house = spinner3.getSelectedItem().toString();
        Cursor res = myDB.searchData(city, tenant, house);
        if (res.getCount() == 0) {
            text.setText("Data Not Found");
        } else {
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                buffer.append("Location : " + res.getString(0) + "\n");
                buffer.append("Tenant : " + res.getString(1) + "\n");
                buffer.append("Type : " + res.getString(2) + "\n");
                buffer.append("Rooms : " + res.getString(3) + "\n");
                buffer.append("Status : " + res.getString(4) + "\n\n");
            }
            text.setText(buffer.toString());
            text.setMovementMethod(new ScrollingMovementMethod());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.animate().alpha(0.6f).setDuration(2000);
        text = (TextView) findViewById(R.id.textView6);

        ArrayList<String> Locations = new ArrayList<String>();
        Locations.add("Delhi");
        Locations.add("Bangalore");
        Locations.add("Mumbai");

        ArrayList<String> Tenant = new ArrayList<String>();
        Tenant.add("Any");
        Tenant.add("Boy");
        Tenant.add("Girl");
        Tenant.add("Family");

        ArrayList<String> House = new ArrayList<String>();
        House.add("Private Room");
        House.add("Shared Room");
        House.add("Full House");

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Locations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Tenant);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, House);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        myDB = new DatabaseHelper(this);
        myDB.insertData();

    }

}

