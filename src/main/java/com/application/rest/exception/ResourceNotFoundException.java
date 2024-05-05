package com.application.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String filedName;
    private Object fieldValue;

    public ResourceNotFoundException(String filedName,  String resourceName,Object fieldValue) {
        super(String.format("%s was not found with %s='%s'",resourceName,filedName,fieldValue));
        this.fieldValue = fieldValue;
        this.filedName = filedName;
        this.resourceName = resourceName;
    }

    public ResourceNotFoundException( String resourceName) {
        super(String.format("there are not %s records in the system",resourceName));
        this.resourceName = resourceName;
    }
}
