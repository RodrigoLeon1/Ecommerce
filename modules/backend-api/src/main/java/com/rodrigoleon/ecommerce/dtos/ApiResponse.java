package com.rodrigoleon.ecommerce.dtos;

import com.rodrigoleon.ecommerce.exceptions.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    boolean success;
    private String error;
    private ErrorCodes errorCode;
    private T content;
    private Instant timestamp;

    public ApiResponse(T content) {
        this.content = content;
        this.success = true;
        this.timestamp = Instant.now();
    }

    public ApiResponse(String errorMessage, ErrorCodes errorCode) {
        this.error = errorMessage;
        this.errorCode = errorCode;
        this.timestamp = Instant.now();
    }

    public static <T> ResponseEntity<ApiResponse<T>> withSuccess(T content) {
        return ResponseEntity.ok(new ApiResponse<>(content));
    }

    public static <T> ResponseEntity<ApiResponse<T>> withError(String errorMessage, ErrorCodes errorCode) {
        return ResponseEntity.ok(new ApiResponse<>(errorMessage, errorCode));
    }
}
