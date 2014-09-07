package roomplanning.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class represents the process-chain.
 * Each entry of the process chain has a name, a 
 * predecessor and a successor.
 * If the @next value is set to null, we have reached
 * the final state of the process chain.
 * If @previous is set to null, we have the start of the
 * process chain
 */
@Data
@EqualsAndHashCode(exclude={"previous", "next"})
@Entity(name = "Process")
public class Process {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column (nullable = false)
	private String name;

	// Duration in minutes (max-Time)
	private int duration;
	
	// This type can have several parents which point to this node
	@OneToMany (cascade = CascadeType.ALL)
	private Set<Process> previous;
	
	@ManyToOne (optional = true)
	private Process next;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "performance")
	private Set<Performance_Process> performances;		

	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Function> roles;
	
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Room> rooms;	
	
	@OneToMany (cascade = CascadeType.ALL)
	private Set<Rehearsal> rehearsals;

	public Process() {
		this.previous = new HashSet<Process>();
		this.roles = new HashSet<Function>();
		this.rehearsals = new HashSet<Rehearsal>();
		this.rooms = new HashSet<Room>();
	}


}
