package com.hewage.service.offring.salon.services;

import com.hewage.service.offring.salon.DTO.CategoryDTO;
import com.hewage.service.offring.salon.DTO.SalonDTO;
import com.hewage.service.offring.salon.DTO.ServiceDTO;
import com.hewage.service.offring.salon.model.ServiceOffering;

import java.util.Set;

public interface ServicesOfferingService {

    ServiceOffering createServiceOffering(SalonDTO salonDTO,
                                          ServiceDTO serviceDTO,
                                          CategoryDTO categoryDTO);

    ServiceOffering updateService(Long serviceId,ServiceOffering serviceOffering) throws Exception;

    Set<ServiceOffering> GetAllServiceBySalonId(Long salonId,Long categoryId);

    Set<ServiceOffering> getServiceByIds(Set<Long> ids);

    ServiceOffering getServiceById(Long id)throws Exception;
}
