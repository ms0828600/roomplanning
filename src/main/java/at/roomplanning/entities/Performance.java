package at.roomplanning.entities;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Performance")
public class Performance {

	public static enum Type {
		NEUINSZENIERUNG, WIEDERAUFNAHME, REPERTOIRE, STANDARD
	}	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Employee> employees;

	private Type type;

	@OneToMany (cascade = CascadeType.ALL, mappedBy = "performance")
	private Set<Rehearsal> rehearsals;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "rehearsalType")
	private Set<Performance_RehearsalType> rehearsalTypes;	
	
	public Performance() {
		this.employees = new HashSet<Employee>();
		this.setRehearsals(new HashSet<Rehearsal>());
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Type getPerformanceType() {
		return this.type;
	}

	public void setPerformanceType(Type type) {
		this.type = type;
	}

	public Set<Rehearsal> getRehearsals() {
		return rehearsals;
	}

	public void setRehearsals(HashSet<Rehearsal> rehearsals) {
		this.rehearsals = rehearsals;
	}

}
