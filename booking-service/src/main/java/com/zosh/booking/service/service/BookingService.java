package com.zosh.booking.service.service;

import com.zosh.booking.service.DTO.BookingRequest;
import com.zosh.booking.service.DTO.SalonDTO;
import com.zosh.booking.service.DTO.ServiceDTO;
import com.zosh.booking.service.DTO.UserDTO;
import com.zosh.booking.service.model.Booking;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface BookingService {

    Booking createBooking(BookingRequest booking,
                          UserDTO userDTO,
                          SalonDTO salonDTO,
                          Set<ServiceDTO> serviceDtoSet );

    List<Booking> getBookingsByCustomer(Long customerId);
    List<Booking> getBookingsByCustomer(Long customerId, LocalDateTime startDate, LocalDateTime endDate);
}
