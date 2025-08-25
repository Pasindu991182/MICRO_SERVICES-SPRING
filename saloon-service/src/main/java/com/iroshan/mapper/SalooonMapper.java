package com.iroshan.mapper;

import com.iroshan.DTO.SalonDTO;
import com.iroshan.model.Saloon;

public class SalooonMapper {

    public static SalonDTO mapToDTO(Saloon saloon) {
        SalonDTO salonDTO=new SalonDTO();

        salonDTO.setId(saloon.getId());
        salonDTO.setName(saloon.getName());
        salonDTO.setAddress(saloon.getAddress());
        salonDTO.setCity(saloon.getCity());
        salonDTO.setImages(saloon.getImages());
        salonDTO.setClosingTime(saloon.getClosingTime());
        salonDTO.setOpeningTime(saloon.getOpeningTime());
        salonDTO.setPhoneNumber(saloon.getPhonenumber());
        salonDTO.setEmail(saloon.getEmail());
        salonDTO.setOwnerId(saloon.getOwnerId());
        return salonDTO;
    }
}
