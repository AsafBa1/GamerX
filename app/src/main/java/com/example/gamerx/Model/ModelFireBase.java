package com.example.gamerx.Model;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ModelFireBase {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void ModelFirebase(){
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(false)
                .build();
        db.setFirestoreSettings(settings);
    }

    public interface GetAllPostsListener{
        void onComplete(List<Post> list);
    }

    public void getAllPosts(Long lastUpdateDate, GetAllPostsListener listener){
            db.collection(Post.COLLECTION_NAME)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            List<Post> list = new LinkedList<Post>();
                            if(task.isSuccessful()){
                               for(QueryDocumentSnapshot doc : task.getResult()){
                                   Post post = Post.create(doc.getData());
                                   if(post != null){
                                       list.add(post);
                                   }
                               }
                            }
                            listener.onComplete(list);
                        }

                    });

    }

    public void addPost(Post post,Model.AddPostListener listener){
        Map<String, Object> json = post.toJson();
        db.collection(Post.COLLECTION_NAME)
                .document(post.getTtitleId())
                .set(json)
                .addOnSuccessListener(unused -> listener.onComplete())
                .addOnFailureListener(e -> listener.onComplete());
    }

    public void getPostById(String postTitleId, Model.GetPostById listener) {
        db.collection(Post.COLLECTION_NAME)
                .document(postTitleId)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        Post post = null;
                        if(task.isSuccessful() & task.getResult() != null){
                           post = Post.create(task.getResult().getData());
                        }
                        listener.onComplete(post);

                    }

                });
    }

    public void editPost(Post post){

    }

    public void addUser(User user, Model.AddUserListener listener){
       Map<String, Object> json = user.toJson();
        db.collection(User.COLLECTION_NAME)
                .document(User.getUserId())
                .set(json)
                .addOnSuccessListener(unused -> listener.onComplete())
                .addOnFailureListener(e -> listener.onComplete());

    }
}
