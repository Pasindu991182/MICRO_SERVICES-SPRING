package com.iroshan.service;

import com.iroshan.DTO.SalonDTO;
import com.iroshan.DTO.UserDTO;
import com.iroshan.model.Saloon;

import java.util.List;

public interface SalonService {

    Saloon createSaloon(SalonDTO salon, UserDTO user);
    Saloon updateSaloon(SalonDTO salon, UserDTO user,Long salonId) throws Exception;
    List<Saloon> getAllSaloons() throws Exception;
    Saloon getSaloonById(Long salonId) throws Exception;
    List<Saloon> getSalonByOwnerId(Long ownerId);
    List<Saloon> searchSalonBycity(String city);
}
