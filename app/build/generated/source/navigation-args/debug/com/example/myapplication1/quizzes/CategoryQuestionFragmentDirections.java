package com.example.myapplication1.quizzes;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.myapplication1.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CategoryQuestionFragmentDirections {
  private CategoryQuestionFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionCategoryQuestionFragmentToQuizFragment() {
    return new ActionOnlyNavDirections(R.id.action_categoryQuestionFragment_to_quizFragment);
  }

  @NonNull
  public static ActionCategoryQuestionFragmentSelf actionCategoryQuestionFragmentSelf(
      @NonNull String category) {
    return new ActionCategoryQuestionFragmentSelf(category);
  }

  public static class ActionCategoryQuestionFragmentSelf implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionCategoryQuestionFragmentSelf(@NonNull String category) {
      if (category == null) {
        throw new IllegalArgumentException("Argument \"category\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("category", category);
    }

    @NonNull
    public ActionCategoryQuestionFragmentSelf setCategory(@NonNull String category) {
      if (category == null) {
        throw new IllegalArgumentException("Argument \"category\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("category", category);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("category")) {
        String category = (String) arguments.get("category");
        __result.putString("category", category);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_categoryQuestionFragment_self;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getCategory() {
      return (String) arguments.get("category");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionCategoryQuestionFragmentSelf that = (ActionCategoryQuestionFragmentSelf) object;
      if (arguments.containsKey("category") != that.arguments.containsKey("category")) {
        return false;
      }
      if (getCategory() != null ? !getCategory().equals(that.getCategory()) : that.getCategory() != null) {
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
      result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionCategoryQuestionFragmentSelf(actionId=" + getActionId() + "){"
          + "category=" + getCategory()
          + "}";
    }
  }
}
