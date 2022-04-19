package com.abelrudy.bookhotelroom.service;

import java.util.List;

import javax.transaction.Transactional;

import com.abelrudy.bookhotelroom.model.Hotel;
import com.abelrudy.bookhotelroom.repository.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long idHotel) {
        Hotel hotel = hotelRepository.findById(idHotel).orElseThrow(() -> new IllegalStateException(
                "No hotel matches with id " + idHotel));

        return hotel;
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Long idHotel) {
        hotelRepository.deleteById(idHotel);
    }

    @Transactional
    public Hotel updateHotel(Long idHotel, String name, String city, int stars, String description) {
        Hotel hotel = hotelRepository.findById(idHotel).orElseThrow(() -> new IllegalStateException(
                "No hotel matches with id " + idHotel));
        if (name != null && name.length() > 0 && name != hotel.getName()) {
            hotel.setName(name);
        }
        if (city != null && city.length() > 0 && city != hotel.getCity()) {
            hotel.setCity(city);
        }
        if (stars != 0 && stars != hotel.getStars()) {
            hotel.setStars(stars);
        }
        if (description != null && description.length() > 0 && description != hotel.getDescription()) {
            hotel.setDescription(description);
        }
        return hotel;
    }
}