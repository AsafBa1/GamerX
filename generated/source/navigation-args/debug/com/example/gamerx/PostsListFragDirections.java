package com.example.gamerx;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class PostsListFragDirections {
  private PostsListFragDirections() {
  }

  @NonNull
  public static NavDirections actionPostsListFragToNewPost() {
    return new ActionOnlyNavDirections(R.id.action_postsListFrag_to_newPost);
  }

  @NonNull
  public static ActionPostsListFragToPostDetailsFrag actionPostsListFragToPostDetailsFrag(
      @NonNull String PostTitle, @NonNull String PostId, @NonNull String Postbody) {
    return new ActionPostsListFragToPostDetailsFrag(PostTitle, PostId, Postbody);
  }

  public static class ActionPostsListFragToPostDetailsFrag implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionPostsListFragToPostDetailsFrag(@NonNull String PostTitle, @NonNull String PostId,
        @NonNull String Postbody) {
      if (PostTitle == null) {
        throw new IllegalArgumentException("Argument \"PostTitle\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("PostTitle", PostTitle);
      if (PostId == null) {
        throw new IllegalArgumentException("Argument \"PostId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("PostId", PostId);
      if (Postbody == null) {
        throw new IllegalArgumentException("Argument \"Postbody\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("Postbody", Postbody);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionPostsListFragToPostDetailsFrag setPostTitle(@NonNull String PostTitle) {
      if (PostTitle == null) {
        throw new IllegalArgumentException("Argument \"PostTitle\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("PostTitle", PostTitle);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionPostsListFragToPostDetailsFrag setPostId(@NonNull String PostId) {
      if (PostId == null) {
        throw new IllegalArgumentException("Argument \"PostId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("PostId", PostId);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionPostsListFragToPostDetailsFrag setPostbody(@NonNull String Postbody) {
      if (Postbody == null) {
        throw new IllegalArgumentException("Argument \"Postbody\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("Postbody", Postbody);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("PostTitle")) {
        String PostTitle = (String) arguments.get("PostTitle");
        __result.putString("PostTitle", PostTitle);
      }
      if (arguments.containsKey("PostId")) {
        String PostId = (String) arguments.get("PostId");
        __result.putString("PostId", PostId);
      }
      if (arguments.containsKey("Postbody")) {
        String Postbody = (String) arguments.get("Postbody");
        __result.putString("Postbody", Postbody);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_postsListFrag_to_postDetailsFrag;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getPostTitle() {
      return (String) arguments.get("PostTitle");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getPostId() {
      return (String) arguments.get("PostId");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getPostbody() {
      return (String) arguments.get("Postbody");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionPostsListFragToPostDetailsFrag that = (ActionPostsListFragToPostDetailsFrag) object;
      if (arguments.containsKey("PostTitle") != that.arguments.containsKey("PostTitle")) {
        return false;
      }
      if (getPostTitle() != null ? !getPostTitle().equals(that.getPostTitle()) : that.getPostTitle() != null) {
        return false;
      }
      if (arguments.containsKey("PostId") != that.arguments.containsKey("PostId")) {
        return false;
      }
      if (getPostId() != null ? !getPostId().equals(that.getPostId()) : that.getPostId() != null) {
        return false;
      }
      if (arguments.containsKey("Postbody") != that.arguments.containsKey("Postbody")) {
        return false;
      }
      if (getPostbody() != null ? !getPostbody().equals(that.getPostbody()) : that.getPostbody() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getPostTitle() != null ? getPostTitle().hashCode() : 0);
      result = 31 * result + (getPostId() != null ? getPostId().hashCode() : 0);
      result = 31 * result + (getPostbody() != null ? getPostbody().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionPostsListFragToPostDetailsFrag(actionId=" + getActionId() + "){"
          + "PostTitle=" + getPostTitle()
          + ", PostId=" + getPostId()
          + ", Postbody=" + getPostbody()
          + "}";
    }
  }
}
