package com.eichiba.demo.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "INGREDIENT")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ingredient {

    @Id
    @GeneratedValue
    @Column(name = "ingredient_id")
    private int ingredientId;

    private String name;

    @Column(name = "DESCRIPTION")
    private String description;


//    @JsonBackReference
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            },mappedBy = "ingredientsSet")

    @OneToMany(mappedBy = "ingredient")
    private Set<RecipeIngredients> reciepeSet = new HashSet<>();

}
