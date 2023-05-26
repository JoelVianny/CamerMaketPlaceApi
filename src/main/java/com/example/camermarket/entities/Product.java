package com.example.camermarket.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long categoryId;
    private String name;
    private String address;
    private Long cityId;
    private double price;
    private String description;
    private Long attachmentId;
    private Timestamp createdAt;
    private Timestamp overThe;
    private Boolean isActual;
    private Boolean confirmed;
}
