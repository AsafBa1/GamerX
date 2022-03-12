package com.example.gamerx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gamerx.Model.Model;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  MyAdapter adapter = new MyAdapter();
   ListView list = findViewById(R.id.post_lists);
    list.setAdapter(adapter);


    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.post_row,null);
            }
            TextView PostTitle = convertView.findViewById(R.id.row_title);
            TextView PostInfo = convertView.findViewById(R.id.row_post_info);

            PostTitle.setText("name" + position);
            PostInfo.setText("name" + position);
            return convertView;
        }
    }

}