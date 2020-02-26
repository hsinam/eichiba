package com.eichiba.demo.entitys.compKeys;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Data
@Embeddable
public class ReciepeIngredientKey implements Serializable {

    @Column(name = "reciepe_id")
    Integer recipeId;

    @Column(name = "ingredient_id")
    Integer ingredientId;
}
