package com.example.myapplication1.quizzes;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SetQuestionFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SetQuestionFragmentArgs() {
  }

  private SetQuestionFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SetQuestionFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SetQuestionFragmentArgs __result = new SetQuestionFragmentArgs();
    bundle.setClassLoader(SetQuestionFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("quizSet")) {
      String quizSet;
      quizSet = bundle.getString("quizSet");
      if (quizSet == null) {
        throw new IllegalArgumentException("Argument \"quizSet\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("quizSet", quizSet);
    } else {
      throw new IllegalArgumentException("Required argument \"quizSet\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getQuizSet() {
    return (String) arguments.get("quizSet");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("quizSet")) {
      String quizSet = (String) arguments.get("quizSet");
      __result.putString("quizSet", quizSet);
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
    SetQuestionFragmentArgs that = (SetQuestionFragmentArgs) object;
    if (arguments.containsKey("quizSet") != that.arguments.containsKey("quizSet")) {
      return false;
    }
    if (getQuizSet() != null ? !getQuizSet().equals(that.getQuizSet()) : that.getQuizSet() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getQuizSet() != null ? getQuizSet().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SetQuestionFragmentArgs{"
        + "quizSet=" + getQuizSet()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(SetQuestionFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String quizSet) {
      if (quizSet == null) {
        throw new IllegalArgumentException("Argument \"quizSet\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("quizSet", quizSet);
    }

    @NonNull
    public SetQuestionFragmentArgs build() {
      SetQuestionFragmentArgs result = new SetQuestionFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setQuizSet(@NonNull String quizSet) {
      if (quizSet == null) {
        throw new IllegalArgumentException("Argument \"quizSet\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("quizSet", quizSet);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getQuizSet() {
      return (String) arguments.get("quizSet");
    }
  }
}
