package com.codingshadows.auth.controller;

import com.codingshadows.auth.exception.NoPizzaException;
import com.codingshadows.auth.exception.PizzaAlreadyInMenuException;
import com.codingshadows.auth.model.Pizza;
import com.codingshadows.auth.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    @GetMapping
    public List<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @PostMapping("add/ingredient/{pizzaId}/{ingredient}")
    public void addIngredient(@PathVariable Integer pizzaId,@PathVariable String ingredient) throws NoPizzaException {
        pizzaService.addIngredient(pizzaId, ingredient);
    }

    @PostMapping
    public void savePizza(@RequestBody Pizza pizza) throws PizzaAlreadyInMenuException {
        pizzaService.savePizza(pizza);
    }


}
