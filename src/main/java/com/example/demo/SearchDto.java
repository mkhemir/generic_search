package com.example.demo;

public class SearchDto {

    public   OperationTypeDto<Long> id;
    public   String categorie;
    public   OperationTypeDto<Integer> code;

    public OperationTypeDto<Long> getId() {
        return id;
    }

    public void setId(OperationTypeDto<Long> id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public OperationTypeDto<Integer> getCode() {
        return code;
    }

    public void setCode(OperationTypeDto<Integer> code) {
        this.code = code;
    }
}
