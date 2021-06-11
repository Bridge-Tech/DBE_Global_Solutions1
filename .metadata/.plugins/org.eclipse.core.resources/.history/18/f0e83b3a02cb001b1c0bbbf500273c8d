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
	
	public void save() {
		new UserDAO().save(this.user);
		System.out.println("saving..." + this.user);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Usuários Cadastrado com sucesso"));
	}
	
	public String login() {
		boolean exist = new UserDAO().exist(user);
		System.out.println(exist);
		if(exist) {return "index?faces-redirect=true";}
		
		return "login?faces-redirect=true";
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
