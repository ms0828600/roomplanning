package roomplanning.db.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import roomplanning.db.model.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{

}
