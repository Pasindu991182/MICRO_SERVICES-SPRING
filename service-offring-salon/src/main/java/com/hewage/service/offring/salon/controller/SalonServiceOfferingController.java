package com.hewage.service.offring.salon.controller;

import com.hewage.service.offring.salon.model.ServiceOffering;
import com.hewage.service.offring.salon.services.ServicesOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-offering")
public class SalonServiceOfferingController {

    private final ServicesOfferingService servicesOfferingService;

    @GetMapping("/salon/{salonId}")
    public ResponseEntity<Set<ServiceOffering>> getServiceBySalonId(
            @PathVariable Long salonId,
            @RequestParam(required = false) Long category
    ) {
        Set<ServiceOffering> serviceOfferings = servicesOfferingService.GetAllServiceBySalonId(salonId, category);
        return ResponseEntity.ok(serviceOfferings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOffering> getServiceById(
            @PathVariable Long id) throws Exception {
        ServiceOffering serviceOffering = servicesOfferingService.getServiceById(id);
        return ResponseEntity.ok(serviceOffering);
    }

    @GetMapping("/list/{ids}")
    public ResponseEntity<Set<ServiceOffering>> getServiceBySalonIds(
            @PathVariable  Set<Long> ids
    ){
        Set<ServiceOffering> serviceOfferings = servicesOfferingService.getServiceByIds(ids);
        return ResponseEntity.ok(serviceOfferings);
    }
}
