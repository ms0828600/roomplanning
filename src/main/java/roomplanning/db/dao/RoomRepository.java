package roomplanning.db.dao;

import org.springframework.data.repository.CrudRepository;

import roomplanning.db.model.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {

}
