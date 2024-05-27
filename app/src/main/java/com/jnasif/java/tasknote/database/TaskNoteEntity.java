package com.jnasif.java.tasknote.database;

import java.util.Date;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "taskNotes")
public class TaskNoteEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private Date createDate;
    private String taskNameText;
    private String taskNote;
    private boolean taskDone;

    @Ignore
    public TaskNoteEntity() {
    }

    public TaskNoteEntity(int id, Date createDate, String taskNameText, String taskNote, boolean taskDone) {
        this.id = id;
        this.createDate = createDate;
        this.taskNameText = taskNameText;
        this.taskNote = taskNote;
        this.taskDone = taskDone;
    }

    @Ignore
    public TaskNoteEntity(Date createDate, String taskNameText, String taskNote, boolean taskDone) {
        this.createDate = createDate;
        this.taskNameText = taskNameText;
        this.taskNote = taskNote;
        this.taskDone = taskDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTaskNameText() {
        return taskNameText;
    }

    public void setTaskNameText(String taskNameText) {
        this.taskNameText = taskNameText;
    }

    public String getTaskNote() {
        return taskNote;
    }

    public void setTaskNote(String taskNote) {
        this.taskNote = taskNote;
    }

    public boolean isTaskDone() {
        return taskDone;
    }

    public void setTaskDone(boolean taskDone) {
        this.taskDone = taskDone;
    }

    @Override
    public String toString() {
        return "TaskNoteEntity{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", taskNameText='" + taskNameText + '\'' +
                ", taskStatus=" + taskDone +
                '}';
    }
}
