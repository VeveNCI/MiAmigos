package com.example.miamigos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    private Button addingButton;
    String new_amigo_name,new_amigo_number,new_amigo_date;
    EditText nameEditText;
    EditText numberEditText;
    EditText dateEditText;
    //Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        nameEditText = findViewById(R.id.nameEditText);
        numberEditText = findViewById(R.id.numberEditText);
        dateEditText = findViewById(R.id.dateEditText);
        addingButton = findViewById(R.id.newAmigo);

        addAmigo(addingButton);
    }

    public void addAmigo(View view) {
        /*
        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText numberEditText = findViewById(R.id.numberEditText);
        EditText dateEditText = findViewById(R.id.dateEditText);
        */
        new_amigo_name = nameEditText.getText().toString();
        new_amigo_number = numberEditText.getText().toString();
        new_amigo_date = dateEditText.getText().toString();

        addingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                new_amigo_name = nameEditText.getText().toString();
                new_amigo_number = numberEditText.getText().toString();
                new_amigo_date = dateEditText.getText().toString();
                */
                Intent intent = new Intent(ThirdActivity.this,MainActivity.class);
                intent.putExtra("new1",new_amigo_name);
                intent.putExtra("new2",new_amigo_number);
                intent.putExtra("new3",new_amigo_date);
                //startActivity(intent);
                finish();
            }
        });
    }
}
