package com.example.lab05_zpo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyPattern {
    String regex() default "";
    String message() default "";
}
