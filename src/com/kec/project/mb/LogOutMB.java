package com.kec.project.mb;

import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;



@ViewScoped
@ManagedBean (name="logOutMB")
public class LogOutMB  implements Serializable{
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = UserMB.INJECTION_NAME)
	private UserMB userMB;
	
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		ServletContext servletContext = request.getSession()
				.getServletContext();
		servletContext.removeAttribute("user-" + userMB.getUser().getUserId());
		request.getSession().invalidate();
		return "welcome";

	}

	public UserMB getUserMB() {
		return userMB;
	}

	public void setUserMB(UserMB userMB) {
		this.userMB = userMB;
	}
}
