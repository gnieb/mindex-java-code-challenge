package com.mindex.challenge.data;

import com.mindex.challenge.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashSet;
import java.util.List;
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

    public void calculateNumberOfReports() {
        int totalReports = calculateTotalReportsRecursive(employee);
        numberOfReports = totalReports - 1; // Exclude the root employee itself
    }

    private int calculateTotalReportsRecursive(Employee employee) {
        int totalReports = 1; // Count the current employee

        List<Employee> directReports = employee.getDirectReports();
        if (directReports != null) {
            for (Employee directReport : directReports) {
                totalReports += calculateTotalReportsRecursive(directReport);
            }
        }

        return totalReports;
    }
}









