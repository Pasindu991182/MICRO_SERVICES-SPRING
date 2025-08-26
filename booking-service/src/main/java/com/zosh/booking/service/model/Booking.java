package com.zosh.booking.service.model;

import com.zosh.booking.service.domain.BookingStatus;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long salonId;

    private Long customerId;

    private String startTime;

    private String endTime;

    @ElementCollection
    private Set<Long> serviceIds;

    private BookingStatus status = BookingStatus.pending;

    private int totalService;
}
