package com.example.stringcalculatorkata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class StringCalculatorKataController {

    private final StringCalculatorKataService stringCalculatorKataService;

    @Autowired
    public StringCalculatorKataController(StringCalculatorKataService stringCalculatorKataService) {
        this.stringCalculatorKataService = stringCalculatorKataService;
    }

    @PostMapping(value="/add", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String add(@RequestBody String string) throws Exception {
        int sum = stringCalculatorKataService.add(string);
        return formJsonResponse(sum);
    }

    private String formJsonResponse(int sum) {
        return "{\"add\":{\"sum\":" + sum + "}}";
    }
}


