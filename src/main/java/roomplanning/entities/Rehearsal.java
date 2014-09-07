package roomplanning.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * This class stores the rehearsals of a performance,
 * with the date, the room, and so on.
 *
 */
@Data
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
	private Process rehearsalType;

	public void setId(Long id) {
		this.id = id;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void setRehearsalType(Process rehearsalType) {
		this.rehearsalType = rehearsalType;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	
}
