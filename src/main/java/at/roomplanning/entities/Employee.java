package at.roomplanning.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;

	private String familyName;
	
	//TODO: ENUM zugekauft/intern/...

	@OneToMany(mappedBy = "role")
	private Set<Employee_Role> employeeroles;

	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@ManyToMany(mappedBy="employees")
	private Set<Performance> performances;

	public Employee() {
		this.employeeroles = new HashSet<Employee_Role>(3);
		this.setPerformances(new HashSet<Performance>());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Set<Employee_Role> getEmployeeroles() {
		return employeeroles;
	}

	public void setEmployeeroles(Set<Employee_Role> employeeroles) {
		this.employeeroles = employeeroles;
	}

	public Set<Performance> getPerformances() {
		return performances;
	}

	public void setPerformances(Set<Performance> performances) {
		this.performances = performances;
	}

}
