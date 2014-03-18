package at.roomplanning.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "RehearsalType")
public class RehearsalType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	// Duration in minutes
	private int duration;
	
	// This type can have several parents which point to this node
	@OneToMany (cascade = CascadeType.ALL)
	private Set<RehearsalType> previous;
	
	@ManyToOne (optional = true)
	private RehearsalType next;
	
	// Number of rehearsal needed of the following type 
	// before we can go to the next node
	private int number;

	@OneToMany (cascade = CascadeType.ALL)
	private Set<PerformanceType> performanceTypes;
	
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Role> roles;
	
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Room> rooms;	
	
	@OneToMany (cascade = CascadeType.ALL)
	private Set<Rehearsal> rehearsals;

	public RehearsalType() {
		this.performanceTypes = new HashSet<PerformanceType>();
		this.previous = new HashSet<RehearsalType>();
		this.roles = new HashSet<Role>();
		this.rehearsals = new HashSet<Rehearsal>();
		this.rooms = new HashSet<Room>();
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Set<PerformanceType> getPerformanceTypes() {
		return performanceTypes;
	}

	public void setPerformanceTypes(Set<PerformanceType> performanceTypes) {
		this.performanceTypes = performanceTypes;
	}

	public Set<RehearsalType> getPrevious() {
		return previous;
	}

	public void setPrevious(Set<RehearsalType> previous) {
		this.previous = previous;
	}

	public RehearsalType getNext() {
		return next;
	}

	public void setNext(RehearsalType next) {
		this.next = next;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Rehearsal> getRehearsals() {
		return rehearsals;
	}

	public void setRehearsals(Set<Rehearsal> rehearsals) {
		this.rehearsals = rehearsals;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}


}
