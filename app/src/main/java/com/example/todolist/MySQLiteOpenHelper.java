package com.example.todolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public MySQLiteOpenHelper(Context context, String db, int version){
        super(context, db, null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 = "CREATE TABLE alumnos(codigo VARCHAR(10) PRIMARY KEY, " +
                "nombre VARCHAR(200), edad INTEGER, direccion VARCHAR(250))";

        String sql2 = "CREATE TABLE inscripciones(codigo INTEGER PRIMARY KEY, " +
                "codigo_estudiante VARCHAR(200), fecha_inscripcion VARCHAR(20), materias VARCHAR(250)," +
        "annio INTEGER, ciclo VARCHAR(1))";
        db.execSQL(sql1);
        db.execSQL(sql2);
    }

    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion){
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS alumnos");
            db.execSQL("DROP TABLE IF EXISTS inscripciones");
            onCreate(db);
        }

    }
}
