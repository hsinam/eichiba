package com.eichiba.demo.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "RECIEPES")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reciepe {

    @Id
    @GeneratedValue
    @Column(name = "reciepe_id")
    private int reciepeId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("reciepeList")
    private User createdBy;

//    @JsonManagedReference
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "RECIEPE_INGREDIENTS",
//            joinColumns = @JoinColumn(name = "RECIEPE_ID", referencedColumnName = "RECIEPE_ID"),
//            inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID", referencedColumnName = "INGREDIENT_ID"))
//    private Set<Ingredient> ingredientsSet = new HashSet<>();


    @OneToMany(mappedBy = "reciepe")
    private Set<RecipeIngredients> ingredientsSet = new HashSet<>();

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "recipeSet")
    private Set<ReciepeCollection> reciepeCollectionSet = new HashSet<>();

    public int getReciepeId() {
        return reciepeId;
    }

    public void setReciepeId(int reciepeId) {
        this.reciepeId = reciepeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @JsonManagedReference
    public Set<RecipeIngredients> getIngredientsSet() {
        return ingredientsSet;
    }

    public void setIngredientsSet(Set<RecipeIngredients> ingredientsSet) {
        this.ingredientsSet = ingredientsSet;
    }


}
