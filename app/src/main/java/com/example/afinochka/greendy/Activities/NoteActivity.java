package com.example.afinochka.greendy.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.afinochka.greendy.R;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);

        FrameLayout content = (FrameLayout) findViewById(R.id.content_layout);
        View wizard = getLayoutInflater().inflate(R.layout.activity_note, null);
        content.addView(wizard);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

    }
}
