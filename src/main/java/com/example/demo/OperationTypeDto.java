package com.example.demo;

public class OperationTypeDto<T> {
    private  T fieldValue;
    private String operation;

    public T getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(T fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public OperationTypeDto(T fieldValue, String operation) {
        this.fieldValue = fieldValue;
        this.operation = operation;
    }
}
