package com.example.myapplication1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication1.data.AppDatabase;
import com.example.myapplication1.data.Category;
import com.example.myapplication1.data.CategoryDAO;
import com.example.myapplication1.data.QuestionDAO;

import java.util.ArrayList;
import java.util.List;

public class QuizFragment extends Fragment {

    public AppDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = AppDatabase.getInstance(this.getActivity());
    }
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CategoryDAO cDAO = db.categoryDAO();
        QuestionDAO qDAO = db.questionDAO();

        Spinner categories = view.findViewById(R.id.spinnerCategoryChoice);
        String[] cs = cDAO.getAllCategories().toArray(new String[0]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, cs);
        categories.setAdapter(adapter);

        /*Spinner categories = view.findViewById(R.id.spinnerQuizSetChoice);
        String[] cs = cDAO.getAllCategories().toArray(new String[0]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, cs);
        categories.setAdapter(adapter);*/

        view.findViewById(R.id.askAllButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> qs = qDAO.getAllQuestions();
                if (qs.isEmpty()) {
                    System.out.println("No questions on record");
                }
                else {
                    NavHostFragment.findNavController(QuizFragment.this)
                            .navigate(R.id.action_quizFragment_to_quizQuestionFragment);
                }
            }
        });
        view.findViewById(R.id.askCategoryButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c = categories.getSelectedItem().toString();
                Bundle bundle = new Bundle();
                bundle.putString("category", c);
                NavHostFragment.findNavController(QuizFragment.this)
                        .navigate(R.id.action_quizFragment_to_categoryQuestionFragment, bundle);

            }
        });
        view.findViewById(R.id.askSetButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> qs = qDAO.getAllQuestions();
                if (qs.isEmpty()) {
                    System.out.println("No questions on record");
                }
                else {
                    Bundle bundle = new Bundle();
                    bundle.putString("all", "all");
                    NavHostFragment.findNavController(QuizFragment.this)
                            .navigate(R.id.action_quizFragment_to_quizQuestionFragment, bundle);
                }
            }
        });
    }
}