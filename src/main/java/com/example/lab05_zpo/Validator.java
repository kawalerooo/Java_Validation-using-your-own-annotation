package com.example.lab05_zpo;

public interface Validator {
    public void validate(String text);
    public boolean isValid();
    public String getMessage();
}
