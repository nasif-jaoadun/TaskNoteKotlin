package com.jnasif.java.tasknote.model;

import java.util.Date;

public class TaskNoteEntity {
    private int id;
    private Date createDate;
    private String taskNameText;
    private boolean taskStatus;

    public TaskNoteEntity() {
    }

    public TaskNoteEntity(int id, Date createDate, String taskNameText, boolean taskStatus) {
        this.id = id;
        this.createDate = createDate;
        this.taskNameText = taskNameText;
        this.taskStatus = taskStatus;
    }

    public TaskNoteEntity(Date createDate, String taskNameText) {
        this.createDate = createDate;
        this.taskNameText = taskNameText;
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

    public boolean isTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "TaskNoteEntity{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", taskNameText='" + taskNameText + '\'' +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
