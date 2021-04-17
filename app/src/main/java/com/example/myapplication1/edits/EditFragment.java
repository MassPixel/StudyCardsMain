package com.example.myapplication1.edits;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.myapplication1.R;
import com.example.myapplication1.data.AppDatabase;
import com.example.myapplication1.data.CategoryDAO;
import com.example.myapplication1.data.CategoryWithQuestionsDAO;
import com.example.myapplication1.data.QuestionDAO;
import com.google.android.material.snackbar.Snackbar;


public class EditFragment extends Fragment {
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
        return inflater.inflate(R.layout.fragment_edit, container, false);


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText q = view.findViewById(R.id.questionInputBox);
        final EditText a = view.findViewById(R.id.answerInputBox);
        final Button addQuestionB = view.findViewById(R.id.addQuestionButton);
        final Button deleteQuestionB = view.findViewById(R.id.deleteQuestionButton);
        final Button nukeQuestionB = view.findViewById(R.id.nukeQuestionButton);
        QuestionDAO qDAO = db.questionDAO();
        CategoryDAO cDAO = db.categoryDAO();
        CategoryWithQuestionsDAO cqDAO = db.categoryWithQuestionsDAO();

        //setting up the dropdown box for deleting questions
        Spinner questions = view.findViewById(R.id.spinner);
        String[] qs = qDAO.getAllQuestions().toArray(new String[0]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, qs);
        questions.setAdapter(adapter);

        //setting up the dropdown box for adding questions to categories
        Spinner categories = view.findViewById(R.id.spinnerQuestionCategory);
        String[] cs = cDAO.getAllCategories().toArray(new String[0]);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, cs);
        categories.setAdapter(adapter2);

        addQuestionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qDAO.insertQuestion(q.getText().toString(), a.getText().toString(), 3);

                cqDAO.addQuestionCategory(qDAO.getQuestionID(q.getText().toString()), cDAO.getCategoryID(categories.getSelectedItem().toString()));

                String[] qs = qDAO.getAllQuestions().toArray(new String[0]);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getParentFragment().getActivity(), android.R.layout.simple_spinner_dropdown_item, qs);
                questions.setAdapter(adapter);

                q.setText("");
                a.setText("");
            }
        });
        deleteQuestionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String q = questions.getSelectedItem().toString();
                qDAO.deleteQuestion(q);

                String[] qs = qDAO.getAllQuestions().toArray(new String[0]);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getParentFragment().getActivity(), android.R.layout.simple_spinner_dropdown_item, qs);
                questions.setAdapter(adapter);
            }
        });
        nukeQuestionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qDAO.nukeQuestions();

                String[] qs = qDAO.getAllQuestions().toArray(new String[0]);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getParentFragment().getActivity(), android.R.layout.simple_spinner_dropdown_item, qs);
                questions.setAdapter(adapter);
            }
        });
    }
}