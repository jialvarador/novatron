package com.jialvarador.data.entity;

import javax.persistence.*;


@Entity
public class TaUsuario implements java.io.Serializable {
   
	private static final long serialVersionUID = 1L;
	private String idUsuario;
    private String search;
    private TaRol taRol;
    private Integer activacion;
    private String apMaterno;
    private String apPaterno;
   
 
    public TaUsuario() {
    }

    public TaUsuario(String idUsuario, String search,Integer activacion, String apMaterno,
        String apPaterno, String contrasenia, String email, Integer estatus,
        String fecha, Integer idCarrera, Integer idFacultad,
        TaRol taRol,
        String usuarioModifica) {
        this.idUsuario = idUsuario;
        this.search=search;
        this.taRol = taRol;
        this.activacion = activacion;
        this.apMaterno = apMaterno;
        this.apPaterno = apPaterno;
    }

    @Id
    @Column(name = "id_usuario", unique = true, nullable = false)
    public String getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Column(name="search", nullable =false)
    public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    public TaRol getTaRol() {
        return this.taRol;
    }

    public void setTaRol(TaRol taRol) {
        this.taRol = taRol;
    }

    @Column(name = "activacion", nullable = false)
    public Integer getActivacion() {
        return this.activacion;
    }

    public void setActivacion(Integer activacion) {
        this.activacion = activacion;
    }

    @Column(name = "ap_materno", nullable = false)
    public String getApMaterno() {
        return this.apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    @Column(name = "ap_paterno", nullable = false)
    public String getApPaterno() {
        return this.apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

   
   
   
      
   }
