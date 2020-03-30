
package com.jialvarador.view.impl;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.sii.core.utility.FacesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jialvarador.data.entidad.Actor;
import com.jialvarador.data.entidad.City;
import com.jialvarador.data.entidad.Country;
import com.jialvarador.data.entidad.Address;
import com.jialvarador.data.entity.Autor;
import com.jialvarador.data.service.ActorService;
import com.jialvarador.data.service.AutorService;
import com.jialvarador.data.service.CityService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@ManagedBean
@SessionScoped
public class ActorViewImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private AutorService autorService;
	
	@Autowired
	private ActorService actorService;
	
	@Autowired
	private CityService<City> cityService;
	
	
	

	public CityService<City> getCityService() {
		return cityService;
	}

	public void setCityService(CityService<City> cityService) {
		this.cityService = cityService;
	}

	public void setActorService(ActorService actorService) {
		this.actorService = actorService;
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int deleteEmployee(Autor e) {
		String query = "delete from autor where idActor='" + e.getIdActor() + "' ";
		return jdbcTemplate.update(query);
	}

	private Autor selectedActor;
	private Autor autor;
	private List<Autor> listaAutor;
	private List<Actor>  listaActor;
	private List<City> listaCity;
	private List<Country> listaCountry;
	private List<Address> listaAddress;
   

	public ActorViewImpl() {
		if (autor == null) {
			autor = new Autor();
		}
	}

	public void inicializar() {
		autor = new Autor();
		selectedActor = new Autor();
		listaAutor = autorService.actorList();
		listaActor = actorService.list();
		listaCity = cityService.list();
		System.out.println(listaCity.size());
	}

	

	public String almacenar() {
		autorService.add(autor);
		autor = new Autor();
		FacesUtils.addInfoOnlyMessage("¡Accion exitosa!");
		inicializar();
		/*
		 * String query = "delete from Personaje where idActor=1 ";
		 * jdbcTemplate.update(query);
		 */
		return null;
	}

	public String actualizar() {
		System.out.println("-2-> " + selectedActor.getNombre());
		autorService.update(selectedActor);
		FacesUtils.addInfoOnlyMessage("¡Accion exitosa!");
		inicializar();
		return null;
	}

	public String eliminar(Autor actor1) {
		System.out.println("--> " + actor1);
		try {
			autorService.delete(actor1);
		} catch (HibernateException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		inicializar();
		FacesUtils.addInfoMessage("Ha sido eliminado");
		return "";
	}

	public String action_edit(ActionEvent evt) {
		selectedActor = (Autor) (evt.getComponent().getAttributes().get("selectedActor"));
		System.out.println("--> " + selectedActor.getNombre());
		// RequestContext context = RequestContext.getCurrentInstance();
		// context.execute("PF('dlg1').show();");
		// autorService.updateActor(selectedActor);
		return "";
	}

	
	/**
	 * Método que permite instanciar y acceder al método EliminarDocente de tipo
	 * DAO
	 * @throws SQLException 
	 */
	public void exportarPDF() throws JRException, IOException, SQLException{
		Connection Conexion = jdbcTemplate.getDataSource().getConnection();
		Map<String,Object> parametros= new HashMap<String,Object>();
		parametros.put("id","1");
		 File jasper = new
		 File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/coffee.jasper")); JasperPrint jasperPrint =
		 JasperFillManager.fillReport(jasper.getPath(),parametros, Conexion);
		 HttpServletResponse response = (HttpServletResponse)
		 FacesContext.getCurrentInstance().getExternalContext().getResponse();
		  response.addHeader("Content-disposition","attachment; filename=gastos.pdf");
		 ServletOutputStream stream = response.getOutputStream();
		 JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		 stream.flush(); stream.close();
		 FacesContext.getCurrentInstance().responseComplete();
		 System.out.println("Pdf Exportado...");
	}
	
	
	

	public Autor getActor() {
		return autor;
	}

	public void setActor(Autor autor) {
		this.autor = autor;
	}
	
	public List<Autor> getArticleList() {
		return autorService.actorList();
	}

	

	public List<Autor> getListaAutor() {
		return listaAutor;
	}

	public void setListaAutor(List<Autor> listaAutor) {
		this.listaAutor = listaAutor;
	}

	public List<Actor> getListaActor() {
		return listaActor;
	}

	public void setListaActor(List<Actor> listaActor) {
		this.listaActor = listaActor;
	}

	public AutorService getActorService() {
		return autorService;
	}

	public void setActorService(AutorService autorService) {
		this.autorService = autorService;
	}

	public Autor getSelectedActor() {
		return selectedActor;
	}

	public void setSelectedActor(Autor selectedActor) {
		this.selectedActor = selectedActor;
	}


	public AutorService getAutorService() {
		return autorService;
	}

	public void setAutorService(AutorService autorService) {
		this.autorService = autorService;
	}

	public List<City> getListaCity() {
		return listaCity;
	}

	public void setListaCity(List<City> listaCity) {
		this.listaCity = listaCity;
	}

	public List<Country> getListaCountry() {
		return listaCountry;
	}

	public void setListaCountry(List<Country> listaCountry) {
		this.listaCountry = listaCountry;
	}

	public List<Address> getListaAddress() {
		return listaAddress;
	}

	public void setListaAddress(List<Address> listaAddress) {
		this.listaAddress = listaAddress;
	}

}
