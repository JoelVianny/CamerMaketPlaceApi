package com.example.camermarket.service;

import com.example.camermarket.entities.City;
import com.example.camermarket.repositories.CityRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CityService {

    private final CityRepository cityRepository;

    public List<City> getAllCities(){
        return  cityRepository.findAll();
    }

    public  City getOneCity(long id){
        return  cityRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found"));
    }

    public City  saveCity(City city){
        log.info(city.toString());
        return  cityRepository.save(city);
    }

    public City editCity(long id, City city){
        log.info(city.toString());
        City foundCity = getOneCity(id);
        foundCity.setName(city.getName());
        foundCity.setCountryId(city.getCountryId());
         log.info(foundCity.toString());

         return  cityRepository.save(foundCity);
    }

    public  String deleteCity(long id){
        cityRepository.delete(getOneCity(id));
        return  "city was deleted";
    }
}
