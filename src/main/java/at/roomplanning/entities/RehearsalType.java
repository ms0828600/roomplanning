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

@Entity(name = "RehearsalType")
public class RehearsalType {
	
	public static enum Type {
		KORREPETITIONSPROBE, SZENISCHEPROBE, ENSEMBLEPROBE, CHORALLEINPROBE, ORCHESTERALLEINPROBE,
		BUEHNENPROBE, KLAVIERPROBE, ORCHESTERHAUPTPROBE, GENERALPROBE, PREMIERE
	}	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.ORDINAL)
	@Column (nullable = false)
	private Type type;

	// Duration in minutes
	private int duration;
	
	// This type can have several parents which point to this node
	@OneToMany (cascade = CascadeType.ALL)
	private Set<RehearsalType> previous;
	
	@ManyToOne (optional = true)
	private RehearsalType next;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "performance")
	private Set<Performance_RehearsalType> performances;		

	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Role> roles;
	
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Room> rooms;	
	
	@OneToMany (cascade = CascadeType.ALL)
	private Set<Rehearsal> rehearsals;

	public RehearsalType() {
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
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
