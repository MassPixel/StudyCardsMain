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

public class SetQuestionFragmentDirections {
  private SetQuestionFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSetQuestionFragmentToQuizFragment() {
    return new ActionOnlyNavDirections(R.id.action_setQuestionFragment_to_quizFragment);
  }

  @NonNull
  public static ActionSetQuestionFragmentSelf actionSetQuestionFragmentSelf(
      @NonNull String quizSet) {
    return new ActionSetQuestionFragmentSelf(quizSet);
  }

  public static class ActionSetQuestionFragmentSelf implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionSetQuestionFragmentSelf(@NonNull String quizSet) {
      if (quizSet == null) {
        throw new IllegalArgumentException("Argument \"quizSet\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("quizSet", quizSet);
    }

    @NonNull
    public ActionSetQuestionFragmentSelf setQuizSet(@NonNull String quizSet) {
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
      return R.id.action_setQuestionFragment_self;
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
      ActionSetQuestionFragmentSelf that = (ActionSetQuestionFragmentSelf) object;
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
      return "ActionSetQuestionFragmentSelf(actionId=" + getActionId() + "){"
          + "quizSet=" + getQuizSet()
          + "}";
    }
  }
}
