package com.jnasif.java.tasknote;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jnasif.java.tasknote.databinding.ActivityMainBinding;
import com.jnasif.java.tasknote.model.TaskNoteEntity;
import com.jnasif.java.tasknote.ui.TaskNoteAdapter;
import com.jnasif.java.tasknote.utilities.SampleData;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private TaskNoteAdapter taskNoteAdapter;

    List<TaskNoteEntity> taskNotesData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        taskNotesData.addAll(SampleData.getTaskNotes());
        setListVIewProperties();
    }

    private void setListVIewProperties() {
        binding.layoutContentMain.recyclerVIew.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.layoutContentMain.recyclerVIew.setLayoutManager(linearLayoutManager);

        taskNoteAdapter = new TaskNoteAdapter(taskNotesData, this);
        binding.layoutContentMain.recyclerVIew.setAdapter(taskNoteAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}