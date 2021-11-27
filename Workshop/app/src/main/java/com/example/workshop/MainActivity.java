package com.example.workshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.editTextTextEmailAddress);
        pass=findViewById(R.id.editTextTextPassword);
    }
    public void loginClicked(View view){
        if(email.getText().toString().equals("KONI")&&pass.getText().toString().equals("KONI")) {
            Intent intent=new Intent(MainActivity.this,loggedIn.class);
            startActivity(intent);
            Toast.makeText(this.getApplicationContext(), "Authenticated", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this.getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
    }
}