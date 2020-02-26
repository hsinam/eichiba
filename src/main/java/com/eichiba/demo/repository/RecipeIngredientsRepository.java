package com.eichiba.demo.repository;

import com.eichiba.demo.entitys.Reciepe;
import com.eichiba.demo.entitys.RecipeIngredients;
import com.eichiba.demo.entitys.compKeys.ReciepeIngredientKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientsRepository extends JpaRepository<RecipeIngredients, ReciepeIngredientKey> {


}
