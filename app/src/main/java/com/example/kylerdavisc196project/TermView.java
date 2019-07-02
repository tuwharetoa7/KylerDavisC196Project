package com.example.kylerdavisc196project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class TermView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        long termId = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent incomingIntent = getIntent();
        if(incomingIntent.hasExtra(TermDbHandler.TERM_ID)) {
            termId = Long.parseLong(incomingIntent.getStringExtra(TermDbHandler.TERM_ID));
        }
        System.out.println(termId);

    }

}
