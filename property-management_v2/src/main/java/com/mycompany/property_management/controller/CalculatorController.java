package com.mycompany.property_management.controller;

import com.mycompany.property_management.model.CalculatorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/calculator") //class level Mapping
public class CalculatorController {
    //http://localhost:8080/api/v1/calculator/add?num11=5.1&num2=4.9
    @GetMapping("/add") // method level mapping
    public Double add(@RequestParam("num11") Double num1, @RequestParam("num2") Double num2) {
        return num1+num2; //this function expects two numbers
    }

    @GetMapping("/sub/{n1}-{n2}")
    public Double sub(@PathVariable("n1") double num11,@PathVariable("n2") double num22) {
        return num11-num22;
    }

    @PostMapping("/mul")
    public ResponseEntity<Double> mul(@RequestBody CalculatorModel calc) {
            Double result=null;
            result=calc.getNum1()*calc.getNum2()*calc.getNum3()*calc.getNum4();
            ResponseEntity<Double> resEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
            //Status code changed by ResponseEntity
            return resEntity;
    }
}
