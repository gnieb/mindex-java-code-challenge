package com.mindex.challenge.data;

import com.mindex.challenge.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashSet;
import java.util.Set;
public class ReportingStructure {

    private Employee employee;
    private int numberOfReports;

    // CONSTRUCTORS
    public ReportingStructure() {
        // Default constructor
    }

    public ReportingStructure(Employee employee, int numberOfReports) {
        this.employee = employee;
        this.numberOfReports = numberOfReports;
    }


    //GETTERS
    public Employee getEmployee() {
        return employee;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    //SETTERS
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }




}






