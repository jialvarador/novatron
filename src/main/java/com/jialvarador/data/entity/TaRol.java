package com.jialvarador.data.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class TaRol implements java.io.Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer idRol;
	private String nombre;
	private String descripcion;
	private String path;
	private String requeridos;
	private Set<TaUsuario> taUsuarios = new HashSet<TaUsuario>(0);

	public TaRol() {
	}

	public TaRol(Integer idRol, String nombre, String descripcion, String path, String requeridos,
			Set<TaUsuario> taUsuarios) {
		this.idRol = idRol;
		this.descripcion = descripcion;
		this.path = path;
		this.taUsuarios = taUsuarios;
	}

	@Id
	@Column(name = "id_rol")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	@Column(name="nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "path")
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name="requeridos")
	public String getRequeridos() {
		return requeridos;
	}

	public void setRequeridos(String requeridos) {
		this.requeridos = requeridos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taRol")
	public Set<TaUsuario> getTaUsuarios() {
		return this.taUsuarios;
	}

	public void setTaUsuarios(Set<TaUsuario> taUsuarios) {
		this.taUsuarios = taUsuarios;
	}
}
