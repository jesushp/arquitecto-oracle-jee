package org.apz.curso.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "pageBean")
@RequestScoped
public class PageBean implements Serializable {
	
	private static final long serialVersionUID = 669181774422323400L;
	
	protected String title;
	protected String error;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	
	
}
