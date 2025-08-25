package com.iroshan.controller;


import com.iroshan.DTO.SalonDTO;
import com.iroshan.DTO.UserDTO;
import com.iroshan.mapper.SalooonMapper;
import com.iroshan.model.Saloon;
import com.iroshan.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salons")
@RequiredArgsConstructor
public class SaloonController {

    private final SalonService salonService;

    @PostMapping
    public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Saloon saloon=salonService.createSaloon(salonDTO,userDTO);
        SalonDTO salonDTO1 = SalooonMapper.mapToDTO(saloon);
        return ResponseEntity.ok(salonDTO1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalonDTO> updateSalon(
            @PathVariable("id")  Long salonId,
            @RequestBody SalonDTO salonDTO) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Saloon saloon=salonService.updateSaloon(salonDTO,userDTO,salonId);
        SalonDTO salonDTO1 = SalooonMapper.mapToDTO(saloon);
        return ResponseEntity.ok(salonDTO1);
    }


    @GetMapping
    public ResponseEntity<List<SalonDTO>> getAllSalons() throws Exception {

        List<Saloon> saloons = salonService.getAllSaloons();
        List<SalonDTO> salonDTOS = saloons.stream().map((saloon) ->
        {
            SalonDTO salonDTO = SalooonMapper.mapToDTO(saloon);
            return salonDTO;
        }
        ).toList();

        return ResponseEntity.ok(salonDTOS);
    }

    @GetMapping("/search")
    public ResponseEntity<List<SalonDTO>> searchSalons(
            @RequestParam("city") String city
    ) throws Exception {

        List<Saloon> saloons = salonService.searchSalonBycity(city);
        List<SalonDTO> salonDTOS = saloons.stream().map((saloon) ->
            {
            SalonDTO salonDTO = SalooonMapper.mapToDTO(saloon); // Fixed mapper name
            return salonDTO;
            }
        ).toList(); // Moved .toList() to correct position

        return ResponseEntity.ok(salonDTOS); // Added missing return statement
    }

    @GetMapping("/{salonId}")
    public ResponseEntity<SalonDTO> getSalonById(@PathVariable("salonId") Long salonId) throws Exception {

        Saloon saloon = salonService.getSaloonById(salonId);
        SalonDTO salonDTO = SalooonMapper.mapToDTO(saloon);
        return ResponseEntity.ok(salonDTO);
    }

    @GetMapping("/owner")
    public ResponseEntity<List<SalonDTO>> getSalonByOwner(@RequestParam("ownerId") Long ownerId) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        List<Saloon> salons = salonService.getSalonByOwnerId(userDTO.getId());
        List<SalonDTO> salonDTOS = salons.stream().map(SalooonMapper::mapToDTO).toList();
        return ResponseEntity.ok(salonDTOS);
    }

}
