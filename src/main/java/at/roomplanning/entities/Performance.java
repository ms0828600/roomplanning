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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Performance")
public class Performance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Employee> employees;

	@OneToOne
	private PerformanceType performanceType;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "processEntry")
	private Set<Performance_Process> processEntries;		
	

	public Set<Performance_Process> getProcessEntries() {
		return processEntries;
	}

	public void setProcessEntries(Set<Performance_Process> processEntries) {
		this.processEntries = processEntries;
	}

	@OneToMany (cascade = CascadeType.ALL, mappedBy = "performance")
	private Set<Rehearsal> rehearsals;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "processEntry")
	private Set<Performance_Process> rehearsalTypes;	
	
	public Performance() {
		this.employees = new HashSet<Employee>();
		this.setRehearsals(new HashSet<Rehearsal>());
		this.processEntries = new HashSet<Performance_Process>();
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

	public PerformanceType getPerformanceType() {
		return this.performanceType;
	}

	public void setPerformanceType(PerformanceType type) {
		this.performanceType = type;
	}

	public Set<Rehearsal> getRehearsals() {
		return rehearsals;
	}

	public void setRehearsals(HashSet<Rehearsal> rehearsals) {
		this.rehearsals = rehearsals;
	}

}
