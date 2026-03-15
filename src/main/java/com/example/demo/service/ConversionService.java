package com.example.demo.service;
import com.example.demo.converter.LengthConverter;
import com.example.demo.converter.WeightConverter;
import org.springframework.stereotype.Service;

@Service
public class ConversionService {

    public double convert(double value, String from, String to, String category) {
        switch (category) {
            case "length":
                LengthConverter lengthConverter = new LengthConverter();
                return lengthConverter.convert(value, from, to) ;

            case "weight":
                WeightConverter weightConverter = new WeightConverter();
                return weightConverter.convert(value, from, to) ;
            default:
                throw new IllegalArgumentException("Unknown category: " + category);

        }
    }


}
