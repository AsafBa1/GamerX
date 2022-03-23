package com.example.gamerx;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class PostDetailsFragArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private PostDetailsFragArgs() {
  }

  @SuppressWarnings("unchecked")
  private PostDetailsFragArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static PostDetailsFragArgs fromBundle(@NonNull Bundle bundle) {
    PostDetailsFragArgs __result = new PostDetailsFragArgs();
    bundle.setClassLoader(PostDetailsFragArgs.class.getClassLoader());
    if (bundle.containsKey("PostTitle")) {
      String PostTitle;
      PostTitle = bundle.getString("PostTitle");
      if (PostTitle == null) {
        throw new IllegalArgumentException("Argument \"PostTitle\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("PostTitle", PostTitle);
    } else {
      throw new IllegalArgumentException("Required argument \"PostTitle\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("PostId")) {
      String PostId;
      PostId = bundle.getString("PostId");
      if (PostId == null) {
        throw new IllegalArgumentException("Argument \"PostId\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("PostId", PostId);
    } else {
      throw new IllegalArgumentException("Required argument \"PostId\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("Postbody")) {
      String Postbody;
      Postbody = bundle.getString("Postbody");
      if (Postbody == null) {
        throw new IllegalArgumentException("Argument \"Postbody\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("Postbody", Postbody);
    } else {
      throw new IllegalArgumentException("Required argument \"Postbody\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static PostDetailsFragArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    PostDetailsFragArgs __result = new PostDetailsFragArgs();
    if (savedStateHandle.contains("PostTitle")) {
      String PostTitle;
      PostTitle = savedStateHandle.get("PostTitle");
      if (PostTitle == null) {
        throw new IllegalArgumentException("Argument \"PostTitle\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("PostTitle", PostTitle);
    } else {
      throw new IllegalArgumentException("Required argument \"PostTitle\" is missing and does not have an android:defaultValue");
    }
    if (savedStateHandle.contains("PostId")) {
      String PostId;
      PostId = savedStateHandle.get("PostId");
      if (PostId == null) {
        throw new IllegalArgumentException("Argument \"PostId\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("PostId", PostId);
    } else {
      throw new IllegalArgumentException("Required argument \"PostId\" is missing and does not have an android:defaultValue");
    }
    if (savedStateHandle.contains("Postbody")) {
      String Postbody;
      Postbody = savedStateHandle.get("Postbody");
      if (Postbody == null) {
        throw new IllegalArgumentException("Argument \"Postbody\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("Postbody", Postbody);
    } else {
      throw new IllegalArgumentException("Required argument \"Postbody\" is missing and does not have an android:defaultValue");
    }
    return __result;
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

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("PostTitle")) {
      String PostTitle = (String) arguments.get("PostTitle");
      __result.set("PostTitle", PostTitle);
    }
    if (arguments.containsKey("PostId")) {
      String PostId = (String) arguments.get("PostId");
      __result.set("PostId", PostId);
    }
    if (arguments.containsKey("Postbody")) {
      String Postbody = (String) arguments.get("Postbody");
      __result.set("Postbody", Postbody);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    PostDetailsFragArgs that = (PostDetailsFragArgs) object;
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
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getPostTitle() != null ? getPostTitle().hashCode() : 0);
    result = 31 * result + (getPostId() != null ? getPostId().hashCode() : 0);
    result = 31 * result + (getPostbody() != null ? getPostbody().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "PostDetailsFragArgs{"
        + "PostTitle=" + getPostTitle()
        + ", PostId=" + getPostId()
        + ", Postbody=" + getPostbody()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull PostDetailsFragArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String PostTitle, @NonNull String PostId, @NonNull String Postbody) {
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
    public PostDetailsFragArgs build() {
      PostDetailsFragArgs result = new PostDetailsFragArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setPostTitle(@NonNull String PostTitle) {
      if (PostTitle == null) {
        throw new IllegalArgumentException("Argument \"PostTitle\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("PostTitle", PostTitle);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setPostId(@NonNull String PostId) {
      if (PostId == null) {
        throw new IllegalArgumentException("Argument \"PostId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("PostId", PostId);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setPostbody(@NonNull String Postbody) {
      if (Postbody == null) {
        throw new IllegalArgumentException("Argument \"Postbody\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("Postbody", Postbody);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getPostTitle() {
      return (String) arguments.get("PostTitle");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getPostId() {
      return (String) arguments.get("PostId");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getPostbody() {
      return (String) arguments.get("Postbody");
    }
  }
}
