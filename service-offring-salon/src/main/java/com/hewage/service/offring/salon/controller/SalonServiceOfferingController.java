package com.hewage.service.offring.salon.controller;

import com.hewage.service.offring.salon.DTO.CategoryDTO;
import com.hewage.service.offring.salon.DTO.SalonDTO;
import com.hewage.service.offring.salon.DTO.ServiceDTO;
import com.hewage.service.offring.salon.model.ServiceOffering;
import com.hewage.service.offring.salon.repository.ServiceOfferingRepository;
import com.hewage.service.offring.salon.services.ServicesOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-offering/salon-owner")
public class SalonServiceOfferingController {

    private final ServicesOfferingService servicesOfferingService;


    @PostMapping
    public ResponseEntity<ServiceOffering> createService(
            @RequestBody ServiceDTO serviceDTO
            ){

        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(serviceDTO.getCategoryId());

        ServiceOffering serviceOfferings = servicesOfferingService
                .createServiceOffering(salonDTO,serviceDTO,categoryDTO);

        return ResponseEntity.ok(serviceOfferings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceOffering> updateService(
            @PathVariable Long id,
            @RequestBody ServiceOffering serviceOffering
    )throws Exception{

        ServiceOffering serviceOfferings = servicesOfferingService
                .updateService(id, serviceOffering);
        return ResponseEntity.ok(serviceOfferings);
    }
}
