package at.roomplanning.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity (name = "Rehearsal")
public class Rehearsal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Temporal (TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToOne
	private Performance performance;
	
	@OneToOne
	private Room room;
	
	// Time in minutes
	private int duration;
	
	@OneToOne
	private RehearsalType rehearsalType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public RehearsalType getRehearsalType() {
		return rehearsalType;
	}

	public void setRehearsalType(RehearsalType rehearsalType) {
		this.rehearsalType = rehearsalType;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	
}
