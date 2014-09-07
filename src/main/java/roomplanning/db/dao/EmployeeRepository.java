package roomplanning.db.dao;

import org.springframework.data.repository.CrudRepository;

import roomplanning.db.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
