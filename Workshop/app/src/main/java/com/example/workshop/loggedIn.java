package com.example.workshop;

import static com.example.workshop.R.*;
import static com.example.workshop.R.drawable.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class loggedIn extends AppCompatActivity {

    SeekBar seekBar11;
    RatingBar ratingBar;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_logged_in);
        seekBar11=findViewById(id.seekBar1);
        ratingBar=findViewById(id.ratingBar);
        seekBar11.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                flag=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "FLAG"+flag, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ConstraintLayout constraintLayout=findViewById(id.constraint);
        switch (item.getItemId()) {
            case(R.id.m416):
                constraintLayout.setBackgroundResource(img);
                return true;
            case(R.id.groza):
                constraintLayout.setBackgroundResource(img_1);
                return true;
            case(R.id.dp28):
                constraintLayout.setBackgroundResource(img_2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void getStars(View view){
        int stars=ratingBar.getNumStars();
        Toast.makeText(getApplicationContext(), "STARS"+stars, Toast.LENGTH_SHORT).show();
    }
    public void nextFunc(View view){
        Intent intent=new Intent(loggedIn.this,timePicker.class);
        startActivity(intent);
        Toast.makeText(this.getApplicationContext(), "Entered In Time Picker", Toast.LENGTH_SHORT).show();
    }

}