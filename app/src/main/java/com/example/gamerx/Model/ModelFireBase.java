package com.example.gamerx.Model;

import android.graphics.Bitmap;
import android.net.Uri;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ModelFireBase {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseStorage storage = FirebaseStorage.getInstance();


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
                    .whereGreaterThanOrEqualTo("updateDate",new Timestamp(lastUpdateDate,0))
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
                        Post student = null;
                        if (task.isSuccessful() & task.getResult()!= null){
                            student = Post.create(task.getResult().getData());
                        }
                        listener.onComplete(student);
                    }
                });
    }

    public void editPost(Post post, Model.EditPostListener listener){

    }

    public void addUser(User user, Model.AddUserListener listener){
       Map<String, Object> json = user.toJson();
        db.collection(User.COLLECTION_NAME)
                .document(user.getUserId())
                .set(json)
                .addOnSuccessListener(unused -> listener.onComplete())
                .addOnFailureListener(e -> listener.onComplete());

    }
    /**
     * Firebase Storage
     */



    public void savePostImage(Bitmap imageBitmap, String imageName, Model.SaveImageListener listener) {
        StorageReference storageRef = storage.getReference();
        StorageReference imgRef = storageRef.child("/Posts/" + imageName);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        UploadTask uploadTask = imgRef.putBytes(data);
        uploadTask.addOnFailureListener(exception -> listener.onComplete(null))
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        imgRef.getDownloadUrl().addOnSuccessListener(uri -> {
                            Uri downloadUrl = uri;
                            listener.onComplete(downloadUrl.toString());
                        });
                    }
                });

    }

    public void saveUserImage(Bitmap imageBitmap, String imageName, Model.SaveImageListener listener) {
        StorageReference storageRef = storage.getReference();
        StorageReference imgRef = storageRef.child("/UserProfile/" + imageName);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        UploadTask uploadTask = imgRef.putBytes(data);
        uploadTask.addOnFailureListener(exception -> listener.onComplete(null))
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        imgRef.getDownloadUrl().addOnSuccessListener(uri -> {
                            Uri downloadUrl = uri;
                            listener.onComplete(downloadUrl.toString());
                        });
                    }
                });

    }
    /**
     * Authentication
     */
    public boolean isSignedIn() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            getLoggedUser(currentUser.getEmail());
            return true;
        } else {
            return false;
        }
    }

    private void getLoggedUser(String email) {
       // db.collection("users").document(username).get().addOnCompleteListener(task -> {
          //  if (task.isSuccessful()) {
           //     String Name = (String) task.getResult().getData().get("name");
            //    String Email = (String) task.getResult().getData().get("email");
              //  String Id = (String) task.getResult().getData().get("Id");
              //  String Address = (String) task.getResult().getData().get("address");
               // String Phonenumber = (String) task.getResult().getData().get("phoneNumber");
               // String avatarUrl = (String)task.getResult().getData().get("avatarUrl");
               // User user = new User(Name, Email, Id, Address, Phonenumber,avatarUrl);
               // Model.instance.setLoggedUser(user);
         //   }
      //  });
    }
}
