package com.example.miamigos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[] = new String[10],data2[] = new String[10],data3[] = new String[10];
    ArrayList<String> data1_temp = new ArrayList<String>(Arrays.asList(data1));
    ArrayList<String> data2_temp = new ArrayList<String>(Arrays.asList(data2));
    ArrayList<String> data3_temp = new ArrayList<String>(Arrays.asList(data3));
    //String data2[],data3[];
    //ArrayList<String> data1 = new ArrayList<String>();
    int images[];
    Context context;
    ImageView mDeleteAmigo;

    public MyAdapter(Context ct,String amigos_list[],String numbers_list[],String dates_list[],int img[]){
    //public MyAdapter(Context ct, ArrayList<String> amigos_list,String numbers_list[],String dates_list[],int img[]) {
        context = ct;
        data1 = amigos_list;
        data2 = numbers_list;
        data3 = dates_list;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myText3.setText(data3[position]);
        holder.myImage.setImageResource(images[position]);
        mDeleteAmigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //data1_temp.remove(position);
                //data1 = data1_temp.toArray(data1);
                Intent deleteRow = new Intent(context,MainActivity.class);
                deleteRow.putExtra("position",position);
                context.startActivity(deleteRow);
            }
        });
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,SecondActivity.class);
                intent.putExtra("data1",data1[position]);
                intent.putExtra("data2",data2[position]);
                intent.putExtra("data3",data3[position]);
                intent.putExtra("myImage",images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data2.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText1,myText2,myText3;
        ImageView myImage;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.amigo_name);
            myText2 = itemView.findViewById(R.id.amigo_number);
            myText3 = itemView.findViewById(R.id.amigo_date);
            myImage = itemView.findViewById(R.id.myImageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            mDeleteAmigo = itemView.findViewById(R.id.deleteAmigo);
        }
    }
}
