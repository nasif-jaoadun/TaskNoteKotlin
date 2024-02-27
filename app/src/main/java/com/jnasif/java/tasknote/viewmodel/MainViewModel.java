package com.jnasif.java.tasknote.viewmodel;

import android.app.Application;

import com.jnasif.java.tasknote.database.TaskNoteEntity;
import com.jnasif.java.tasknote.utilities.SampleData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainViewModel extends AndroidViewModel {

    public List<TaskNoteEntity> mTaskNotes = SampleData.getTaskNotes();
    public MainViewModel(@NonNull Application application) {
        super(application);
    }
}
