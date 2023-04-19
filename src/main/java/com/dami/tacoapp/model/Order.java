package com.dami.tacoapp.model;

import com.dami.tacoapp.model.dto.OrderDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Street is required")
    private String street;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "State is required")
    private String state;
    @NotBlank(message = "Zip code is required")
    private String zip;
    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;
    private Date placedAt;
    @ManyToMany
    private List<Taco> tacos;
    @ManyToOne
    private User user;

    public Order from(OrderDto orderDto) {
        this.name = orderDto.name();
        this.street = orderDto.street();
        this.city = orderDto.city();
        this.state = orderDto.state();
        this.zip = orderDto.zip();
        this.ccNumber = orderDto.ccNumber();
        this.ccExpiration = orderDto.ccExpiration();
        this.ccCVV = orderDto.ccCVV();
        return this;
    }

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
}
