package com.example.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.db.pojo.Alumno;

import java.util.ArrayList;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.ViewHolder> {
    ArrayList<Alumno> nAlumno;

    public AlumnoAdapter(ArrayList<Alumno> nAlumno) {
        this.nAlumno = nAlumno;
    }

    @NonNull
    @Override
    public AlumnoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View alumnoView = inflater.inflate(R.layout.alumno_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(alumnoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoAdapter.ViewHolder viewHolder, int i) {
        Alumno alumno = nAlumno.get(i);
        viewHolder.txtCodigo.setText(alumno.getCodigo());
        viewHolder.txtNombre.setText(alumno.getNombre());
        viewHolder.txtEdad.setText(alumno.getEdad().toString());
        viewHolder.txtDireccion.setText(alumno.getDireccion());

    }

    @Override
    public int getItemCount() {
        return nAlumno.size();
    }

    //Obtain view and parse the view
    public class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView txtCodigo, txtNombre, txtEdad, txtDireccion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCodigo = itemView.findViewById(R.id.txtCodigo);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtEdad = itemView.findViewById(R.id.txtEdad);
            txtDireccion = itemView.findViewById(R.id.txtDireccion);

        }
    }
}
