package com.example.myapplication1;

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

public class QuizFragmentDirections {
  private QuizFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionQuizFragmentToQuizQuestionFragment() {
    return new ActionOnlyNavDirections(R.id.action_quizFragment_to_quizQuestionFragment);
  }

  @NonNull
  public static ActionQuizFragmentToCategoryQuestionFragment actionQuizFragmentToCategoryQuestionFragment(
      @NonNull String category) {
    return new ActionQuizFragmentToCategoryQuestionFragment(category);
  }

  @NonNull
  public static ActionQuizFragmentToSetQuestionFragment actionQuizFragmentToSetQuestionFragment(
      @NonNull String quizSet) {
    return new ActionQuizFragmentToSetQuestionFragment(quizSet);
  }

  public static class ActionQuizFragmentToCategoryQuestionFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionQuizFragmentToCategoryQuestionFragment(@NonNull String category) {
      if (category == null) {
        throw new IllegalArgumentException("Argument \"category\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("category", category);
    }

    @NonNull
    public ActionQuizFragmentToCategoryQuestionFragment setCategory(@NonNull String category) {
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
      return R.id.action_quizFragment_to_categoryQuestionFragment;
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
      ActionQuizFragmentToCategoryQuestionFragment that = (ActionQuizFragmentToCategoryQuestionFragment) object;
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
      return "ActionQuizFragmentToCategoryQuestionFragment(actionId=" + getActionId() + "){"
          + "category=" + getCategory()
          + "}";
    }
  }

  public static class ActionQuizFragmentToSetQuestionFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionQuizFragmentToSetQuestionFragment(@NonNull String quizSet) {
      if (quizSet == null) {
        throw new IllegalArgumentException("Argument \"quizSet\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("quizSet", quizSet);
    }

    @NonNull
    public ActionQuizFragmentToSetQuestionFragment setQuizSet(@NonNull String quizSet) {
      if (quizSet == null) {
        throw new IllegalArgumentException("Argument \"quizSet\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("quizSet", quizSet);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("quizSet")) {
        String quizSet = (String) arguments.get("quizSet");
        __result.putString("quizSet", quizSet);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_quizFragment_to_setQuestionFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getQuizSet() {
      return (String) arguments.get("quizSet");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionQuizFragmentToSetQuestionFragment that = (ActionQuizFragmentToSetQuestionFragment) object;
      if (arguments.containsKey("quizSet") != that.arguments.containsKey("quizSet")) {
        return false;
      }
      if (getQuizSet() != null ? !getQuizSet().equals(that.getQuizSet()) : that.getQuizSet() != null) {
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
      result = 31 * result + (getQuizSet() != null ? getQuizSet().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionQuizFragmentToSetQuestionFragment(actionId=" + getActionId() + "){"
          + "quizSet=" + getQuizSet()
          + "}";
    }
  }
}
