package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {
	@Id
    @Column(name = "id_hotel")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHotel;

	@Column(name = "nm_hotel")
    private String nameHotel;

    @Column(name = "ds_assessment")
    private String assessment;
    
    @Column(name="nu_bedrooms")
    private int nuBedrooms;
    
    @Column(name="nm_address")
    private String address;
    
    @Column(name="nr_phone")
    private String phone;
    
    public int getNuBedrooms() {
		return nuBedrooms;
	}

	public void setNuBedrooms(int nuBedrooms) {
		this.nuBedrooms = nuBedrooms;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getIdHotel() {
 		return idHotel;
 	}

 	public void setIdHotel(Long idHotel) {
 		this.idHotel = idHotel;
 	}

 	public String getNameHotel() {
 		return nameHotel;
 	}

 	public void setNameHotel(String nameHotel) {
 		this.nameHotel = nameHotel;
 	}

 	public String getAssessment() {
 		return assessment;
 	}

 	public void setAssessment(String assessment) {
 		this.assessment = assessment;
 	}

	@Override
	public String toString() {
		return "Hotel [idHotel=" + idHotel + ", nameHotel=" + nameHotel + ", assessment=" + assessment + "]";
	}
 	
 	
 	
}
