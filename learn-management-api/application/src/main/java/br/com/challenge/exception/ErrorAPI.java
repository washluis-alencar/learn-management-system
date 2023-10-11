package br.com.challenge.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Class to represent error in API
 * @author Alencar, Washington
 */
@Data
@AllArgsConstructor
@Builder
public class ErrorAPI {

    private String message;

    private LocalDateTime timeStamp;

    private String path;

    private Integer status;
}
