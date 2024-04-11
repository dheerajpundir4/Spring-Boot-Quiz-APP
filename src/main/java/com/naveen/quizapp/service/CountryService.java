package com.naveen.quizapp.service;

import com.naveen.quizapp.model.Country;

import java.util.List;

public interface CountryService {
    Country creatCountry(Country country);

    Country getCountryById(Long id);

    List<Country> getAllCountry();

    Country updateCountry(Country country);

    void deleteCountry(Long id);

    public default String getWelcomeMessage(){
        return "Hello";
    }

}
