package com.example.myapplication1.quizzes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication1.R;
import com.example.myapplication1.data.AppDatabase;
import com.example.myapplication1.data.QuestionDAO;

import java.util.List;


public class CategoryQuestionFragment extends Fragment {
    AppDatabase db;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = AppDatabase.getInstance(this.getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category_question, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String pass = getArguments().getString("category");
        TextView tv = view.findViewById(R.id.categoryText);
        tv.setText(pass);

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = getArguments().getString("category");
                TextView tv = view.findViewById(R.id.categoryText);
                tv.setText(pass);
            }
        });
    }
}