package roomplanning.db.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import roomplanning.db.model.Room;

public interface RoomRepository extends PagingAndSortingRepository<Room, Long> {

}
