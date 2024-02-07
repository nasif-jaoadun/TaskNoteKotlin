package com.jnasif.java.tasknote;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;

import com.jnasif.java.tasknote.database.AppDatabase;
import com.jnasif.java.tasknote.database.TaskNoteDao;
import com.jnasif.java.tasknote.database.TaskNoteEntity;
import com.jnasif.java.tasknote.utilities.SampleData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    public static final String TAG = "Junit";
    private AppDatabase mDb;
    private TaskNoteDao mDao;
    @Before
    public void createDb(){
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext(); //Context reference without using Application context
        mDb = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build(); //instance of Database in memory, which is used to not save persistent data and destroy after each use off this method
        mDao = mDb.taskNoteDao();
        Log.i(TAG, "createDb");
    }
    @After
    public void closeDb(){
        mDb.close();
        Log.i(TAG, "closeDb");
    }
    @Test
    public void createAndRetrieveTaskNotes(){
        mDao.insertAllTaskNote(SampleData.getTaskNotes());
        int count = mDao.getCount();
        Log.i(TAG, "createAndRetrieveTaskNotes: count = " + count);
        assertEquals(SampleData.getTaskNotes().size(), count);
    }

    @Test
    public void compareString(){
        mDao.insertAllTaskNote(SampleData.getTaskNotes());
        TaskNoteEntity original = SampleData.getTaskNotes().get(0);
        TaskNoteEntity fromDb = mDao.getTaskNoteById(1);
        assertEquals(original.getTaskNameText(),fromDb.getTaskNameText());
        assertEquals(1,fromDb.getId());
    }
}
