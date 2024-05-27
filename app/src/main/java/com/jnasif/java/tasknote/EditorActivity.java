package com.jnasif.java.tasknote;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;

import com.jnasif.java.tasknote.database.TaskNoteEntity;
import com.jnasif.java.tasknote.databinding.ActivityEditorBinding;
import com.jnasif.java.tasknote.viewmodel.EditorViewModel;

public class EditorActivity extends AppCompatActivity {
    private EditorViewModel mViewModel;
    private ActivityEditorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEditorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
//        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
//        toolBarLayout.setTitle(getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initViewModel();
    }

    private void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(EditorViewModel.class);
        mViewModel.mLiveTaskNote.observe(this, new Observer<TaskNoteEntity>() {
            @Override
            public void onChanged(TaskNoteEntity taskNoteEntity) {
                binding.layoutContentEditor.editTextTaskNote.getText();
                binding.layoutContentEditor.editTextTaskNoteDetails.getText();
            }
        });
    }
}