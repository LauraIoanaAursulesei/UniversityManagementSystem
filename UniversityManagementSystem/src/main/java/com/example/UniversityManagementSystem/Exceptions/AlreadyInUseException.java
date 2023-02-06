package com.example.UniversityManagementSystem.Exceptions;

public class AlreadyInUseException extends Exception {
    public AlreadyInUseException(String errorMessage) {
        super(errorMessage);
    }
}
