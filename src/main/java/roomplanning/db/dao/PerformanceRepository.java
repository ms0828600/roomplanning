package roomplanning.db.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import roomplanning.db.model.Performance;

public interface PerformanceRepository extends PagingAndSortingRepository<Performance, Long>{

}
