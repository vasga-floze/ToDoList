package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.util.Range;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.todolist.db.dao.AlumnoDAO;
import com.example.todolist.db.pojo.Alumno;
//import com.example.todolist.db.pojo.Alumno;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button btnAgregarAlumno;
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
        //for(Alumno a : alumno){ //Para imprimir en el logcat los archivos existentes en la BD
        //   Log.i("estudiante", a.getNombre().toString());
        //}
        btnAgregarAlumno = findViewById(R.id.btnAdd);
        btnAgregarAlumno.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AgregarAlumno.class);
                startActivity(i);
            }
        });
    }
}