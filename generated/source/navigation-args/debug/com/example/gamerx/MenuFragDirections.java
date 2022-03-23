package com.example.gamerx;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class MenuFragDirections {
  private MenuFragDirections() {
  }

  @NonNull
  public static NavDirections actionMenuFragToPostsListFrag() {
    return new ActionOnlyNavDirections(R.id.action_menuFrag_to_postsListFrag);
  }
}
