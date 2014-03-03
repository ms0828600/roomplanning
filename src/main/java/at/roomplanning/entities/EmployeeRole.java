package at.roomplanning.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity (name = "EmployeeRole")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id_role", "id_employee"}))
public class EmployeeRole {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "id_role", nullable = false)
	private Role role;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "id_employee", nullable = false)
	private Employee employee;
	
	private int evaluation;

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
