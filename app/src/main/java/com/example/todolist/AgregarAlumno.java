package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todolist.db.dao.AlumnoDAO;
import com.example.todolist.db.pojo.Alumno;

public class AgregarAlumno extends AppCompatActivity implements View.OnClickListener{
    public EditText edtCodigo, edtNombre, edtEdad, edtDireccion;
    public Button btnGuardar, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_alumno);
        edtCodigo = findViewById(R.id.edtCodigo);
        edtNombre = findViewById(R.id.edtName);
        edtEdad = findViewById(R.id.edtEdad);
        edtDireccion = findViewById(R.id.edtDireccion);
        btnGuardar = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.btnCancel:
                limpiar();
                break;
            case R.id.btnSave:
                String codigo = edtCodigo.getText().toString();
                String nombre = edtNombre.getText().toString();
                int edad = Integer.valueOf(edtEdad.getText().toString());
                String direccion = edtDireccion.getText().toString();
                Alumno a = new Alumno(codigo, nombre, edad, direccion);
                AlumnoDAO dao = new AlumnoDAO(AgregarAlumno.this);
                long res = dao.insert(a);
                if(res!= -1){
                    Toast.makeText(AgregarAlumno.this, "Alumno agregado. id: " + res,
                    Toast.LENGTH_LONG).show();
                    limpiar();
                }
                break;
        }
    }

    public void limpiar(){
        edtCodigo.setText("");
        edtNombre.setText("");
        edtEdad.setText("");
        edtDireccion.setText("");
    }
}