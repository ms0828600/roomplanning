package at.roomplanning.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "RehearsalType")
public class RehearsalType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	// Duration in minutes
	private int duration;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<PerformanceType> performanceTypes;

	public RehearsalType() {
		this.performanceTypes = new HashSet<PerformanceType>();
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

}
