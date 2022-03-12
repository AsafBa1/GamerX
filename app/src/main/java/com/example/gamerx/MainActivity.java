package com.example.gamerx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gamerx.Model.Model;
import com.example.gamerx.Model.Post;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Post> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = Model.instance.getAllPosts();
        RecyclerView list = findViewById(R.id.posts_list_rv);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));


    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titleTv;
        TextView infoTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.row_title);
            infoTv = itemView.findViewById(R.id.row_post_info);
        }
    }
    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.post_row,parent,false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

}