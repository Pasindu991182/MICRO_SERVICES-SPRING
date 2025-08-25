package com.saloon.pasindu.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private String message;
    private String error;
    private LocalDateTime timestamp;
    }

