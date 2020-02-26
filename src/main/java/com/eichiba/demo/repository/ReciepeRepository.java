package com.eichiba.demo.repository;

import com.eichiba.demo.dto.ReciepesDTO;
import com.eichiba.demo.entitys.Reciepe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReciepeRepository extends JpaRepository<Reciepe, Integer> {

//    @Query(value = "SELECT r.RECIEPE_ID as R_ID, r.NAME AS R_NAME,i.INGREDIENT_ID AS I_ID,i.NAME AS I_NAME  FROM RECIEPES AS r " +
//            "INNER JOIN RECIEPE_INGREDIENTS AS ri  ON r.RECIEPE_ID = ri.RECIEPE_ID " +
//            "INNER JOIN INGREDIENT AS i ON ri.INGREDIENT_ID = i.INGREDIENT_ID ;",
//    nativeQuery = true)
//    public List<ReciepesDTO> findAllByIngredientIn(@Param("ingredientId") int ingredientId);

//    @Query("select new com.eichiba.demo.dto.ReciepesDTO(r.reciepeId, r.name, i.ingredientId, i.name) " +
//            "from Reciepe r JOIN r.ingredientsSet ri JOIN ri.ingredient i WHERE i.ingredientId = :ingredientId")
//    public List<ReciepesDTO> findAllByIngredient(@Param("ingredientId") int ingredientId);


    @Query("select new com.eichiba.demo.dto.ReciepesDTO(r.reciepeId, r.name, i.ingredientId, i.name) " +
            "from Reciepe r JOIN r.ingredientsSet ri JOIN ri.ingredient i WHERE i.ingredientId IN :ingredientIdList" +
            " GROUP BY r.reciepeId ORDER BY count(r.reciepeId) ")
    public List<ReciepesDTO> findAllByIngredientListWithIng(@Param("ingredientIdList") List<Integer> ingredientIdList);

    @Query("select new com.eichiba.demo.dto.ReciepesDTO(r.reciepeId, r.name, i.name) " +
            "from Reciepe r JOIN r.ingredientsSet ri JOIN ri.ingredient i WHERE i.ingredientId IN :ingredientIdList" +
            " GROUP BY r.reciepeId ORDER BY count(r.reciepeId) DESC")
    public List<ReciepesDTO> findAllByIngredientList(@Param("ingredientIdList") List<Integer> ingredientIdList);


}
