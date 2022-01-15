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

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String add(@RequestBody(required = false) String string) throws Exception {
        string = convertStringToEmptyIfNull(string);
        int sum = stringCalculatorKataService.add(string);
        return formJsonResponse(sum);
    }

    private String convertStringToEmptyIfNull(String string) {
        if(string ==null)
            string = "";
        return string;
    }

    private String formJsonResponse(int sum) {
        return "{\"add\":{\"sum\":" + sum + "}}";
    }
}


