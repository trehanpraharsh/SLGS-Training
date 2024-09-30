package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor

@Entity
@Table(name = "blogs")
public class Blogs {
	
	@Id
	@GeneratedValue
	private int blogID;
	private String title;
	private String category;
	private String content;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id")
	private Owner owner;

	public Blogs(String title, String category, String content) {
		super();
		this.title = title;
		this.category = category;
		this.content = content;
	}
	
	

}
