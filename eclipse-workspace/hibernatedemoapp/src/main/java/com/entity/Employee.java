package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor

@Entity
@Table(name = "hib_emp")
public class Employee {
	
	@Id
	@GeneratedValue
	private int empID;
	@Column(name = "emp_name", nullable = false, length = 30)
	private String empName;
	private String empLocation;

}
