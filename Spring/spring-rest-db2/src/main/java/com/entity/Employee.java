package com.entity;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "employee_table2")
public class Employee {
	
	@Id
	@GeneratedValue
	private int empID;
	private String empName;
	private String empCity;
	
	@JoinColumn(name = "joining_data")
	@OneToOne(cascade = CascadeType.ALL)
	private Project project;
	
	

}
