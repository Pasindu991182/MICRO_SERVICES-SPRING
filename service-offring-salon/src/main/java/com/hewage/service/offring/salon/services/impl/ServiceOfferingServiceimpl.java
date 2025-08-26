package com.hewage.service.offring.salon.services.impl;

import com.hewage.service.offring.salon.DTO.CategoryDTO;
import com.hewage.service.offring.salon.DTO.SalonDTO;
import com.hewage.service.offring.salon.DTO.ServiceDTO;
import com.hewage.service.offring.salon.model.ServiceOffering;
import com.hewage.service.offring.salon.repository.ServiceOfferingRepository;
import com.hewage.service.offring.salon.services.ServicesOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceOfferingServiceimpl implements ServicesOfferingService {

    private final ServiceOfferingRepository serviceOfferingRepository;


    @Override
    public ServiceOffering createServiceOffering(SalonDTO salonDTO, ServiceDTO serviceDTO, CategoryDTO categoryDTO) {

        ServiceOffering serviceOffering = new ServiceOffering();
        serviceOffering.setImage(serviceDTO.getImage());
        serviceOffering.setSalonId(salonDTO.getId());
        serviceOffering.setName(serviceDTO.getName());
        serviceOffering.setDescription(serviceDTO.getDescription());
        serviceOffering.setCategoryId(categoryDTO.getId());
        serviceOffering.setPrice(serviceDTO.getPrice());
        serviceOffering.setDuration(serviceDTO.getDuration());

        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering updateService(Long serviceId,
                                         ServiceOffering service) throws Exception{

        ServiceOffering serviceOffering=serviceOfferingRepository
                .findById(serviceId).orElse(null);

        if(serviceOffering==null){
            throw new Exception("service id not found"+serviceId);
        }

        serviceOffering.setImage(service.getImage());
        serviceOffering.setName(service.getName());
        serviceOffering.setDescription(service.getDescription());
        serviceOffering.setPrice(service.getPrice());
        serviceOffering.setDuration(service.getDuration());
        return serviceOfferingRepository.save(serviceOffering);

    }

    @Override
    public Set<ServiceOffering> GetAllServiceBySalonId(Long salonId, Long categoryId) {
        Set<ServiceOffering> services = serviceOfferingRepository.findBySalonId(salonId);
        if (categoryId != null && !services.isEmpty()) {
            services = services.stream()
                    .filter(service -> categoryId.equals(service.getCategoryId()))
                    .collect(Collectors.toSet());
        }

        return services;
    }

    @Override
    public Set<ServiceOffering> getServiceByIds(Set<Long> ids) {
        List<ServiceOffering> services = serviceOfferingRepository.findAllById(ids);
        return new HashSet<>(services);
    }

    @Override
    public ServiceOffering getServiceById(Long id) throws Exception {
        ServiceOffering serviceOffering=serviceOfferingRepository
                .findById(id).orElse(null);

        if(serviceOffering==null){
            throw new Exception("service id not found"+id);
        }
        return serviceOffering;
    }

}
