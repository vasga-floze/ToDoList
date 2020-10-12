package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.util.Range;

import com.example.todolist.db.dao.AlumnoDAO;
import com.example.todolist.db.pojo.Alumno;
//import com.example.todolist.db.pojo.Alumno;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rcvAlumno = (RecyclerView) findViewById(R.id.recycler_alumnos);
        AlumnoDAO dao = new AlumnoDAO(this);
        ArrayList<Alumno> alumno = dao.getAll();
        AlumnoAdapter adapter = new AlumnoAdapter(alumno);
        rcvAlumno.setAdapter(adapter);
        rcvAlumno.setLayoutManager(new LinearLayoutManager(this));
    }
}