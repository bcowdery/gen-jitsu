package io.genjitsu.exceptions;

/**
 * Encapsulates exceptions thrown during reflection operations.
 */
public class GenJitsuReflectionException extends RuntimeException {

    public GenJitsuReflectionException(String message) {
        super(message);
    }

    public GenJitsuReflectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
