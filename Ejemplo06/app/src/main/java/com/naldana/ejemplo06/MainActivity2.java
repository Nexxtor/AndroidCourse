package com.naldana.ejemplo06;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private static final String OUTSIDE_COUNTER_KEY = "OUTSIDE_COUNTER_KEY";
    private static final String INSIDE_COUNTER_KEY = "INSIDE_COUNTER_KEY";
    TextView mDisplayOutside, mDisplayInside;
    Button mAddOutside, mAddInside;
    private int insideCounter = 0, outsideCounter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
        restoreCounters(savedInstanceState);
        bindEventsListeners();

    }

    private void restoreCounters(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            insideCounter = savedInstanceState.getInt(INSIDE_COUNTER_KEY, 0);
            insideCounter = savedInstanceState.getInt(INSIDE_COUNTER_KEY, 0);
            outsideCounter = savedInstanceState.getInt(OUTSIDE_COUNTER_KEY, 0);
            insideCounter = savedInstanceState.getInt(INSIDE_COUNTER_KEY, 0);

        }
    }

    private void bindEventsListeners() {
        mAddInside.setOnClickListener(v -> {
            insideCounter++;
            mDisplayInside.setText(insideCounter + "");
        });

        mAddOutside.setOnClickListener(v -> {
            outsideCounter++;
            mDisplayOutside.setText(outsideCounter + "");
        });
    }

    private void bindView() {
        mAddInside = findViewById(R.id.addInside);
        mAddOutside = findViewById(R.id.addOutside);

        mDisplayOutside = findViewById(R.id.displayOutside);
        mDisplayInside = findViewById(R.id.displayInside);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(OUTSIDE_COUNTER_KEY, outsideCounter);
        outState.putInt(INSIDE_COUNTER_KEY, insideCounter);
    }
}
