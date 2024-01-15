package com.homework.gymsystem.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_student")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Instant registrationDate;
	private String address;
	private String telephone;
	private String birthDate;
	private Double height;
	private Float weight;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "students")
	private List<Classroom> classrooms = new ArrayList<>();
	
	public Student() {
		
	}
	public Student(Long id, String name, Instant registrationDate, String address, String telephone, String birthDate,
			Double height, Float weight) {
		super();
		this.id = id;
		this.name = name;
		this.registrationDate = registrationDate;
		this.address = address;
		this.telephone = telephone;
		this.birthDate = birthDate;
		this.height = height;
		this.weight = weight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Instant registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}	
	public List<Classroom> getClassrooms() {
		return classrooms;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(id, other.id);
	}
	
}
