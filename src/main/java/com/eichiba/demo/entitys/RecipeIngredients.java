package com.eichiba.demo.entitys;

import com.eichiba.demo.entitys.compKeys.ReciepeIngredientKey;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "RECIEPE_INGREDIENTS")
public class RecipeIngredients {

    @EmbeddedId
    ReciepeIngredientKey reciepeIngredientKey;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "reciepe_id", insertable = false, updatable = false)
    Reciepe reciepe;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ingredient_id", insertable = false, updatable = false)
    Ingredient ingredient;

    int quantity;

    public ReciepeIngredientKey getReciepeIngredientKey() {
        return reciepeIngredientKey;
    }

    public void setReciepeIngredientKey(ReciepeIngredientKey reciepeIngredientKey) {
        this.reciepeIngredientKey = reciepeIngredientKey;
    }

    public Reciepe getReciepe() {
        return reciepe;
    }

    public void setReciepe(Reciepe reciepe) {
        this.reciepe = reciepe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
