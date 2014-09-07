package roomplanning.db.dao;

import org.springframework.data.repository.CrudRepository;
import roomplanning.db.entities.Process;

public interface ProcessRepository extends CrudRepository<Process, Long>{

}
