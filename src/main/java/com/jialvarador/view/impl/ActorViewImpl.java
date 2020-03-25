
package com.jialvarador.view.impl;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.hibernate.HibernateException;
import org.primefaces.context.RequestContext;
import org.sii.core.utility.FacesUtils;
import com.jialvarador.data.entity.Actor;
import com.jialvarador.data.service.ActorService;

@ManagedBean
public class ActorViewImpl implements Serializable {

  private static final long serialVersionUID = 1L;

  //@Autowired
  private ActorService actorService;
  
  private Actor selectedActor;

  public Actor getSelectedActor() {
	return selectedActor;
}

public void setSelectedActor(Actor selectedActor) {
	this.selectedActor = selectedActor;
}
private Actor actor;

  private String buttonAction;

  private boolean editable;

  private List<Actor> listaActor;

  public ActorViewImpl() {    
    if (actor == null) {
      actor = new Actor();
      this.setButtonAction("Guardar");
      this.setEditable(false);
    } else {
      this.setButtonAction("Actualización");
      this.setEditable(true);
    }
  }

  public void inicializar() {
    actor = new Actor();
    listaActor = actorService.actorList();
  }

  public List<Actor> getArticleList() {
    return actorService.actorList();
  }

  public String almacenar() {
    actorService.addActor(actor);
    actor = new Actor();
    info();
    inicializar();
    return null;
  }
  
  public String actualizar(Actor actor1) {
	    actorService.updateActor(actor1);
	    info();
	    inicializar();
	    return null;
	  }
  
  public String eliminar(Actor actor1) {
	System.out.println("--> "+actor1);
	try {
    actorService.deleteActor(actor1);
    }catch(HibernateException ex) {
    	System.out.println(ex.getMessage());
    }
    //inicializar();
    //FacesUtils.addInfoMessage("Ha sido eliminado");
    return ""; 
  }
  
  public String action_edit(ActionEvent evt) {
      selectedActor = (Actor) (evt.getComponent().getAttributes().get("selectedActor"));
      System.out.println("--> "+selectedActor.getNombre());
      //RequestContext context = RequestContext.getCurrentInstance();
      //context.execute("PF('dlg1').show();");
      actorService.updateActor(selectedActor);
      return "";
  }
  public String deleteArticle(Actor actor) {
    actorService.deleteActor(actor);
    this.setButtonAction("Guardar");
    this.setEditable(false);
    info();
    inicializar();
    return null;
  }


public String actualizar() {
  
  return null;
}
 

  public static void info() {
    FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
            "El registro se ha agregado correctamente."));
  }
 
  /**/

  public Actor getActor() {
    return actor;
  }

  public void setActor(Actor actor) {
    this.actor = actor;
  }

  public String getButtonAction() {
    return buttonAction;
  }

  public void setButtonAction(String buttonAction) {
    this.buttonAction = buttonAction;
  }

  public boolean isEditable() {
    return editable;
  }

  public void setEditable(boolean editable) {
    this.editable = editable;
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

}
