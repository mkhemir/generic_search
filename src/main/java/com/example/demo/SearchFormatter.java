package com.example.demo;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFormatter<T> {
    StringBuilder str = null;
    boolean isMultiple= false;
    public String formatTO(T obj) {
        str = new StringBuilder();
        Field[] fields = obj.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            try {
                fillArgs(field, obj);
            }catch (Exception e){}
        });
        return str.toString();
    }

    void fillArgs(Field f, T obj) throws Exception {
        List<String> list = new ArrayList<>();
        if (f.get(obj) != null) {
            if(isMultiple){
                str.append(";");
            }
            if (f.getType().equals(OperationTypeDto.class)) {
                str.append(f.getName());
                str.append(((OperationTypeDto) f.get(obj)).getOperation());
                str.append(((OperationTypeDto) f.get(obj)).getFieldValue());
            }else {
                str.append(f.getName());
                str.append("==");
                str.append(f.get(obj));
            }
            isMultiple = true;
        }
    }
}
