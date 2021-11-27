package com.example.workshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class timePicker extends AppCompatActivity {

    EditText editText,phno,msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        editText=findViewById(R.id.editTextTextPersonName);
        phno=findViewById(R.id.editTextTextPersonName2);
        msg=findViewById(R.id.editTextTextPersonName3);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Calendar Opened", Toast.LENGTH_SHORT).show();
                Calendar calendar=Calendar.getInstance();
                int Hour=calendar.get(Calendar.HOUR_OF_DAY);
                int min=calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog=new TimePickerDialog(timePicker.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        editText.setText(hourOfDay+":"+minute);
                    }
                },Hour,min,true);
                timePickerDialog.setTitle("PICK TIME");
                timePickerDialog.show();
            }
        });
    }
    public void sendMessage(View view){
        try {
            SmsManager smgr=SmsManager.getDefault();
            smgr.sendTextMessage(phno.getText().toString(),null,msg.getText().toString(),null,null);
            Toast.makeText(timePicker.this, "SMS Sent", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(timePicker.this, "SMS Failed", Toast.LENGTH_SHORT).show();
        }
    }
}