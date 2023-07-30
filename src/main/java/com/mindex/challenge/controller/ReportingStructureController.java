package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportingStructureController {
    @Autowired
    private ReportingStructureService reportingStructureService;

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    //this route works!!

    @GetMapping("/reporting/{emId}")
    public ReportingStructure read(@PathVariable String emId) {

        return reportingStructureService.read(emId);
    }
}
