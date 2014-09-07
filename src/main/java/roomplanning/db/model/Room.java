package roomplanning.db.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * This class stores all information about rooms for rehearsals,
 * performances, etc.
 *
 */
@Data
@Entity (name = "Room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	

	private String name;
	
	private String location;
	
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Process> rehearsalTypes;

	@OneToMany (cascade = CascadeType.ALL)
	private Set<Rehearsal> rehearsals;	
	
	@OneToMany (mappedBy = "room")
	private Set<Performance> performances;
	
	public Room() {
		this.rehearsals = new HashSet<Rehearsal>();
		this.rehearsalTypes = new HashSet<Process>();
	}
	
}
