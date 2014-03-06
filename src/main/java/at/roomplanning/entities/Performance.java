package at.roomplanning.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	@JoinTable(
			name = "Employee_Performance",
			joinColumns = @JoinColumn(name = "Performance_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn (name = "Employee_id", referencedColumnName = "id")
	)
	private Set<Employee> employees;

	@ManyToOne(cascade = CascadeType.ALL)
	private PerformanceType performanceType;

	public Performance() {
		this.employees = new HashSet<Employee>();
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
		return performanceType;
	}

	public void setPerformanceType(PerformanceType performanceType) {
		this.performanceType = performanceType;
	}

}
