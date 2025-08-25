package com.iroshan.service.IMPL;

import com.iroshan.DTO.SalonDTO;
import com.iroshan.DTO.UserDTO;
import com.iroshan.model.Saloon;
import com.iroshan.repository.SalonRepository;
import com.iroshan.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonServiceimpl implements SalonService {

    private final SalonRepository salonRepository;

    @Override
    public Saloon createSaloon(SalonDTO req, UserDTO user) {
        Saloon salon = new Saloon();
        salon.setName(req.getName());
        salon.setAddress(req.getAddress());
        salon.setEmail(req.getEmail());
        salon.setCity(req.getCity());
        salon.setImages(req.getImages());
        salon.setOwnerId(req.getOwnerId());
        salon.setClosingTime(req.getClosingTime());
        salon.setOpeningTime(req.getOpeningTime());
        salon.setPhonenumber(req.getPhoneNumber());
        return salonRepository.save(salon);
    }

    @Override
    public Saloon updateSaloon(SalonDTO salon, UserDTO user, Long salonId) throws Exception{

        Saloon existingSalon = salonRepository.findById(salonId).orElse(null);
        if (existingSalon != null && salon.getOwnerId().equals(user.getId())) {
            existingSalon.setCity(salon.getCity());
            existingSalon.setName(salon.getName());
            existingSalon.setAddress(salon.getAddress());
            existingSalon.setEmail(salon.getEmail());
            existingSalon.setImages(salon.getImages());
            existingSalon.setOpeningTime(salon.getOpeningTime());
            existingSalon.setClosingTime(salon.getClosingTime());
            existingSalon.setOwnerId(user.getId());
            existingSalon.setPhonenumber(salon.getPhoneNumber());
            return salonRepository.save(existingSalon);
        }
        throw new Exception("Salon not found");

    }

    @Override
    public List<Saloon> getAllSaloons() throws Exception {
        return salonRepository.findAll();
    }

    @Override
    public Saloon getSaloonById(Long salonId) throws Exception {
        Saloon salon = salonRepository.findById(salonId).orElse(null);
        if (salon == null) {
            throw new Exception("Salon not found");
        }
        return salon;
    }

    @Override
    public List<Saloon> getSalonByOwnerId(Long ownerId) {
        return salonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Saloon> searchSalonBycity(String city) {
        return salonRepository.searchSaloons(city);
    }
}
