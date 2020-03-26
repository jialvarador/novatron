
package com.jialvarador.view.impl;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hibernate.HibernateException;
import org.sii.core.utility.FacesUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jialvarador.data.entity.Actor;
import com.jialvarador.data.service.ActorService;

@ManagedBean
@SessionScoped
public class ActorViewImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ActorService actorService;

	private Actor selectedActor;
	private Actor actor;
	private List<Actor> listaActor;

	public ActorViewImpl() {
		if (actor == null) {
			actor = new Actor();
		}
	}

	public void inicializar() {
		actor = new Actor();
		selectedActor = new Actor();
		listaActor = actorService.actorList();
	}

	

	public String almacenar() {
		actorService.addActor(actor);
		actor = new Actor();
		FacesUtils.addInfoOnlyMessage("¡Accion exitosa!");
		inicializar();
		return null;
	}

	public String actualizar() {
		System.out.println("-2-> " + selectedActor.getNombre());
		actorService.updateActor(selectedActor);
		FacesUtils.addInfoOnlyMessage("¡Accion exitosa!");
		inicializar();
		return null;
	}

	public String eliminar(Actor actor1) {
		System.out.println("--> " + actor1);
		try {
			actorService.deleteActor(actor1);
		} catch (HibernateException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		inicializar();
		FacesUtils.addInfoMessage("Ha sido eliminado");
		return "";
	}

	public String action_edit(ActionEvent evt) {
		selectedActor = (Actor) (evt.getComponent().getAttributes().get("selectedActor"));
		System.out.println("--> " + selectedActor.getNombre());
		// RequestContext context = RequestContext.getCurrentInstance();
		// context.execute("PF('dlg1').show();");
		// actorService.updateActor(selectedActor);
		return "";
	}

	


	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
	public List<Actor> getArticleList() {
		return actorService.actorList();
	}

	public List<Actor> getListaActor() {
		try {
			if (listaActor == null) {
				listaActor = actorService.actorList();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaActor;
	}

	public void setListaActor(List<Actor> listaActor) {
		this.listaActor = listaActor;
	}

	public ActorService getActorService() {
		return actorService;
	}

	public void setActorService(ActorService actorService) {
		this.actorService = actorService;
	}

	public Actor getSelectedActor() {
		return selectedActor;
	}

	public void setSelectedActor(Actor selectedActor) {
		this.selectedActor = selectedActor;
	}

}
