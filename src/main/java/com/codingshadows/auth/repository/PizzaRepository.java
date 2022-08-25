package com.codingshadows.auth.repository;

import com.codingshadows.auth.model.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PizzaRepository extends MongoRepository<Pizza, Integer> {

    List<Pizza> findByIdIn(List<Integer> list);
}
