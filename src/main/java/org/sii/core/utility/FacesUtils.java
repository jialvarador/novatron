package org.sii.core.utility;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import com.sun.faces.component.visit.FullVisitContext;

/**
 * JSF utilities.
 */
public class FacesUtils {
	
	
	
	/**
	 * Get servlet context.
	 * 
	 * @return the servlet context
	 */
	public static ServletContext getServletContext() {
		return (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	}

	public static ExternalContext getExternalContext() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext();
	}

	public static HttpSession getHttpSession(boolean create) {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(create);
	}

	public static void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);

	}

	public static Object getManagedBeanFromSession(String beanName) {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(beanName);
	}

	
	/**
	 * Store the managed bean inside the session scope.
	 * 
	 * @param beanName    the name of the managed bean to be stored
	 * @param managedBean the managed bean to be stored
	 */
	public static void setManagedBeanInSession(String beanName, Object managedBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(beanName, managedBean);
	}

	/**
	 * Get parameter value from request scope.
	 * 
	 * @param name the name of the parameter
	 * @return the parameter value
	 */
	public static String getRequestParameter(String name) {
		return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
	}

	/**
	 * Add information message.
	 * 
	 * @param msg the information message
	 */
	public static void addInfoMessage(String idMsg) {
		addInfoMessage(null, idMsg);
	}

	/**
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @param idComponent
	 * @param msg
	 */
	public static void addInfoMessage(String idComponent, String idMsg) {
		FacesContext.getCurrentInstance().addMessage(
				((idComponent != null) ? findComponentById(idComponent).getClientId() : null),
				new FacesMessage(FacesMessage.SEVERITY_INFO, idComponent, idMsg));
	}

	/**
	 * Add error message.
	 * 
	 * @param msg the error message
	 */
	public static void addErrorMessage(String idMsg) {
		if (idMsg == null || idMsg.equals("null")) {
			idMsg = "msgContactarAlAdministrador";
		}
		addErrorMessage(null, idMsg);
	}

	/**
	 * Add error message.
	 * 
	 * @param msg the error message
	 */
	public static void addErrorMessageParams(String idMsg, Long sendMenos1, String... params) {
		addErrorMessageParams(null, idMsg, params);
	}

	/**
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @param idComponent
	 * @param msg
	 */
	public static void addErrorMessage(String idComponent, String idMsg) {

		String message = errorComponentLogic(idMsg);

		FacesContext.getCurrentInstance().addMessage(
				((idComponent != null) ? findComponentById(idComponent).getClientId() : null),
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}

	/**
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @param idComponent
	 * @param msg
	 */
	public static void addErrorMessageParams(String idComponent, String idMsg, String... params) {

		String message = errorComponentLogic(idMsg);

		if (message != null && params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				String s = "\\$" + (i + 1);
				message = message.replaceAll(s, params[i]);
			}
		}

		FacesContext.getCurrentInstance().addMessage(
				((idComponent != null) ? findComponentById(idComponent).getClientId() : null),
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}

	/**
	 * Add Warning message.
	 * 
	 * @param msg the Warning message
	 */
	public static void addWarningMessage(String idMsg) {
		addWarningMessage(null, idMsg);
	}

	/**
	 * Add Warning message.
	 * 
	 * @param msg the Warning message
	 */
	public static void addWarningMessageParams(String idMsg, String... params) {
		addWarningMessageParams(null, idMsg, params);
	}

	/**
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @param idComponent
	 * @param msg
	 */
	public static void addWarningMessage(String idComponent, String idMsg) {

		String message = errorComponentLogic(idMsg);

		FacesContext.getCurrentInstance().addMessage(
				((idComponent != null) ? findComponentById(idComponent).getClientId() : null),
				new FacesMessage(FacesMessage.SEVERITY_WARN, message, message));
	}

	/**
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @param idComponent
	 * @param msg
	 */
	public static void addWarningMessageParams(String idComponent, String idMsg, String... params) {

		String message = errorComponentLogic(idMsg);

		if (message != null && params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				message = message.replaceAll("$" + (i + 1), params[i]);
			}
		}

		FacesContext.getCurrentInstance().addMessage(
				((idComponent != null) ? findComponentById(idComponent).getClientId() : null),
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}

	/**
	 * 
	 * @return
	 */
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}

	/**
	 * 
	 * @param o Put an object in session
	 */
	public static void putinSession(String name, Object o) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute(name, o);
	}

	/**
	 * 
	 * @param o Remove an object from session
	 */
	public static void removeFromSession(String name) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.removeAttribute(name);
	}

	/**
	 * 
	 * @param name
	 * @return object from session
	 */

	public static Object getfromSession(String name) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session.getAttribute(name);
	}

	/**
	 * 
	 * @return
	 */

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	/**
	 * 
	 * @param name
	 * @param o
	 */
	public static void putinRequest(String name, Object o) {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		request.setAttribute(name, o);
	}

	/**
	 * 
	 * @param name
	 * @return object from request
	 */

	public static Object getfromRequest(String name) {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		return request.getAttribute(name);
	}

	
	
	
	public static void showDialog(String nameDialog) throws Exception {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('" + nameDialog + "').show()");
	}

	public static void hideDialog(String nameDialog) throws Exception {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('" + nameDialog + "').hide()");
	}

	public static void filterTable(String nameTable) throws Exception {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('" + nameTable + "').filter()");
	}

	public static void clearFilterTable(String nameTable) throws Exception {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('" + nameTable + "').clearFilters()");
	}

	/**
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 */
	public static void errorComponent(String idComponent, String message) {
		FacesContext.getCurrentInstance().addMessage(idComponent,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, null, message));
	}

	/**
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 */
	public static void info(String idComponent, String message) {
		FacesContext.getCurrentInstance().addMessage(idComponent,
				new FacesMessage(FacesMessage.SEVERITY_INFO, null, message));
	}

	/**
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 */
	public static String capitalizeString(String string) {
		char[] chars = string.toLowerCase().toCharArray();
		boolean found = false;
		for (int i = 0; i < chars.length; i++) {
			if (!found && Character.isLetter(chars[i])) {
				chars[i] = Character.toUpperCase(chars[i]);
				found = true;
			} else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') { // You can add other
																									// chars here
				found = false;
			}
		}
		return String.valueOf(chars);
	}

	/**
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 */
	public static UIComponent findComponentById(final String id) {
		FacesContext context = FacesContext.getCurrentInstance();
		UIViewRoot root = context.getViewRoot();
		final UIComponent[] found = new UIComponent[1];

		root.visitTree(new FullVisitContext(context), new VisitCallback() {
			@Override
			public VisitResult visit(VisitContext context, UIComponent component) {
				if (component != null && component.getId() != null && component.getId().equals(id)) {
					found[0] = component;
					return VisitResult.COMPLETE;
				}
				return VisitResult.ACCEPT;
			}
		});
		return found[0];
	}

	public static String errorComponentLogic(String lblName) {
		System.out.println("------ " + lblName);
		String message = "";
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msgs");
			message = bundle.getString(lblName);
		} catch (Exception e) {
			
		}
		return message;
	}

	/**
	 * Add information message.
	 * 
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @param msg the information message
	 */
	public static void addInfoOnlyMessage(String msg) {
		addInfoOnlyMessage(null, msg);
	}

	/**
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @param idComponent
	 * @param msg
	 */
	public static void addInfoOnlyMessage(String idComponent, String msg) {
		FacesContext.getCurrentInstance().addMessage(
				((idComponent != null) ? findComponentById(idComponent).getClientId() : null),
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}

	/**
	 * Add error message.
	 * 
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @param msg the error message
	 */
	public static void addErrorOnlyMessage(String msg) {
		addErrorOnlyMessage(null, msg);
	}

	/**
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @param idComponent
	 * @param msg
	 */
	public static void addErrorOnlyMessage(String idComponent, String msg) {
		FacesContext.getCurrentInstance().addMessage(
				((idComponent != null) ? findComponentById(idComponent).getClientId() : null),
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	}

	/**
	 * Método para valida emails
	 * 
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @param sEmail el email a verificar
	 * @return true si es un email válido, false en caso que no sea así.
	 */
	public static boolean isValidEmail(String sEmail) {
		boolean isValid = false;

		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pat = Pattern.compile(EMAIL_PATTERN);
		Matcher mat = pat.matcher(sEmail);

		if (pat.matcher(sEmail).matches()) {
			isValid = true;
		} else {
			isValid = false;
		}
		return isValid;
	}
}
