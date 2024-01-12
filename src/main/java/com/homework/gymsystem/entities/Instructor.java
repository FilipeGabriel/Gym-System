package com.homework.gymsystem.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_instructor")
public class Instructor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String identityCard;
	private String name;
	private LocalDateTime birthDate;
	private Integer titration;
	
	@OneToMany(mappedBy = "instructor")
	private Set<Classroom> classrooms = new HashSet<>();
			
	public Instructor() {
		
	}
	public Instructor(Long id, String identityCard, String name, LocalDateTime birthDate, Integer titration) {
		super();
		this.id = id;
		this.identityCard = identityCard;
		this.name = name;
		this.birthDate = birthDate;
		this.titration = titration;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}
	public Integer getTitration() {
		return titration;
	}
	public void setTitration(Integer titration) {
		this.titration = titration;
	}	
	public Set<Classroom> getClassrooms() {
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
		Instructor other = (Instructor) obj;
		return Objects.equals(id, other.id);
	}
	
}
