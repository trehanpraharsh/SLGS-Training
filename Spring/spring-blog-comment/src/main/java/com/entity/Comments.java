package com.entity;

import javax.persistence.*;
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor

@Entity
@Table(name = "comments")
public class Comments {
	
	@Id
	@GeneratedValue
	private int commentID;
	private String commentBody;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "blog_id")
	private Blogs blog;

	public Comments(String commentBody) {
		super();
		this.commentBody = commentBody;
	}
	
	

}
