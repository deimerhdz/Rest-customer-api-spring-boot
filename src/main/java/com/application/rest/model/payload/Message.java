package com.application.rest.model.payload;

import java.io.Serializable;

public class Message<T> implements Serializable {
    private boolean success;
    private String message;
    private T data;

    public Message(String message, T data, boolean success) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> Message<T> empty() {
        return success(null);
    }

    public static <T> Message<T> success(T data) {
        return new Message<T>("SUCCESS!",data,true);
    }

    public static <T> Message<T> error(String message) {
        return new Message<T>("ERROR! "+message,null,false);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
