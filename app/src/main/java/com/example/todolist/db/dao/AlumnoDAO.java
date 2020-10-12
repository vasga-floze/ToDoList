package com.example.todolist.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.todolist.MySQLiteOpenHelper;
import com.example.todolist.db.pojo.Alumno;

import java.util.ArrayList;

public class AlumnoDAO {
    private MySQLiteOpenHelper mydb;
    private SQLiteDatabase db;

    public AlumnoDAO(Context c) {
        mydb = new MySQLiteOpenHelper(
                c, "registro_academico", 1);
        db = mydb.getWritableDatabase();
    }

    //This method add alumnos to sqlite allumnos table
    public long insert(Alumno a) {
        ContentValues data = new ContentValues();
        data.put("codigo", a.getCodigo());
        data.put("nombre", a.getNombre());
        data.put("edad", a.getEdad());
        data.put("direccion", a.getDireccion());
        return db.insert("alumnos", null, data);
    }

    //Delete an student from alumnos table
    public int delete(Alumno a) {
        String data[] = {a.getCodigo()};
        return db.delete("alumnos", "codigo=?", data);
    }

    //This method update alumnos to sqlite allumnos table
    public int update(Alumno a) {
        String where[] = {a.getCodigo()};
        ContentValues data = new ContentValues();
        data.put("codigo", a.getCodigo());
        data.put("nombre", a.getNombre());
        data.put("edad", a.getEdad());
        data.put("direccion", a.getDireccion());
        return db.update("alumnos", data, "codigo=?", where);
    }

    //This method obtain all registers of alumnos to sqlite alumnos table
    public ArrayList<Alumno> getAll() {
        ArrayList<Alumno> rows = new ArrayList<>();
        Cursor data = db.rawQuery("SELECT * FROM alumnos", null, null);
        if (data.moveToFirst()) ;
        {
            do {
                Alumno al = new Alumno();
                al.setCodigo(data.getString(0));
                al.setNombre(data.getString(1));
                al.setEdad(data.getInt(2));
                al.setDireccion(data.getString(3));
                rows.add(al);
            } while (data.moveToNext());
        }
        return rows;
    }

    //This method obtain all registers of alumnos to sqlite alumnos table BY ID
    public Alumno getByCodigo(String codigo){
        Cursor data = db.rawQuery("SELECT * FROM alumnos WHERE codigo=?",
                new String[]{}, null);
        Alumno al = null;
        if (data.moveToFirst()) ; {
            al.setCodigo(data.getString(0));
            al.setNombre(data.getString(1));
            al.setEdad(data.getInt(2));
            al.setDireccion(data.getString(3));
        }
        return al;
    }

    //This method obtain all registers of alumnos to sqlite alumnos table BY NAME
    public ArrayList<Alumno> getByName(String name) {
        ArrayList<Alumno> rows = new ArrayList<>();
        Cursor data = db.rawQuery("SELECT * FROM alumnos WHERE nombre LIKE ?", new String[]{"%"+name+"%"}, null);
        if (data.moveToFirst()) ;
        {
            do {
                Alumno al = new Alumno();
                al.setCodigo(data.getString(0));
                al.setNombre(data.getString(1));
                al.setEdad(data.getInt(2));
                al.setDireccion(data.getString(3));
                rows.add(al);
            } while (data.moveToNext());
        }
        return rows;
    }


}




