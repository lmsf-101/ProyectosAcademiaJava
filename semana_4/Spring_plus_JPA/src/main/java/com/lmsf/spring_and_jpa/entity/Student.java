package com.lmsf.spring_and_jpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
@Table(name = "students")
public class Student {
	
	public enum Gender {
		Male,
		Female,
		Other
	}
	
	// Definir attributos
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
