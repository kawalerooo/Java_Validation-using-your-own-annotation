package com.example.lab05_zpo;

import java.util.regex.Pattern;

public class MyPatternValidator implements Validator {
    private boolean valid;
    private final VInputText window;

    public MyPatternValidator(VInputText window) {
        this.window = window;
    }

    @Override
    public void validate(String text) {
        try {
            var textFieldRegex = window.getClass().getField("textField");
            var myPattern = textFieldRegex.getAnnotation(MyPattern.class);
            var pattern = Pattern.compile(myPattern.regex());
            var match = pattern.matcher(text);
            this.valid = match.matches();

        } catch (NoSuchFieldException e) {
            System.out.println(e);
        }
    }

    @Override
    public boolean isValid() {
        return valid;
    }



    @Override public String getMessage() {
        try {
            var textFieldRegex = window.getClass().getField("textField");
            return textFieldRegex.getAnnotation(MyPattern.class).message();

        } catch (NoSuchFieldException e) {
            System.out.println(e);
        }

        return "";
    }

}
