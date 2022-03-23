package com.example.gamerx;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class ProfileFragDirections {
  private ProfileFragDirections() {
  }

  @NonNull
  public static NavDirections actionProfileFragToMenuFrag() {
    return new ActionOnlyNavDirections(R.id.action_profileFrag_to_menuFrag);
  }
}
