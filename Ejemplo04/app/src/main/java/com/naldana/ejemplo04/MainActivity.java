package com.naldana.ejemplo04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    Button mContactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContactButton = findViewById(R.id.bt_contact);

        mContactButton.setOnClickListener( v -> {
            Intent intent = new Intent(this,
                    SecondActivity.class);
            startActivity(intent);
        });
    }
}
