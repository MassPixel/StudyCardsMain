package com.example.myapplication1.quizzes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication1.QuizFragment;
import com.example.myapplication1.R;
import com.example.myapplication1.data.AppDatabase;
import com.example.myapplication1.data.Question;
import com.example.myapplication1.data.QuestionDAO;

import java.util.ArrayList;
import java.util.List;


public class quizQuestionFragment extends Fragment {


    public AppDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = AppDatabase.getInstance(this.getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_question, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Question q = new Question();
        QuestionDAO qDAO = db.questionDAO();
        final Question currentQuestion = q.randomQuestionChooser(qDAO.getAllQuestionsComfort());
        final String currentText = currentQuestion.getQuestionText();
        final TextView question = view.findViewById(R.id.quizQQuestion);
        final TextView answer = view.findViewById(R.id.quizQAnswer);
        final Button showButton = view.findViewById(R.id.showQuizQAnswer);
        final Button submitButton = view.findViewById(R.id.submitQQuestionButton);
        final Button nextQuestionButton = view.findViewById(R.id.nextQQuestionButton);

        question.setText(currentText);


        Spinner answeredSpinner = view.findViewById(R.id.quizQAnsweredSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.comfortArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        answeredSpinner.setAdapter(adapter);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(currentQuestion.getAnswerText());
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newComfort = Integer.parseInt(String.valueOf(answeredSpinner.getSelectedItem().toString().charAt(0)));
                qDAO.updateComfort(newComfort, currentText);
            }
        });

        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(quizQuestionFragment.this)
                        .navigate(R.id.action_quizQuestionFragment_self);
            }
        });




    }

}