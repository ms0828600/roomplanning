package roomplanning.db.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import roomplanning.db.model.Rehearsal;

public interface RehearsalRepository extends PagingAndSortingRepository<Rehearsal, Long>{

}
