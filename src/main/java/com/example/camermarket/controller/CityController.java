package com.example.camermarket.controller;

import com.example.camermarket.entities.City;
import com.example.camermarket.service.CityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/public/city")
public class CityController {
    private  final CityService cityService;

    @GetMapping
    public List<City> getAllCities(){
       return   cityService.getAllCities();
    }
    @GetMapping("/{id}")
    public City getCity(@PathVariable long id){
        return  cityService.getOneCity(id);
    }

    @PostMapping
    public  City saveCity(@RequestBody City city){
        return  cityService.saveCity(city);
    }

    @PutMapping("/{id}")
    public City editCity(@PathVariable long id, @RequestBody City foundCity){
        return  cityService.editCity(id,foundCity);
    }
    @DeleteMapping("/{id}")
    public  String deleteCity(@PathVariable long id){
        return  cityService.deleteCity(id);
    }
}
