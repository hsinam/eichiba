package com.eichiba.demo.dto;

import com.eichiba.demo.entitys.Ingredient;
import lombok.Data;

import java.util.List;

@Data
public class ReciepeWithIngDto {

    private int reciepeId;

    private String reciepeName;

    private List<Ingredient> ingredientList;

}
