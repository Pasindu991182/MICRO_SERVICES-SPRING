package com.zosh.booking.service.DTO;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class BookingRequest {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Set<Long> serviceIds;
}
