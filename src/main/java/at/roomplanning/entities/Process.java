package at.roomplanning.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity(name = "Process")
public class Process {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column (nullable = false)
	private String name;

	// Duration in minutes (max-Time)
	private int duration;
	
	// This value is set over the table Performance_RehearsalType
	@Transient
	private int count;
	
	// This type can have several parents which point to this node
	@OneToMany (cascade = CascadeType.ALL)
	private Set<Process> previous;
	
	@ManyToOne (optional = true)
	private Process next;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "performance")
	private Set<Performance_Process> performances;		

	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Role> roles;
	
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Room> rooms;	
	
	@OneToMany (cascade = CascadeType.ALL)
	private Set<Rehearsal> rehearsals;

	public Process() {
		this.previous = new HashSet<Process>();
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

	public void setType(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Set<Process> getPrevious() {
		return previous;
	}

	public void setPrevious(Set<Process> previous) {
		this.previous = previous;
	}

	public Process getNext() {
		return next;
	}

	public void setNext(Process next) {
		this.next = next;
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
