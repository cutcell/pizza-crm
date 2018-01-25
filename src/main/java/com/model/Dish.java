package com.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name="Dish")
@Table(name = "Dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    private Set<Product> ingredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Product> ingredients) {
        this.ingredients = ingredients;
    }
}