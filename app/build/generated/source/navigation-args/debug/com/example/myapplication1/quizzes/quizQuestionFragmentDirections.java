package com.example.myapplication1.quizzes;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.myapplication1.R;

public class quizQuestionFragmentDirections {
  private quizQuestionFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionQuizQuestionFragmentSelf() {
    return new ActionOnlyNavDirections(R.id.action_quizQuestionFragment_self);
  }

  @NonNull
  public static NavDirections actionQuizQuestionFragmentToQuizFragment() {
    return new ActionOnlyNavDirections(R.id.action_quizQuestionFragment_to_quizFragment);
  }
}
