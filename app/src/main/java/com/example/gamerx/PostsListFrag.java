package com.example.gamerx;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gamerx.Model.Model;
import com.example.gamerx.Model.Post;

import java.util.List;


public class PostsListFrag extends Fragment {
    List<Post> data;
    Button backBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_posts_list, container, false);

        data = Model.instance.getAllPosts();

        RecyclerView list = view.findViewById(R.id.posts_list_rv);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(getContext()));

        MyAdapter adapter = new MyAdapter();
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(new PostsListFrag.OnItemClickListener() {
            @Override
            public void onItemClick(View v ,int position) {
            }
        });
        ImageButton addBtn = view.findViewById(R.id.postlist_add_post);
        addBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_postsListFrag2_to_postDetailsFrag2));
        backBtn = view.findViewById(R.id.posts_back_button);
        backBtn.setOnClickListener((v)->{
            Navigation.findNavController(v).navigateUp();
        });
        return view;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titleTv;
        TextView infoTv;
        TextView postIdTv;

        public MyViewHolder(@NonNull View itemView, PostsListFrag.OnItemClickListener listener) {
            super(itemView);
            postIdTv = itemView.findViewById(R.id.row_post_id);
            titleTv = itemView.findViewById(R.id.row_title);
            infoTv = itemView.findViewById(R.id.row_post_info);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    listener.onItemClick(v,pos);
                }
            });
        }
    }
    interface OnItemClickListener{void onItemClick(View v,int position);}

    class MyAdapter extends RecyclerView.Adapter<PostsListFrag.MyViewHolder>{
        PostsListFrag.OnItemClickListener listener;
        public void setOnItemClickListener(PostsListFrag.OnItemClickListener listener){
            this.listener = listener;
        }
        @NonNull
        @Override
        public PostsListFrag.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.post_row,parent,false);
            MyViewHolder holder = new MyViewHolder(view,listener);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull PostsListFrag.MyViewHolder holder, int position) {
            Post post = data.get(position);
            holder.titleTv.setText(post.getTitle());
            holder.postIdTv.setText(post.getTtitleId());
            holder.infoTv.setText(post.getMbody());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}