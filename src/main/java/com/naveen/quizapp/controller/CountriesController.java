package com.naveen.quizapp.controller;

import com.naveen.quizapp.model.Country;
import com.naveen.quizapp.service.CountryService;
import com.naveen.quizapp.service.CountryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("countries")
public class CountriesController {
    public static int count=0;

    @Autowired
    CountryServiceImp countryServiceImp;
    @Autowired
    CountryService countryService;

    @GetMapping("/")
    public  String greeting() {
        return countryService.getWelcomeMessage();
    }

    @GetMapping("all")
    public ResponseEntity<List<Country>> getAllCountries(){


        return countryServiceImp.getAllCountries();
    }

    @GetMapping(value="all/{id}")
    public Country getById(@PathVariable("id") Long id){
        System.out.println("Get Mapping");
        return  countryServiceImp.getById(id);
    }

    @GetMapping(value="alls/{id}/{name}")
    public List<Country> getById(@PathVariable("id") Long id, @PathVariable("name") String name){
        System.out.println("Get Mapping");
        return  countryServiceImp.getByIdOrName(id,name);
    }

    @PostMapping("add")
    public ResponseEntity<String> addCountries(@RequestBody Country country){

        return countryServiceImp.addCountries(country);
    }


}
