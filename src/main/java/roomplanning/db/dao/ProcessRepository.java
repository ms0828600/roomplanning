package roomplanning.db.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import roomplanning.db.model.Process;

public interface ProcessRepository extends PagingAndSortingRepository<Process, Long>{

}
