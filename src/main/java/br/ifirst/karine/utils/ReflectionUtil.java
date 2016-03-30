/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.utils;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;

/**
 *
 * @author Wanderson
 */
public class ReflectionUtil {
    public static Object getFieldValue(Object object, String fieldName) {
    try {
        
        int indexOf = fieldName.indexOf(".");
        
        indexOf = indexOf == -1 ? fieldName.length() : indexOf;
        
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            for(Field field: clazz.getDeclaredFields())
                if (field.getName().equals(fieldName.substring(0, indexOf))) {
                    field.setAccessible(true);
                    
                    if(indexOf < fieldName.length()){
                        return getFieldValue(field.get(object), fieldName.substring(indexOf + 1, fieldName.length()));
                    }
                    
                    if(field.get(object) instanceof byte[]){
                        return new ByteArrayInputStream((byte[]) field.get(object));
                    }
                    
                    return field.get(object);
                }
            clazz = clazz.getSuperclass();
        }
        
        
        
    } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
        throw new RuntimeException( e );
    }
    return null;
}

}
