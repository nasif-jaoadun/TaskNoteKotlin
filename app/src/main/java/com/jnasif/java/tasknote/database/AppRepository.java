package com.jnasif.java.tasknote.database;

import com.jnasif.java.tasknote.utilities.SampleData;

import java.util.List;

public class AppRepository {
    private static final AppRepository repositoryInstance = new AppRepository();
    public List<TaskNoteEntity> mTaskNotes;
    public static AppRepository getInstance(){
        return repositoryInstance;
    }
    private AppRepository(){
        mTaskNotes = SampleData.getTaskNotes();
    }
}
