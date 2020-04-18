package com.example.miamigos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addAmigoButton;
    RecyclerView recyclerView;
    String new1,new2,new3;
    int position_temp,img_temp[];
    //Context context;

    String amigos_list[] = {"Carlos Fuentes","Francisco Rodrigues","Juan Polco","Manuel Mercedes","Martin Clapos",
            "Rafael Dali","Ricardo Milos","Rosa Kovalsky","Silvia Gates","Veronica Zucc"},
            numbers_list[] = {"837827394","928374657","273948273","192837492","910251928",
            "392810923","391820394","710293841","192039182","819209381"},
            dates_list[] = {"01.10.2000","12.10.1992","02.04.1998","02.03.2007","08.11.2001",
            "21.03.1999","09.08.2002","01.09.2000","17.02.1990","30.10.2010"};
    //String numbers_list[],dates_list[];
    ArrayList<String> amigos_list_temp = new ArrayList<String>(Arrays.asList(amigos_list));
    ArrayList<String> numbers_list_temp = new ArrayList<String>(Arrays.asList(numbers_list));
    ArrayList<String> dates_list_temp = new ArrayList<String>(Arrays.asList(dates_list));

    int images[] = {R.drawable.avatar_1,R.drawable.avatar_2,R.drawable.avatar_3,R.drawable.avatar_4,
            R.drawable.avatar_5,R.drawable.avatar_6,R.drawable.ic_ricardo,R.drawable.avatar_8,
            R.drawable.avatar_9,R.drawable.avatar_10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addAmigoButton = findViewById(R.id.addAmigoButton);

        recyclerView = findViewById(R.id.recyclerView);
        //-------------------- TEST BATTLEFIELD ----------------------
        //amigos_list = getResources().getStringArray(R.array.amigos_name);
        //Log.d("Let's check how amigos_list look inside: ", "amigos_list: " + amigos_list);
        //System.out.println("amigos_list: " + amigos_list);
        /*
        amigos_list_temp.remove(0);
        amigos_list_temp.add();
        amigos_list_temp.add();
        amigos_list_temp.add();
        amigos_list_temp.add();
        amigos_list_temp.add();
        amigos_list_temp.add();
        amigos_list_temp.add();
        amigos_list_temp.add();
        amigos_list_temp.add();
        amigos_list_temp.add();
         */
        //Log.d("Let's check what's inside amigos_list_temp: ", "amigos_list: " + Arrays.toString(amigos_list));
        //Log.d("Let's check what's inside amigos_list: ", "amigos_list: " + Arrays.toString(amigos_list));
        /*
        numbers_list_temp.remove(0);
        numbers_list_temp.add("728437298");
        numbers_list_temp.add("987435973");
        numbers_list_temp.add("874357836");
        numbers_list_temp.add("827387583");
        numbers_list_temp.add("238573745");
        numbers_list_temp.add("287463568");
        numbers_list_temp.add("235743599");
        numbers_list_temp.add("875874788");
        numbers_list_temp.add("827346585");
        numbers_list_temp.add("835647865");
        */
        //numbers_list = getResources().getStringArray(R.array.amigos_number);
        //dates_list = getResources().getStringArray(R.array.amigos_birthdate);
        /*
        dates_list_temp.remove(0);
        dates_list_temp.add("17.02.1997");
        dates_list_temp.add("04.09.2001");
        dates_list_temp.add("05.03.2000");
        dates_list_temp.add("23.01.1990");
        dates_list_temp.add("27.11.2002");
        dates_list_temp.add("13.04.1996");
        dates_list_temp.add("10.10.2010");
        dates_list_temp.add("30.03.2000");
        dates_list_temp.add("06.06.2006");
        dates_list_temp.add("18.11.2018");
        */
        //---------------------- END OF THE TEST BATTLEFIELD -----------------------------
        amigos_list = amigos_list_temp.toArray(amigos_list);
        numbers_list = numbers_list_temp.toArray(numbers_list);
        dates_list = dates_list_temp.toArray(dates_list);

        getAmigo();
        deleteAmigo();

        addAmigoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
        //img_temp = images;
        MyAdapter myAdapter = new MyAdapter(this,amigos_list,numbers_list,dates_list,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void getAmigo() {
        if(getIntent().hasExtra("new1") && getIntent().hasExtra("new2")
                && getIntent().hasExtra("new3")) {
            new1 = getIntent().getStringExtra("new1");
            new2 = getIntent().getStringExtra("new2");
            new3 = getIntent().getStringExtra("new3");
            amigos_list_temp.add(new1);
            amigos_list = amigos_list_temp.toArray(amigos_list);
            numbers_list_temp.add(new2);
            numbers_list = numbers_list_temp.toArray(numbers_list);
            dates_list_temp.add(new3);
            dates_list = dates_list_temp.toArray(dates_list);
            //Intent restartActivity = new Intent(MainActivity.this,MainActivity.class);
            //startActivity(restartActivity);
        } else {
            Toast.makeText(this,"No new data.",Toast.LENGTH_SHORT).show();
        }
    }
    private void deleteAmigo() {
        if(getIntent().hasExtra("position")) {
            position_temp = getIntent().getIntExtra("position", 1);
            amigos_list_temp.remove(position_temp);
            numbers_list_temp.remove(position_temp);
            dates_list_temp.remove(position_temp);
            img_temp = new int[images.length - 1];
            for(int i = 0, k = 0; i < images.length; i++)
            {
                if(i == position_temp) continue;
                img_temp[k++] = images[i];
            }
            images = img_temp;
            amigos_list = amigos_list_temp.toArray(amigos_list);
            numbers_list = numbers_list_temp.toArray(numbers_list);
            dates_list = dates_list_temp.toArray(dates_list);
            //Intent restartActivity = new Intent(MainActivity.this,MainActivity.class);
            //startActivity(restartActivity);
        } else {
            Toast.makeText(this,"No data to delete", Toast.LENGTH_SHORT).show();
        }
    }
}
