package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "project_table2")
public class Project {
	
	@Id
	@GeneratedValue
	private int projectID;
	private String projectName;
	private int projectBudget;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private Employee employee;

}
