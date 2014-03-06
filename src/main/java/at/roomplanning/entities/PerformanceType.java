package at.roomplanning.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "PerformanceType")
public class PerformanceType {

	public static enum Type {
		CORREPETITION2PREMIERE, STAGEPERFORMANCE2PERMIERE, REPETOIRE, CONCERT
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	private Type type;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Performance> performances;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<RehearsalType> rehearsalTypes;
	
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Room> rooms;	

	public PerformanceType() {
		this.performances = new HashSet<Performance>();
		this.rehearsalTypes = new HashSet<RehearsalType>();
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Set<Performance> getPerformances() {
		return performances;
	}

	public void setPerformances(Set<Performance> performances) {
		this.performances = performances;
	}

}
