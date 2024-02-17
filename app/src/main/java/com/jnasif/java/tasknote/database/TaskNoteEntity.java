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
    private boolean taskDone;

    @Ignore
    public TaskNoteEntity() {
    }

    public TaskNoteEntity(int id, Date createDate, String taskNameText, boolean taskDone) {
        this.id = id;
        this.createDate = createDate;
        this.taskNameText = taskNameText;
        this.taskDone = taskDone;
    }

    @Ignore
    public TaskNoteEntity(Date createDate, String taskNameText, boolean taskDone) {
        this.createDate = createDate;
        this.taskNameText = taskNameText;
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
