package com.example.demo2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    public void clickFunction(View view) {

        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(imageView.getWindowToken(),0);

        EditText text1 = (EditText) findViewById(R.id.editText);
        EditText text2 = (EditText) findViewById(R.id.editText2);
        String username = text1.getText().toString();
        String password = text2.getText().toString();
        if(username.equals("test") && password.equals("test")) {
            Toast.makeText(this, "Welcome test", LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), welcome.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Wrong Username or password", LENGTH_LONG).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.animate().alpha(0.6f).setDuration(2000);
    }
}
