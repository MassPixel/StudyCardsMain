package com.example.myapplication1.edits;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.myapplication1.R;
import com.example.myapplication1.data.AppDatabase;
import com.example.myapplication1.data.Category;
import com.example.myapplication1.data.CategoryDAO;
import com.example.myapplication1.data.QuestionDAO;


public class editCategoryFragment extends Fragment {
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
        return inflater.inflate(R.layout.fragment_edit_category, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText c = view.findViewById(R.id.categoryInputBox);
        final EditText cD = view.findViewById(R.id.categoryDescInputBox);
        final Button addCategoryB = view.findViewById(R.id.addCategoryButton);
        final Button deleteCategoryB = view.findViewById(R.id.deleteCategoryButton);
        final Button nukeCategoryB = view.findViewById(R.id.nukeCategoryButton);
        CategoryDAO cDAO = db.categoryDAO();

        Spinner categories = view.findViewById(R.id.spinnerCategories);
        String[] cs = cDAO.getAllCategories().toArray(new String[0]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, cs);
        categories.setAdapter(adapter);

        addCategoryB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cDAO.insertCategory(c.getText().toString(), cD.getText().toString());

                String[] qs = cDAO.getAllCategories().toArray(new String[0]);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getParentFragment().getActivity(), android.R.layout.simple_spinner_dropdown_item, qs);
                categories.setAdapter(adapter);

                c.setText("");
                cD.setText("");
            }
        });
        deleteCategoryB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = categories.getSelectedItem().toString();
                cDAO.deleteCategory(c);

                String[] qs = cDAO.getAllCategories().toArray(new String[0]);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getParentFragment().getActivity(), android.R.layout.simple_spinner_dropdown_item, qs);
                categories.setAdapter(adapter);
            }
        });
        nukeCategoryB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cDAO.nukeCategory();

                String[] qs = cDAO.getAllCategories().toArray(new String[0]);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getParentFragment().getActivity(), android.R.layout.simple_spinner_dropdown_item, qs);
                categories.setAdapter(adapter);
            }
        });
    }
}