package com.lmsf.spring_batch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="students_batch")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	public enum Gender {
		Male,
		Female,
		Other
	}
	
	// Definir attributos
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable =false)
	private String lastName;
	
	@Column(name="date_of_birth", nullable = false)
	private String dateOfBirth;
	
	@Column(name="email")
	private String email;  
	
	
	@Column(name="gender")
	@Enumerated(value = EnumType.STRING)
	private Gender gender;
	
	@Column(name="phone_number")
	private String phoneNumber;

}
