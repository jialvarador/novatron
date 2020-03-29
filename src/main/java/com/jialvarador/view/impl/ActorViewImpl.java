
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

import com.jialvarador.data.entity.Autor;
import com.jialvarador.data.service.ActorService;
import com.jialvarador.data.service.AutorService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean
@SessionScoped
public class ActorViewImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private AutorService autorService;
	
	

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
	private List<Autor> listaActor;

	public ActorViewImpl() {
		if (autor == null) {
			autor = new Autor();
		}
	}

	public void inicializar() {
		autor = new Autor();
		selectedActor = new Autor();
		listaActor = autorService.actorList();
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
	
	
	/**
	  * Retrieves a JRDataSource from a Hibernate HQL query. 
	  * This datasource is a Java List wrapper.
	  * @return
	  */
	 @SuppressWarnings("unchecked")
	 private JRDataSource getDatasource() {
	  List<Autor> result = autorService.actorList();
	  // Wrap the collection in a JRBeanCollectionDataSource
	  // This is one of the collections that Jasper understands
	  JRDataSource ds = new JRBeanCollectionDataSource(result);
	  // Return the datasource
	  return ds;
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

	public List<Autor> getListaActor() {
		try {
			if (listaActor == null) {
				listaActor = autorService.actorList();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaActor;
	}

	public void setListaActor(List<Autor> listaActor) {
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

}
