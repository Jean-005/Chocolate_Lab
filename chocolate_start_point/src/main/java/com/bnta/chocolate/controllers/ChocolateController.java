package com.bnta.chocolate.controllers;


import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(@RequestParam(required = false, name = "cocoaPercentage") Integer cocoaPercentage) {
        return new ResponseEntity<>(chocolateService.getAllChocolates(), HttpStatus.OK);

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Chocolate>> getChocolate(@PathVariable Long id){
        return new ResponseEntity(chocolateService.findSingleChocolate(id), HttpStatus.OK);
    }

}
