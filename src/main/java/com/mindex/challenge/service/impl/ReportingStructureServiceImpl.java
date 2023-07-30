package com.mindex.challenge.service.impl;


import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    @Autowired
    private EmployeeService employeeService;

    //removed the @Autowired annotation
    private ReportingStructure reportingStructure;

    @Override
    public ReportingStructure read(String emId) {

        Employee employee = employeeService.read(emId);
        ReportingStructure reportingStructure = new ReportingStructure(employee, 0);
        reportingStructure.calculateNumberOfReports();

       return reportingStructure;
    }

}