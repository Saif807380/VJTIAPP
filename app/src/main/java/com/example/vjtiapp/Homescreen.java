package com.example.vjtiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.ImageButton;

public class Homescreen extends AppCompatActivity {

    Button profile,events,map,academics;
    String branch,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        profile = findViewById(R.id.profile);
        events = findViewById(R.id.events);
        map = findViewById(R.id.map);
        academics = findViewById(R.id.academics);

        events.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        event();
                    }
                }
        );


        profile.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Homescreen.this,EditProfile.class));
                    }
                }
        );


        map.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        map();
                    }
                }
        );

        academics.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        branch = new GetStudentDetails().getBranch();
                        year = new GetStudentDetails().getYear();
                        startActivity(new Intent(Homescreen.this,FileManager.class));
                    }
                }
        );


    }

    private void event(){
        Intent event_activity = new Intent(this,Event.class);
        startActivity(event_activity);


    }

    private void map(){
        Intent map_activity = new Intent(this,Map.class);
        startActivity(map_activity);

    }


}
