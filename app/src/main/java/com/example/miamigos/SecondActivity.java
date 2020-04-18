package com.example.miamigos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView name,number,date;

    String data1,data2,data3;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.mainImageView);
        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        date = findViewById(R.id.date);

        getData();
        setData();
    }

    private void getData() {
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1")
                && getIntent().hasExtra("data2")) {
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");
            myImage = getIntent().getIntExtra("myImage",1);
        } else {
            Toast.makeText(this,"No data.",Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        name.setText(data1);
        number.setText("Phone number: " + data2);
        date.setText("Birthday: " + data3);
        mainImageView.setImageResource(myImage);
    }

}
