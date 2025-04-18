package com.silassefas.apigestaodeloja.util;

public class StringNormalizer {

    private String stringToNormalize;

    public StringNormalizer(){

    }

    public StringNormalizer(String stringToNormalize){
        this.stringToNormalize = stringToNormalize;
    }

    public static String stringNormalize(String stringToNormalize){
        if(stringToNormalize == null){
            throw new IllegalArgumentException("Value can't be null");
        }else {
            return stringToNormalize.replaceAll("[/.^~´`-]", "");
        }

    }
}
