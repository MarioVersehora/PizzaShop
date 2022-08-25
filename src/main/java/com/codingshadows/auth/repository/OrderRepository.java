package com.codingshadows.auth.repository;

import com.codingshadows.auth.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Integer> {

}
