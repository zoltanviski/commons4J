package hu.vizoli.commons4J.web;

import lombok.Data;

@Data
public class ResponseBodyWrapper<T> {
    private Object errors;

    private T data;

    private ResponseBodyWrapper(T data) {
        this.data = data;
    }

    public static <T> ResponseBodyWrapper<T> ok(T data) {
        return new ResponseBodyWrapper<>(data);
    }
}
