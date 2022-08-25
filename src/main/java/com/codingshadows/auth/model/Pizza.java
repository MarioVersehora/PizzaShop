package com.codingshadows.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "pizzas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

    @Id
    private Integer id;

    private String name;

    private List<String> ingredients = new ArrayList<>();

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

}
