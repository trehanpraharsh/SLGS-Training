package com.entity;

import java.util.List;
import javax.persistence.*;


//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString

@Entity
@Table(name = "owner")
public class Owner {
	
	@Id
	@GeneratedValue
	private int ownerID;
	private String name;
	private String email;
	
	//We did this here as two owners cannot write the same blog but one owner can write multiple blogs
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private List<Blogs> blogList;

	public Owner(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	
	

}
