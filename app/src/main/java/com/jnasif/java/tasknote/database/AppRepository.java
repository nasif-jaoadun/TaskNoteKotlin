package com.jnasif.java.tasknote.database;

import android.content.Context;

import com.jnasif.java.tasknote.utilities.SampleData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.lifecycle.LiveData;

public class AppRepository {
    private static AppRepository repositoryInstance;
    public LiveData<List<TaskNoteEntity>> mTaskNotes;
    private AppDatabase mDb;
    private Executor executor = Executors.newSingleThreadExecutor();
    public static AppRepository getInstance(Context context){
        if(repositoryInstance == null)
            repositoryInstance = new AppRepository(context);
        return repositoryInstance;
    }
    private AppRepository(Context context){
        mDb = AppDatabase.getInstance(context);
        mTaskNotes = getAllTaskNotes();
    }

    public void addSampleData(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.taskNoteDao().insertAllTaskNote(SampleData.getTaskNotesWithoutId());
            }
        });
    }

    private LiveData<List<TaskNoteEntity>> getAllTaskNotes(){
        return mDb.taskNoteDao().getAll();
    }

    public void deleteAllTaskNotes() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.taskNoteDao().deleteALl();
            }
        });
    }

    public TaskNoteEntity getTaskNoteById(int taskNoteId) {
        return mDb.taskNoteDao().getTaskNoteById(taskNoteId);
    }

    public void insertTaskNote(TaskNoteEntity taskNote) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.taskNoteDao().insertTaskNote(taskNote);
            }
        });
    }
}
