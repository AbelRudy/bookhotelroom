package com.abelrudy.bookhotelroom.controller;

import java.util.List;

import com.abelrudy.bookhotelroom.model.Hotel;
import com.abelrudy.bookhotelroom.service.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping(path = "/get/all")
    public ResponseEntity<List<Hotel>> getHotels() {
        return new ResponseEntity<List<Hotel>>(hotelService.getHotels(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable(name = "id") Long idHotel) {
        return new ResponseEntity<Hotel>(hotelService.getHotelById(idHotel), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        return new ResponseEntity<Hotel>(hotelService.addHotel(hotel), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteHotelById(@PathVariable(name = "id") Long idHotel) {
        hotelService.deleteHotel(idHotel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable(name = "id") Long idHotel,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "city", required = false) String city,
            @RequestParam(name = "stars", required = false) int stars,
            @RequestParam(name = "description", required = false) String description) {
        return new ResponseEntity<Hotel>(hotelService.updateHotel(idHotel, name, city, stars, description), HttpStatus.OK);
    }
}
