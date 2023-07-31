package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {

    @Autowired
    private CompensationService compensationService;

    @PostMapping("/compensation")
    @ResponseStatus(HttpStatus.CREATED)
    public Compensation createCompensation(@RequestBody Compensation compensation) {
        return compensationService.createCompensation(compensation);
    }
    // emId = employee ID
    @GetMapping("/compensation/{emId}")
    public Compensation readCompensationByEmployeeId(@PathVariable String emId) {
        return compensationService.readCompensationByEmployeeId(emId);
    }

}
