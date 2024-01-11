package com.homework.gymsystem.entities;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_classroom")
public class Classroom implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime scheduledTime, startDate, endDate;	//horário agendado
	private Long duration;
	
	@ManyToOne
	@JoinColumn(name = "activity")
	private Activity activity;
	
	public Classroom() {
		
	}
	public Classroom(Long id, LocalDateTime scheduledTime, LocalDateTime startDate, LocalDateTime endDate, Activity activity) {
		super();
		this.id = id;
		this.scheduledTime = scheduledTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.activity = activity;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getScheduledTime() {
		return scheduledTime;
	}
	public void setScheduledTime(LocalDateTime scheduledTime) {
		this.scheduledTime = scheduledTime;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}	
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
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
		Classroom other = (Classroom) obj;
		return Objects.equals(id, other.id);
	}
	
	public Long duration() {
		Duration duration = Duration.between(getStartDate(), getEndDate());
		return duration.toDays();
	}

}
