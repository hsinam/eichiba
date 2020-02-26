package com.eichiba.demo.dto;

import lombok.Data;

@Data
public class ReciepesDTO {

    private int reciepeId;

    private String reciepeName;

    private int ingredientId;

    private String ingredientName;

    public ReciepesDTO(int reciepeId, String reciepeName, String ingredientName) {
        this.reciepeId = reciepeId;
        this.reciepeName = reciepeName;
        this.ingredientId = 0;
        this.ingredientName = ingredientName;
    }

    public ReciepesDTO(int reciepeId, String reciepeName, int ingredientId, String ingredientName) {
        this.reciepeId = reciepeId;
        this.reciepeName = reciepeName;
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
    }
}
