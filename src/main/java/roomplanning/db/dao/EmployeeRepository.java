package roomplanning.db.dao;

import org.springframework.data.repository.CrudRepository;

import roomplanning.db.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
