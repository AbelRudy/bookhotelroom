package com.abelrudy.bookhotelroom.repository;

import com.abelrudy.bookhotelroom.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    
}