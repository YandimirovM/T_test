package com.yandimirov.navi.repository;

import com.yandimirov.navi.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
