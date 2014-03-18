package at.roomplanning.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity (name = "Room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	

	private String name;
	
	private String location;
	
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<RehearsalType> rehearsalTypes;

	@OneToMany (cascade = CascadeType.ALL)
	private Set<Rehearsal> rehearsals;	
	
	public Room() {
		this.rehearsals = new HashSet<Rehearsal>();
		this.rehearsalTypes = new HashSet<RehearsalType>();
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<RehearsalType> getRehearsalTypes() {
		return rehearsalTypes;
	}

	public void setRehearsalTypes(Set<RehearsalType> rehearsalTypes) {
		this.rehearsalTypes = rehearsalTypes;
	}

	public Set<Rehearsal> getRehearsals() {
		return rehearsals;
	}

	public void setRehearsals(Set<Rehearsal> rehearsals) {
		this.rehearsals = rehearsals;
	}
	
}
