package com.example.todolist.db.pojo;

public class Alumno {
    private String codigo;
    private  String nombre;
    private  Integer edad;
    private  String direccion;

    public Alumno() {
    }

    @Override
    public String toString() {
        return "codigo='" + codigo + "'";
    }

    public Alumno(String codigo, String nombre, Integer edad, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
