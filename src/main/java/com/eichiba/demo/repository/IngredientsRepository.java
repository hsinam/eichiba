package com.eichiba.demo.repository;

import com.eichiba.demo.entitys.Ingredient;
import com.eichiba.demo.entitys.Reciepe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Integer> {

    @Query("select i.reciepeSet from Ingredient i where i.ingredientId = :ingredientId")
    public Set<Reciepe> findAllByIngredientIn(@Param("ingredientId") int ingredientId);

}
