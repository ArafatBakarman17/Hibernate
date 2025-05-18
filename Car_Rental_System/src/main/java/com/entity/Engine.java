package com.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Engine_Table")
public class Engine 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="eid")
	@SequenceGenerator(name = "eid", initialValue= 100, allocationSize=1)
	@Column(name="Engine_Id")
	private int id ;
	@Column(name="Engine_type")
	private String type;
	@Column(name="Engine_cc")
	private int cc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	@Override
	public String toString() {
		return "Engine [id=" + id + ", type=" + type + ", cc=" + cc + "]";
	}
}
