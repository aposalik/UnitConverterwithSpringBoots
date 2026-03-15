package com.example.demo.converter;

public class WeightConverter implements Converter {
    @Override
    public double convert(double value,String from, String to) {
        return fromKg(toKg(value,from),to);
    }



    // To KG
    private double toKg(double value, String unit) {
        double result = 0.0;
        switch (unit) {
            case "kg":
                result = value * 1000;
                break;
            case "pound":
                result =  value * 453.592;
                break;
            case "ounce":
                result =  value * 28.3495;
                break;
            default:
                throw new IllegalArgumentException("Unknown unit: " + unit);
        }
        return result;
    }


    // From KG
    private double fromKg(double value, String unit) {
        double result = 0.0;

        switch (unit) {
            case "kg":
                result = value * 0.001;
                break;
            case "gram":
                result =  value * 1;
                break;
            case "pound":
                result =  value * 0.00220462;
                break;
            case "ounce":
                result =  value * 0.035274;
                break;
            default:
                throw new IllegalArgumentException("Unknown unit: " + unit);
        }

        return result;
    }

}
