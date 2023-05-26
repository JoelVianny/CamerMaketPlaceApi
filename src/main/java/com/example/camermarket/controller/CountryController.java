package com.example.camermarket.controller;

import com.example.camermarket.entities.Country;
import com.example.camermarket.service.CountryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/public/country")
public class CountryController {
    private  final CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries(){
        return  countryService.getAllCountries();
    }
    @GetMapping("/{id}")
    public Country getCountry(@PathVariable long id){
        return  countryService.getOneCountry(id);
    }

    @PostMapping
    public Country saveCountry(@RequestBody Country country){
        return  countryService.saveCountry(country);
    }
    @PutMapping("/{id}")
    public  Country editCountry( @PathVariable long id, @RequestBody Country foundCountry){
        return countryService.editCountry(id,foundCountry);
    }

    @DeleteMapping("/{id}")
    public  String deleteCountry(@PathVariable long id){
        return  countryService.deleteCountry(id);
    }
}
