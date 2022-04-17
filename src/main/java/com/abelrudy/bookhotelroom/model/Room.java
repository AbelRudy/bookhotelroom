package com.abelrudy.bookhotelroom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Room {
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    private Long id;
    private int roomNumber;
    private double surface;
    private boolean isSuite;
    private double price;
    private String description;

    @ManyToOne
    @JoinColumn(
        nullable = false,
        name = "hotel_id"
    )
    private Hotel hotel;
}
