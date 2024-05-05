package com.application.rest.utils;

import com.application.rest.model.payload.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtils{

    public static <T> ResponseEntity<Message<T>> createResponse(Message<T> messageResponse, HttpStatus http){
        return new ResponseEntity<>(messageResponse, http);
    }
}
