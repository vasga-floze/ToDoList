package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

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
        AlumnoDAO adao = new AlumnoDAO(this);
        ArrayList<Alumno> alumnos = adao.getAll();
        Alumno a = new Alumno();
        for(int i = 0; i< alumnos.size(); i++){
            a = alumnos.get(i);
            Log.i("alumnos", a.toString());
        }
/*
        MySQLiteOpenHelper mydb = new MySQLiteOpenHelper( this, "registro_academico",1);
        Log.i("test", mydb.getDatabaseName());

        SQLiteDatabase db = mydb.getWritableDatabase();

        //CRUD(Create, Retrieve, Update, Delete)

        //CREATE
        final int random = new Random().nextInt(999999);
        final int edad = new Random().nextInt(80 )+20;

        ContentValues data = new ContentValues();
        String cod = "SMIS" + String.valueOf(random);

        data.put("codigo", cod);
        Log.i("insert", cod);

        data.put("nombre", "Estudiante" + cod);
        Log.i("insert", "Estudiante"+cod);

        data.put("edad", edad);
        Log.i("insert", String.valueOf(edad));

        data.put("direccion", "Direccion"+cod);
        Log.i("insert", "Direccion"+cod);

        Long id = db.insert("alumnos", null, data);
        if(id != -1) {
            Log.i("insert", "Insert completado con exito; id " +
            "del usuario es: "+String.valueOf(id));
        } else {
            Log.i("insert", "Ocurrio un error al crear el usuario");
        }

        String sql_query = "SELECT * FROM alumnos";
        String[] params = new String[0];
        Cursor rows = db.rawQuery(sql_query, params);
        if(rows.moveToFirst()){
            Log.i("retrieve", "---------------");
            Log.i("retrieve", "Total: " + String.valueOf(rows.getCount()));
            do{
                Log.i("retrieve", rows.getString(0));
                Log.i("retrieve", rows.getString(1));
                Log.i("retrieve", rows.getString(2));
                Log.i("retrieve", "---------------");
            }while(rows.moveToNext());
        } */
    }
}