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

import lombok.Data;

/**
 * This class stores the relation between the role and the employee.
 * Here we also have the attribute @evaluation where we can save
 * how good an employee can play a role (e.g. an instrument)
 *
 */
@Data
@Entity(name = "Employee_Role")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "id_role",
		"id_employee" }))
public class Employee_Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_role", nullable = false)
	private Role role;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_employee", nullable = false)
	private Employee employee;

	private int evaluation;

}
