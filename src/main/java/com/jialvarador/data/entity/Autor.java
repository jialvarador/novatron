package com.jialvarador.data.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Autor implements Serializable {

   
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActor;

    private String nombre;

    private String apellidoPaterno;
    
    private String apellidoMaterno;

    private String actualizacion;

  
    public Autor() {
    }


    public int getIdActor() {
      return idActor;
    }


    public void setIdActor(int idActor) {
      this.idActor = idActor;
    }


    public String getNombre() {
      return nombre;
    }


    public void setNombre(String nombre) {
      this.nombre = nombre;
    }


    public String getApellidoPaterno() {
      return apellidoPaterno;
    }


    public void setApellidoPaterno(String apellidoPaterno) {
      this.apellidoPaterno = apellidoPaterno;
    }


    public String getApellidoMaterno() {
      return apellidoMaterno;
    }


    public void setApellidoMaterno(String apellidoMaterno) {
      this.apellidoMaterno = apellidoMaterno;
    }


    public String getActualizacion() {
      return actualizacion;
    }


    public void setActualizacion(String actualizacion) {
      this.actualizacion = actualizacion;
    }




}
