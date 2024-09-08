package com.lmsf.spring_data_jpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// ENTITY FOR THE TABLE TO BE GENERATED:

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
@Table(name = "students_data_jpa")
public class Student {
	
	public enum Gender {
		Male,
		Female,
		Other
	}
	
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable =false)
	private String lastName;
	
	@Column(name="date_of_birth", nullable = false)
	private String dateOfBirth;
	
	@Column(name="email", unique =true)
	private String email;  
	
	
	@Column(name="gender")
	@Enumerated(value = EnumType.STRING)
	private Gender gender;
	
	@Column(name="phone_number")
	private String phoneNumber;
}
