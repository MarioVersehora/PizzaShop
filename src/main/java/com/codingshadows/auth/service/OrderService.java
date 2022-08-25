package com.codingshadows.auth.service;

import com.codingshadows.auth.model.Order;
import com.codingshadows.auth.model.User;
import com.codingshadows.auth.repository.OrderRepository;
import com.codingshadows.auth.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;

    public Order orderPizza(List<Integer> pizzasId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return orderRepository.save(Order.builder()
                .user((User) authentication.getPrincipal())
                .pizzas(pizzaRepository.findByIdIn(pizzasId))
                .build()
        );


    }
}
