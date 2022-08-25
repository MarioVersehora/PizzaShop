package com.codingshadows.auth.controller;

import com.codingshadows.auth.model.Order;
import com.codingshadows.auth.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order orderPizza(@RequestBody List<Integer> pizzasId) {
        return orderService.orderPizza(pizzasId);
    }


}
