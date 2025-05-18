package com.entity;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="Cars_Table")
public class Car 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator = "carid")
	@SequenceGenerator(name = "carid", initialValue= 1000, allocationSize=1)
	
	@Column(name="Car_Id")
	private int cid;
	@Column(name="Car_Brand")
	private String brand;
	 @Column(name="Car_Model")
	private String model;
	
	private LocalDate registeredDate;
	
	@OneToOne
	private Engine engine;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Car [cid=" + cid + ", brand=" + brand + ", model=" + model + ", registeredDate=" + registeredDate
				+ ", engine=" + engine + "]";
	}
}
