package com.aaditx23.saucedemo_test.Util;

public enum UserType {
    STANDARD,
    LOCKED_OUT,
    PROBLEM,
    PERFORMANCE_GLITCH,
    ERROR,
    VISUAL,
    PASSWORD;


    @Override
    public String toString() {
        return switch (this) {
            case STANDARD -> "standard";
            case LOCKED_OUT -> "locked_out";
            case PROBLEM -> "problem";
            case PERFORMANCE_GLITCH -> "performance_glitch";
            case ERROR -> "error";
            case VISUAL -> "visual";
            case PASSWORD -> "password";
            default -> super.toString();
        };
    }

}
