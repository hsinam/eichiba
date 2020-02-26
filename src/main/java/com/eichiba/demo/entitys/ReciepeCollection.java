package com.eichiba.demo.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "RECIEPE_COLLECTION")
@NoArgsConstructor
public class ReciepeCollection {

    @Id
    @GeneratedValue
    @Column(name = "RECIEPE_COLLECTION_ID")
    private int reciepeCollectionId;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("reciepeList")
    private User createdBy;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "RECIEPE_REC_COLLECTION",
            joinColumns = @JoinColumn(name = "RECIEPE_COLLECTION_ID"),
            inverseJoinColumns = @JoinColumn(name = "RECIEPE_ID"))
    private Set<Ingredient> recipeSet = new HashSet<>();

    public int getReciepeCollectionId() {
        return reciepeCollectionId;
    }

    public void setReciepeCollectionId(int reciepeCollectionId) {
        this.reciepeCollectionId = reciepeCollectionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @JsonManagedReference
    public Set<Ingredient> getRecipeSet() {
        return recipeSet;
    }

    public void setRecipeSet(Set<Ingredient> recipeSet) {
        this.recipeSet = recipeSet;
    }

}
