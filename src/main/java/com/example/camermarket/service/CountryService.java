package com.example.camermarket.service;

import com.example.camermarket.entities.Country;
import com.example.camermarket.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryService {
    private final CountryRepository countryRepository;

    public List<Country> getAllCountries(){
        return  countryRepository.findAll();
    }

    public  Country getOneCountry(long id){
        return  countryRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found"));
    }

    public  Country saveCountry(Country country){
        log.info(country.toString());
         return  countryRepository.save(country);
    }

    public  Country editCountry(long id,Country country){
        log.info(country.toString());
        Country foundCountry = getOneCountry(id);
        foundCountry.setName(country.getName());
        foundCountry.setCities(country.getCities());
        log.info(foundCountry.toString());
        return  countryRepository.save(foundCountry);

    }
    public String deleteCountry(long id){
        countryRepository.delete(getOneCountry(id));
        return  "country was deleted";
    }
}
