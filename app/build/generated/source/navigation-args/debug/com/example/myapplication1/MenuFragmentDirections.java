package com.example.myapplication1;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class MenuFragmentDirections {
  private MenuFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionFirstFragmentToSecondFragment() {
    return new ActionOnlyNavDirections(R.id.action_FirstFragment_to_SecondFragment);
  }

  @NonNull
  public static NavDirections actionFirstFragmentToEditFragment() {
    return new ActionOnlyNavDirections(R.id.action_FirstFragment_to_editFragment);
  }

  @NonNull
  public static NavDirections actionMenuFragmentToEditCategoryFragment() {
    return new ActionOnlyNavDirections(R.id.action_menuFragment_to_editCategoryFragment);
  }
}
