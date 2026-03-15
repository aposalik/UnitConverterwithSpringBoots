package com.example.demo.converter;

public class LengthConverter implements Converter {
    @Override
    public double convert(double value,String from, String to) {
        return fromMeters(toMeters(value,from),to);
    }


    // To Metress
    private double toMeters(double value, String unit) {
        double result = 0.0;
        switch (unit) {
            case "km":
                result = value * 1000;
                break;
            case "cm":
                result =  value * 0.01;
                break;
            case "mm":
                result =  value * 0.001;
            break;

            case "miles":
                result =  value * 1609.344;
            break;
            case "foot":
                result =  value * 0.3048;
            break;
            case "inch":
                result =  value * 0.0254;
            break;
            case "yard":
                result =  value * 0.9144;
            break;
            default:
                throw new IllegalArgumentException("Unknown unit: " + unit);
        }

        return result;
    }



    // From Meters
    private double fromMeters(double value, String unit) {
        double result = 0.0;

        switch (unit) {
            case "km":
                result = value * 0.001;
                break;
            case "cm":
                result =  value * 100;
                break;
            case "mm":
                result =  value * 1000;
                break;

            case "miles":
                result =  value * 0.000621371;
                break;
            case "foot":
                result =  value * 3.28084;
                break;
            case "inch":
                result =  value * 39.3701;
                break;
            case "yard":
                result =  value * 1.09361;
                break;
            default:
                throw new IllegalArgumentException("Unknown unit: " + unit);
        }

        return result;
    }



}
