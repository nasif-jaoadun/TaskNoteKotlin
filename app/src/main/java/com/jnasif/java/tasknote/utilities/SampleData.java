package com.jnasif.java.tasknote.utilities;

import com.jnasif.java.tasknote.database.TaskNoteEntity;

import java.util.ArrayList;
import java.util.List;

public class SampleData {
    public static final String SAMPLE_TASK_NAME_1 = "Task 1";
    public static final String SAMPLE_TASK_1 ="This is a sample task";
    public static final String SAMPLE_TASK_NAME_2 = "Task 2";
    public static final String SAMPLE_TASK_2 ="This is a sample task but with some details";
    public static final String SAMPLE_TASK_NAME_3 = "Task 3";
    public static final String SAMPLE_TASK_3 ="This Task is a sample task but with some slide details and also to show more details description on this task to be shown in list";

    public static List<TaskNoteEntity> getTaskNotes(){
        List<TaskNoteEntity> taskNotes = new ArrayList<>();
        taskNotes.add(new TaskNoteEntity(1, Utility.getDate(0), SAMPLE_TASK_NAME_1, SAMPLE_TASK_1, false));
        taskNotes.add(new TaskNoteEntity(2, Utility.getDate(-1), SAMPLE_TASK_NAME_2, SAMPLE_TASK_2, false));
        taskNotes.add(new TaskNoteEntity(3, Utility.getDate(-2), SAMPLE_TASK_NAME_3, SAMPLE_TASK_3, false));
        return taskNotes;
    }

    public static List<TaskNoteEntity> getTaskNotesWithoutId(){
        List<TaskNoteEntity> taskNotes = new ArrayList<>();
        taskNotes.add(new TaskNoteEntity(Utility.getDate(0), SAMPLE_TASK_NAME_1, SAMPLE_TASK_1, false));
        taskNotes.add(new TaskNoteEntity(Utility.getDate(-1), SAMPLE_TASK_NAME_2, SAMPLE_TASK_2, false));
        taskNotes.add(new TaskNoteEntity(Utility.getDate(-2), SAMPLE_TASK_NAME_3, SAMPLE_TASK_3, false));
        return taskNotes;
    }
}
