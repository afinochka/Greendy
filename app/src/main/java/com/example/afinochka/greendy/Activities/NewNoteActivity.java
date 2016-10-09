package com.example.afinochka.greendy.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.example.afinochka.greendy.R;

public class NewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);

        FrameLayout content = (FrameLayout) findViewById(R.id.content_layout);
        View wizard = getLayoutInflater().inflate(R.layout.activity_new_note, null);

        content.addView(wizard);

    }
}
