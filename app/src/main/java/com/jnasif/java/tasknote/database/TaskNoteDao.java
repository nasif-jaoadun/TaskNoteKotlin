package com.jnasif.java.tasknote.database;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface TaskNoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTaskNote(TaskNoteEntity taskNoteEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllTaskNote(List<TaskNoteEntity> taskNotes);

    @Delete
    void deleteTaskNote(TaskNoteEntity taskNoteEntity);

    @Query("SELECT * FROM taskNotes WHERE id = :id")
    TaskNoteEntity getTaskNoteById(int id);

    @Query("SELECT * FROM taskNotes ORDER BY createDate DESC")
    LiveData<List<TaskNoteEntity>> getAll();

    @Query("DELETE FROM taskNotes")
    int deleteALl();

    @Query("SELECT COUNT(*) FROM taskNotes")
    int getCount();

}
