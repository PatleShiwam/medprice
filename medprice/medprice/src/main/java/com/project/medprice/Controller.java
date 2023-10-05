package com.project.medprice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private RestService restService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/info/{medName}")
    public ResponseEntity<String> info(@PathVariable String medName){
        try {
            String result = restService.getDrugInfo(medName).block();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            // Handle the exception here and return an appropriate response
            return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
}
