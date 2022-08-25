package com.codingshadows.auth.service;

import com.codingshadows.auth.exception.NoPizzaException;
import com.codingshadows.auth.exception.PizzaAlreadyInMenuException;
import com.codingshadows.auth.model.Pizza;
import com.codingshadows.auth.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public void addIngredient(Integer pizzaId, String ingredient) throws NoPizzaException {
        Optional<Pizza> pizza = pizzaRepository.findById(pizzaId);
        if (pizza.isEmpty()) {
            throw new NoPizzaException("Pizza was not found in menu.");
        }
        pizza.get().addIngredient(ingredient);
        pizzaRepository.save(pizza.get());
    }

    public Pizza savePizza(Pizza pizza) throws PizzaAlreadyInMenuException {
        List<Pizza> list = pizzaRepository.findAll().stream()
                .filter(p -> p.getName().equals(pizza.getName()))
                .collect(Collectors.toList());
        if (list.size() > 0) {
            throw new PizzaAlreadyInMenuException("Pizza is in menu!");
        }
        return pizzaRepository.save(pizza);
    }
}
