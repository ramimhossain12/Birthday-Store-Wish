package com.example.birthdaystoreapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SingleBday extends AppCompatActivity {


    EditText e;
    Button b, d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_bday);
        e = (EditText) findViewById(R.id.edittext);
        b = (Button) findViewById(R.id.updatedatabase);
        d = (Button) findViewById(R.id.delete_data);


        final int rec_pos = getIntent().getIntExtra("MyKEY", 999);

        final MyDBFunction obj = new MyDBFunction(getApplicationContext());

        e.setText(obj.fetch_day(rec_pos+1));
        e.setSelection(e.getText().length());


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                obj.update_birthday((rec_pos+1), e.getText().toString());
                Toast.makeText(SingleBday.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();


            }
        });


        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj.delete_bday(obj.fetch_day(rec_pos+1));
                Toast.makeText(getApplicationContext(), "Deleted Successfully!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
