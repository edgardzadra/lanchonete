package com.desafio.lanchonete.domain.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "burguer")
public class Burguer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ingredients_list", joinColumns = @JoinColumn(name = "burguer_id")
    , inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients;
    private boolean isDefaultBurguer = true;


    public Burguer(){}

    public Burguer(String description, List<Ingredient> ingredients){
        this.description = description;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isDefaultBurguer() {
        return isDefaultBurguer;
    }

    public void setDefaultBurguer(boolean defaultBurguer) {
        isDefaultBurguer = defaultBurguer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Burguer burguer = (Burguer) o;
        return id.equals(burguer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
