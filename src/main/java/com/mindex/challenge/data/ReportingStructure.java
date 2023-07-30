package com.mindex.challenge.data;

import com.mindex.challenge.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class ReportingStructure {

    private Employee employee;
    private int numberOfReports;

    @Autowired
    private EmployeeRepository employeeRepository;

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

    public void calculateNumberOfReports(EmployeeRepository employeeRepository) {
        Set<String> distinctReports = new HashSet<>();
        calculateNumberOfReportsRecursive(employee, distinctReports, employeeRepository);
        numberOfReports = distinctReports.size();
    }

    private void calculateNumberOfReportsRecursive(Employee employee, Set<String> distinctReports, EmployeeRepository employeeRepository) {
        List<Employee> directReports = employee.getDirectReports();
        if (directReports != null) {
            for (Employee directReport : directReports) {
                String directReportId = directReport.getEmployeeId();
                if (!distinctReports.contains(directReportId)) {
                    distinctReports.add(directReportId);

                    // Fetch the direct report separately using the EmployeeRepository
                    Employee fetchedDirectReport = employeeRepository.findByEmployeeId(directReportId);
                    if (fetchedDirectReport != null) {
                        calculateNumberOfReportsRecursive(fetchedDirectReport, distinctReports, employeeRepository);
                    }
                }
            }
        }
    }
}









