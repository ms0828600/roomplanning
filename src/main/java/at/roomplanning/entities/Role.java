package at.roomplanning.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "Role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	
	@OneToMany(mappedBy = "employee")
	private Set<Employee_Role> employeeRoles;
	
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Process> rehearsalTypes;

	public Role() {
		this.employeeRoles = new HashSet<Employee_Role>(10);
		this.rehearsalTypes = new HashSet<Process>();
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

	public Set<Employee_Role> getEmployeeRoles() {
		return employeeRoles;
	}

	public void setEmployeeRoles(Set<Employee_Role> employeeRoles) {
		this.employeeRoles = employeeRoles;
	}

	public Set<Process> getRehearsalTypes() {
		return rehearsalTypes;
	}

	public void setRehearsalTypes(Set<Process> rehearsalTypes) {
		this.rehearsalTypes = rehearsalTypes;
	}

}
