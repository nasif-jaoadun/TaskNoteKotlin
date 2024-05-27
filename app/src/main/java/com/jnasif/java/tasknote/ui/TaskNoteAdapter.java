package com.jnasif.java.tasknote.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.jnasif.java.tasknote.databinding.TaskNoteListItemBinding;
import com.jnasif.java.tasknote.database.TaskNoteEntity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskNoteAdapter extends RecyclerView.Adapter<TaskNoteAdapter.ViewHolder> {

    TaskNoteListItemBinding binding;
    private final List<TaskNoteEntity> mTaskNotes;
    private final Context mContext;

    public TaskNoteAdapter(List<TaskNoteEntity> mTaskNotes, Context mContext) {
        this.mTaskNotes = mTaskNotes;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = TaskNoteListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);

        /*LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.task_note_list_item, parent, false);
        return new ViewHolder(view);*/
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final TaskNoteEntity taskNote = mTaskNotes.get(position);
        binding.textViewTaskName.setText(taskNote.getTaskNameText());
        binding.textViewTaskDetails.setText(taskNote.getTaskNote());
        binding.radioButton.setChecked(taskNote.isTaskDone());

        binding.radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mTaskNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ViewHolder(TaskNoteListItemBinding itemBinding){
            super(itemBinding.getRoot());
        }
        /*public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }*/
    }
}
