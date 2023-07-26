package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ReportingStructureServiceImpl {
    public ReportingStructure getReportingStructure(Employee employee) {
        int numberOfReports = calculateNumberOfReports(employee);
        return new ReportingStructure(employee, numberOfReports);
    }

    // Helper method to calculate the number of reports recursively
    private int calculateNumberOfReports(Employee employee) {
        int count = 0;
        if (employee.getDirectReports() != null) {
            Set<String> distinctReports = new HashSet<>();
            for (Employee directReport : employee.getDirectReports()) {
                // Count the direct report
                count++;
                // Recursively calculate the number of reports for each direct report
                count += calculateNumberOfReports(directReport);

                // Add distinct reports to the set to avoid double counting in case of a reporting cycle
                distinctReports.add(directReport.getEmployeeId());
            }
            // Subtract the number of distinct reports from the count to avoid overcounting
            count -= distinctReports.size();
        }
        return count;
    }
}
