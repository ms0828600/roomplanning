package roomplanning.db.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import roomplanning.db.model.Function;

public interface FunctionRepository extends PagingAndSortingRepository<Function, Long>{

}
