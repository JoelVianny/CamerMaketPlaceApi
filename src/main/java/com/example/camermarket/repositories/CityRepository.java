package com.example.camermarket.repositories;

import com.example.camermarket.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository  extends JpaRepository<City,Long> {
}
