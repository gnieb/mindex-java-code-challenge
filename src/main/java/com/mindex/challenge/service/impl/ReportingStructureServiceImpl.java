package com.mindex.challenge.service.impl;


import com.mindex.challenge.dao.EmployeeRepository;
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

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStructure read(String emId) {

        Employee employee = employeeService.read(emId);
        // return a new  ReportingStructure prior to calculation with 0 reports instantiated, so it can be dynamically calculated at endpoint.
        return new ReportingStructure(employee, 0);
    }

}