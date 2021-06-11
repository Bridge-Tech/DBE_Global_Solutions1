package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.model.User;

@Named
@RequestScoped
public class UserBean {
	
	private User user = new User();
	
	public String save() {
		new UserDAO().save(this.user);
		System.out.println("saving..." + this.user);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Usuários Cadastrado com sucesso"));
		return "login?Faces-redirect=true";
	}
	
	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean exist = new UserDAO().exist(user);
		if(exist) {
			
			context.getExternalContext().getSessionMap().put("user",user);
			return "index?faces-redirect=true";
			}
		
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login Inválido",""));
		return "login?faces-redirect=true";
	}
	
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("user");
		
		return "login?Faces-redirect=true";
	}
	
	public String redirectRegister() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("user");
		
		return "register?Faces-redirect=true";
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getAllUsers(){
		
		return new UserDAO().getAll();
	}
}
