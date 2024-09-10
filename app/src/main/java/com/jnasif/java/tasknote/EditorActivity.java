package com.jnasif.java.tasknote;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.jnasif.java.tasknote.database.TaskNoteEntity;
import com.jnasif.java.tasknote.databinding.ActivityEditorBinding;
import com.jnasif.java.tasknote.utilities.Utility;
import com.jnasif.java.tasknote.viewmodel.EditorViewModel;

import static com.jnasif.java.tasknote.utilities.Constants.TASK_NOTE_ID_KEY;

public class EditorActivity extends AppCompatActivity {
    private EditorViewModel mViewModel;
    private ActivityEditorBinding binding;
    private boolean mNewTaskNote;

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
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_done);

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
                if(taskNoteEntity!=null){
                    binding.layoutContentEditor.editTextTaskNote.setText(taskNoteEntity.getTaskNameText());
                    binding.layoutContentEditor.editTextTaskNoteDetails.setText(taskNoteEntity.getTaskNote());
                }
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras==null){
            setTitle(getString(R.string.new_task_note));
            Utility.showLog(Log.ERROR, "ID Of the Task is: null");
            mNewTaskNote = true;
        }else {
            setTitle(getString(R.string.edit_task_note));
            int taskNoteId = extras.getInt(TASK_NOTE_ID_KEY);
            Utility.showLog(Log.ERROR, "ID Of the Task is: "+ taskNoteId);
            mViewModel.loadData(taskNoteId);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            saveAndReturn();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        saveAndReturn();
    }

    private void saveAndReturn() {
        mViewModel.saveTaskNote(binding.layoutContentEditor.editTextTaskNote.getText().toString().trim(), binding.layoutContentEditor.editTextTaskNoteDetails.getText().toString().trim());
        finish();
    }
}