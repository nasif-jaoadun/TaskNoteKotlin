package com.jnasif.java.tasknote.database;

import android.content.Context;

import com.jnasif.java.tasknote.utilities.SampleData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {
    private static AppRepository repositoryInstance;
    public List<TaskNoteEntity> mTaskNotes;
    private AppDatabase mDb;
    private Executor executor = Executors.newSingleThreadExecutor();
    public static AppRepository getInstance(Context context){
        if(repositoryInstance == null)
            repositoryInstance = new AppRepository(context);
        return repositoryInstance;
    }
    private AppRepository(Context context){
        mDb = AppDatabase.getInstance(context);
        mTaskNotes = SampleData.getTaskNotes();
    }

    private void addSampleData(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.taskNoteDao().insertAllTaskNote(SampleData.getTaskNotes());
            }
        });
    }
}
