package com.jnasif.java.tasknote.viewmodel;

import android.app.Application;
import android.text.TextUtils;

import com.jnasif.java.tasknote.database.AppRepository;
import com.jnasif.java.tasknote.database.TaskNoteEntity;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class EditorViewModel extends AndroidViewModel {
    public MutableLiveData<TaskNoteEntity> mLiveTaskNote = new MutableLiveData<>();
    private AppRepository mRepository;

    private Executor executor = Executors.newSingleThreadExecutor();
    public EditorViewModel(@NonNull Application application) {
        super(application);
        mRepository = AppRepository.getInstance(getApplication());
    }

    public void loadData(int taskNoteId) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                TaskNoteEntity taskNote = mRepository.getTaskNoteById(taskNoteId);
                mLiveTaskNote.postValue(taskNote);
            }
        });
    }

    public void saveTaskNote(String taskText, String noteText) {
        TaskNoteEntity taskNote = mLiveTaskNote.getValue();
        if(taskNote == null){
            if(TextUtils.isEmpty(taskText.trim()) || TextUtils.isEmpty(noteText.trim())){
                return;
            }
            taskNote = new TaskNoteEntity(new Date(), taskText, noteText, false);
        }else {
            taskNote.setTaskNameText(taskText);
            taskNote.setTaskNote(noteText);
        }
        mRepository.insertTaskNote(taskNote);
    }

    public void deleteTask() {
        mRepository.deleteTask(mLiveTaskNote.getValue());
    }
}
