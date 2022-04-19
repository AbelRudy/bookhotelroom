package com.abelrudy.bookhotelroom.controller;

import java.util.List;

import com.abelrudy.bookhotelroom.model.Room;
import com.abelrudy.bookhotelroom.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping(path = "/get/all")
    public ResponseEntity<List<Room>> getRoomsByHotel(@RequestParam(name = "id_hotel") Long idHotel) {
        return new ResponseEntity<List<Room>>(roomService.getRoomsByHotel(idHotel), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<Room>(roomService.getRoom(id), HttpStatus.OK);
    }

    @PostMapping(path = "/add/")
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        return new ResponseEntity<Room>(roomService.addRoom(room.getHotel().getId(), room), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(name = "id") Long id,
            @RequestParam(name = "room_number", required = false) int roomNumber,
            @RequestParam(name = "surface", required = false) double surface,
            @RequestParam(name = "is_suite", required = false) boolean isSuite,
            @RequestParam(name = "price", required = false) double price,
            @RequestParam(name = "description", required = false) String description) {
        return new ResponseEntity<Room>(roomService.updateRoom(id, roomNumber, surface, isSuite, price, description),
                HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable(name = "id") Long id) {
        roomService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
