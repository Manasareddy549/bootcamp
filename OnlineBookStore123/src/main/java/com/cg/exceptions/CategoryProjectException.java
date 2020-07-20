package com.cg.exceptions;

@SuppressWarnings("serial")
public class CategoryProjectException extends RuntimeException{

	private final ErrorCode errorCode;

    public CategoryProjectException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public CategoryProjectException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}