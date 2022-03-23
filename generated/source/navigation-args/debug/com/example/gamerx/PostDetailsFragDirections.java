package com.example.gamerx;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class PostDetailsFragDirections {
  private PostDetailsFragDirections() {
  }

  @NonNull
  public static NavDirections actionPostDetailsFragToEditPost() {
    return new ActionOnlyNavDirections(R.id.action_postDetailsFrag_to_editPost);
  }
}
