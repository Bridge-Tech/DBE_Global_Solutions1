package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.HotelDAO;
import br.com.fiap.model.Hotel;

@Named
@RequestScoped
public class HotelBean {
private Hotel hotel = new Hotel();
	
	public void save() {
		new HotelDAO().save(this.hotel);
		System.out.println("saving..." + this.hotel);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Hotel cadastrado com sucesso"));
	}
	
	
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public List<Hotel> getAllHotels(){
		
		return new HotelDAO().getAll();
	}
}
