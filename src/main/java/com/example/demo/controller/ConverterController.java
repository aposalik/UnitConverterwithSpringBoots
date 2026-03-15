package com.example.demo.controller;

import com.example.demo.model.ConversionResponse;
import com.example.demo.model.ErrorResponse;
import com.example.demo.service.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConverterController {

    private final ConversionService conversionService;

    //constractor
    public ConverterController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/convert")
    public ResponseEntity<?> convert(@RequestParam double value, @RequestParam String from, @RequestParam String to, @RequestParam String category) {

        try {
            // success
            double result = conversionService.convert(value, from, to, category);
            return ResponseEntity.ok(new ConversionResponse(value,from,to,result));

        }catch(IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }

    }

}
