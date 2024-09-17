package com.wipro.Hibernate_Jpa_Crud_Operation.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Company {
		@Id
		private int id;
		private String name;
		private String email;
		private String address;
		private int noOfEmployee;
		
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
}
