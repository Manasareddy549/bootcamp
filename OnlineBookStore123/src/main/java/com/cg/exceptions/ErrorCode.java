package com.cg.exceptions;

public enum ErrorCode {

	INVALID_DATA("ER-400", "Invalid Data. Details : {0}"),

    UNKNOWN_CATEGORY("ER-404", "Unknown Category Details : {0}"),

    BAD_DATA("ER-400", "Bad input data. Details : {0}"),

    SYSTEM_EXCEPTION("ER-500", "Internal Server error. Please contact support if the problem persist. Details {0}"),

    SYSTEM_MAINTENANCE("ER-503", "The system is down for maintenance"),

    CATEGORY_ALREADY_EXIST("ER-409", "Category already exist. Details : {0}");


    private final String code;

    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getErrorCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    public String getMessage(String parameter) {
        if (parameter == null) {
            return message;
        }
        return message.replace("{0}", parameter);
    }
}