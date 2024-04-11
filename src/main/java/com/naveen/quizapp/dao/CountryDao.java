package com.naveen.quizapp.dao;

import com.naveen.quizapp.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryDao extends JpaRepository<Country, Long> {
    @Query(value = "SELECT * FROM country where  id=:id  or name=:name ", nativeQuery = true)
    Optional<List<Country>> findByIdOrName(Long id, String name);

    //List<Countries> findByCategory(String category);

    //@Query(value = "SELECT * FROM countries q ", nativeQuery = true)
    //List<Countries> findRandomQuestionsByCategory(String category, int numQ);
}

