package roomplanning.db.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import roomplanning.db.model.Play;

public interface PlayRepository extends PagingAndSortingRepository<Play, Long>{

}
