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

import lombok.Data;

/**
 * This class stores all information about the employees like
 * name, address, the roles they can play, etc.
 *
 */
@Data
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

}
