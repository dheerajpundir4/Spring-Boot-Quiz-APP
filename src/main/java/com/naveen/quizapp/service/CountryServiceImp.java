package com.naveen.quizapp.service;

import com.naveen.quizapp.dao.CountryDao;
import com.naveen.quizapp.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImp implements CountryService {

    @Autowired
    CountryDao countriesDao;




    public ResponseEntity<List<Country>> getAllCountries() {
        try {
            return new ResponseEntity<>(countriesDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addCountries(Country country) {
        countriesDao.save(country);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public Country getById(Long id) {
        System.out.println("Service");
        //return countriesDao.getById(id);

        Optional<Country> optionalCountry=countriesDao.findById(id);
        return optionalCountry.get();

    }

    @Override
    public Country creatCountry(Country country) {
        return null;
    }

    @Override
    public Country getCountryById(Long id) {
        return null;
    }

    @Override
    public List<Country> getAllCountry() {
        return null;
    }

    @Override
    public Country updateCountry(Country country) {
        return null;
    }

    @Override
    public void deleteCountry(Long id) {

    }

    public List<Country> getByIdOrName(Long id, String name) {
        Optional<List<Country>> optionalCountry=countriesDao.findByIdOrName(id,name);
        return optionalCountry.get();

    }
}
