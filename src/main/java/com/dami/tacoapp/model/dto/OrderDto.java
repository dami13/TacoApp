package com.dami.tacoapp.model.dto;

public record OrderDto(
        String name,
        String street,
        String city,
        String state,
        String zip,
        String ccNumber,
        String ccExpiration,
        String ccCVV) {
}
