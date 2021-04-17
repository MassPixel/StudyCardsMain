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

public class CategoryQuestionFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CategoryQuestionFragmentArgs() {
  }

  private CategoryQuestionFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CategoryQuestionFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CategoryQuestionFragmentArgs __result = new CategoryQuestionFragmentArgs();
    bundle.setClassLoader(CategoryQuestionFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("category")) {
      String category;
      category = bundle.getString("category");
      if (category == null) {
        throw new IllegalArgumentException("Argument \"category\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("category", category);
    } else {
      throw new IllegalArgumentException("Required argument \"category\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getCategory() {
    return (String) arguments.get("category");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("category")) {
      String category = (String) arguments.get("category");
      __result.putString("category", category);
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
    CategoryQuestionFragmentArgs that = (CategoryQuestionFragmentArgs) object;
    if (arguments.containsKey("category") != that.arguments.containsKey("category")) {
      return false;
    }
    if (getCategory() != null ? !getCategory().equals(that.getCategory()) : that.getCategory() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CategoryQuestionFragmentArgs{"
        + "category=" + getCategory()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(CategoryQuestionFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String category) {
      if (category == null) {
        throw new IllegalArgumentException("Argument \"category\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("category", category);
    }

    @NonNull
    public CategoryQuestionFragmentArgs build() {
      CategoryQuestionFragmentArgs result = new CategoryQuestionFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setCategory(@NonNull String category) {
      if (category == null) {
        throw new IllegalArgumentException("Argument \"category\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("category", category);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getCategory() {
      return (String) arguments.get("category");
    }
  }
}
