package com.abelrudy.bookhotelroom.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hotel {
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    private Long id;
    private String name;
    private String city;
    private int stars;
    private String description;
    @OneToMany(
        mappedBy = "hotel"
    )
    private List<Room> rooms;
}