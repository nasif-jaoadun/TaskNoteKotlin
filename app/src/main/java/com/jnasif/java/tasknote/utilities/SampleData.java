package com.jnasif.java.tasknote.utilities;

import com.jnasif.java.tasknote.model.TaskNoteEntity;

import java.util.ArrayList;
import java.util.List;

public class SampleData {
    public static final String SAMPLE_TASK_1 ="This is a sample task";
    public static final String SAMPLE_TASK_2 ="This is a sample task but with some details";
    public static final String SAMPLE_TASK_3 ="This Task is a sample task but with some slide details and also to show more details description on this task to be shown in list";

    public static List<TaskNoteEntity> getTaskNotes(){
        List<TaskNoteEntity> taskNotes = new ArrayList<>();
        taskNotes.add(new TaskNoteEntity(1, Utility.getDate(0), SAMPLE_TASK_1, false));
        taskNotes.add(new TaskNoteEntity(2, Utility.getDate(-1), SAMPLE_TASK_2, false));
        taskNotes.add(new TaskNoteEntity(3, Utility.getDate(-2), SAMPLE_TASK_3, false));
        return taskNotes;
    }
}
