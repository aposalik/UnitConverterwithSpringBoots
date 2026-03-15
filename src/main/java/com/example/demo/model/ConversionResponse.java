package com.example.demo.model;

public class ConversionResponse {
    private double value;
    private String from;
    private String to;
    private double result;

    public ConversionResponse(double value, String from, String to, double result) {
        this.value = value;
        this.from = from;
        this.to = to;
        this.result = result;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public double getResult() {
        return result;
    }

}
