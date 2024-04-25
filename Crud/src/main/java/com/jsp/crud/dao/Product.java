package com.jsp.crud.dao;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "Product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Valid
    private Long id;
    @Column(name = "product_name")
    @NotNull(message = "name is mandatory")
    @Size(min=2, max=30)
    private String name;
    @Column(name = "product_price")
    @NotNull(message = "price is mandatory")
    private double price;
    @Column(name = "expiry_date")
    @FutureOrPresent(message = "expiry date must be in the future or present")
    private Date expiryDate;
    public boolean isExpired() {
        return expiryDate != null && expiryDate.before(new Date());
    }

}
