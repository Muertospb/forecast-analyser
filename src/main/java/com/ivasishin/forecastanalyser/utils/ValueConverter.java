package com.ivasishin.forecastanalyser.utils;

public class ValueConverter {
    public static double getDoubleFromString(String value){
        return Double.parseDouble(value.replace(",", "."));
    }
}
