package com.abelrudy.bookhotelroom.service;

import java.util.List;

import com.abelrudy.bookhotelroom.model.Hotel;
import com.abelrudy.bookhotelroom.model.Room;
import com.abelrudy.bookhotelroom.repository.HotelRepository;
import com.abelrudy.bookhotelroom.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getRoomsByHotel(Long idHotel) {
        Hotel hotel = hotelRepository.findById(idHotel).orElseThrow(() -> new IllegalStateException(
                "No hotel matches with id " + idHotel));
        return hotel.getRooms();
    }

    public Room getRoom(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "No room matches with id " + id));
        return room;
    }

    public Room addRoom(Long idHotel, Room room) {
        Hotel hotel = hotelRepository.findById(idHotel).orElseThrow(() -> new IllegalStateException(
                "No hotel matches with id " + idHotel));
        room.setHotel(hotel);
        for (Room tempRoom : hotel.getRooms()) {
            if (tempRoom.getRoomNumber() == room.getRoomNumber()) {
                throw new IllegalStateException("Always have for this hotel the room " + room.getRoomNumber());
            }
        }
        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public Room updateRoom(Long id, int roomNumber, double surface, boolean isSuite, double price, String description) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "No room matches with id " + id));
        if (roomNumber > 0 && room.getRoomNumber() != roomNumber)
            room.setRoomNumber(roomNumber);
        if (surface > 0 && room.getSurface() != surface)
            room.setSurface(surface);
        if (isSuite != room.isSuite())
            room.setSuite(isSuite);
        if (price > 0 && price != room.getPrice())
            room.setPrice(price);
        return room;
    }
}