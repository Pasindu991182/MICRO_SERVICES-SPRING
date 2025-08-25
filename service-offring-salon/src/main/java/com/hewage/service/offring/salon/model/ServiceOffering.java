package com.hewage.service.offring.salon.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class ServiceOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private Long salonId;

    @Column(nullable = false)
    private Long categoryId;

    @Column(nullable = false)
    private String image;
}
