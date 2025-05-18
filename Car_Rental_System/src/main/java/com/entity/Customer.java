package com.entity;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name="Customer_Table")
public class Customer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Customer_Id")
	private int ctrid;
	@Column(name="Customer_Name")
	private String name;
	@Column(name="Customer_Email")
	private String email;
	@Column(name="Booking_Date")
	private LocalDate start;
	@Column(name="Returning_Date")
	private LocalDate end;
	@OneToOne
	private Car car;
	
	
	public int getCtrid() {
		return ctrid;
	}
	public void setCtrid(int ctrid) {
		this.ctrid = ctrid;
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
	
	
	public LocalDate getStart() {
		return start;
	}
	public void setStart(LocalDate start) {
		this.start = start;
	}
	
	
	public LocalDate getEnd() {
		return end;
	}
	public void setEnd(LocalDate end) {
		this.end = end;
	}
	
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	@Override
	public String toString() {
		return "Customer [ctrid=" + ctrid + ", name=" + name + ", email=" + email + ", start=" + start + ", end=" + end
				+ ", car=" + car + "]";
	}
}
