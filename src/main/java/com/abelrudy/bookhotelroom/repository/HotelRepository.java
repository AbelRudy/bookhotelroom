package com.abelrudy.bookhotelroom.repository;

import com.abelrudy.bookhotelroom.model.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    
}