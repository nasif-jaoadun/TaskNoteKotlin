package com.jnasif.java.tasknote.viewmodel;

import android.app.Application;

import com.jnasif.java.tasknote.database.AppRepository;
import com.jnasif.java.tasknote.database.TaskNoteEntity;
import com.jnasif.java.tasknote.utilities.SampleData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MainViewModel extends AndroidViewModel {

    public LiveData<List<TaskNoteEntity>> mTaskNotes ;
    private AppRepository mAppRepository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        mAppRepository = AppRepository.getInstance(application.getApplicationContext());
        mTaskNotes = mAppRepository.mTaskNotes;
    }
}
