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
    public ReportingStructure read(String employeeId) {

        Employee employee = employeeService.read(employeeId);
        int allReports = employeeService.calculateNumberOfReports(employeeId);
        ReportingStructure reportingStructure = new ReportingStructure(employee, allReports);

       return reportingStructure;
    }

}

// the number of reports needs to come from the employee. all calculation logic needs to be put into the  employeeService file.