package com.lmsf.Simple_JPA_App.entities;

import jakarta.persistence.*;

@Entity // <- Used to indicate that the class is mapped to a database table
@Table(name="guests") // <- Map to the corresponding table
public class Guest {
	
	@Id // <- PRIMARY KEY	
	@GeneratedValue(strategy=GenerationType.IDENTITY) // <- Specify how to assign primary keys for new objects
	@Column(name="id") // <- Map to the corresponding column of the table
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="room_number")
	private int roomNum;
	
	@Column(name="arrival")
	private String arrivalDate;
	
	@Column(name="departure")
	private String departureDate;
	
	// DEFAULT CONSTRUCTOR REQUIRED BY JPA
	public Guest() {}

	public Guest(String name, String email, int roomNum, String arrivalDate, String departureDate) {
		this.name = name;
		this.email = email;
		this.roomNum = roomNum;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}
	
	// Getters and Setters:

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	
	// toString to print out the Guest object:
	
	@Override
	public String toString() {
		return "\nGUEST INFO:\n[id=" + id + ", name=" + name + ", email=" + email + ", roomNum=" + roomNum + ", arrivalDate="
				+ arrivalDate + ", departureDate=" + departureDate + "]";
	}
	
	
	
	
	
	 
	 
}
