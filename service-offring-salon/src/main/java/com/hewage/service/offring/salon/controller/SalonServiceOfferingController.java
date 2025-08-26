package com.hewage.service.offring.salon.controller;

import com.hewage.service.offring.salon.DTO.CategoryDTO;
import com.hewage.service.offring.salon.DTO.SalonDTO;
import com.hewage.service.offring.salon.DTO.ServiceDTO;
import com.hewage.service.offring.salon.model.ServiceOffering;
import com.hewage.service.offring.salon.repository.ServiceOfferingRepository;
import com.hewage.service.offring.salon.services.ServicesOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-offering/salon-owner")
public class SalonServiceOfferingController {

    private final ServicesOfferingService servicesOfferingService;
    private final HandlerMapping resourceHandlerMapping;

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
}
