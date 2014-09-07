package roomplanning.db.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * This class stores the roles of a system like singer, instruments, etc.
 * and the relation to the employees who can play this role.
 *
 */
@Data
@Entity(name = "Function")
public class Function {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	
	@OneToMany(mappedBy = "employee")
	private Set<Employee_Function> employeeFunction;
	
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Process> rehearsalTypes;

	public Function() {
		this.employeeFunction = new HashSet<Employee_Function>(10);
		this.rehearsalTypes = new HashSet<Process>();
	}

}
