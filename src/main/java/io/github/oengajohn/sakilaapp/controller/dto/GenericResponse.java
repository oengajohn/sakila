package io.github.oengajohn.sakilaapp.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class GenericResponse<T> {
    private boolean success;
    private String message;
    private T data;

    @JsonInclude(NON_NULL)
    private Number total;

    public static <T> GenericResponse<T> success(T data) {
        return GenericResponse.<T>builder()
                .message("SUCCESS!")
                .data(data)
                .success(true)
                .build();
    }

    public static <T> GenericResponse<T> error() {
        return GenericResponse.<T>builder()
                .message("ERROR!")
                .success(false)
                .build();
    }
    public static <T> GenericResponse<T> success(T data, String message) {
        return GenericResponse.<T>builder()
                .message(message)
                .data(data)
                .total(null)
                .success(true)
                .build();
    }
    public static <T> GenericResponse<T> error(String message) {
        return GenericResponse.<T>builder()
                .message(message)
                .total(null)
                .success(false)
                .build();
    }
    public static <T> GenericResponse<T> success(T data, String message,Number total) {
        return GenericResponse.<T>builder()
                .message(message)
                .data(data)
                .total(total)
                .success(true)
                .build();
    }

}