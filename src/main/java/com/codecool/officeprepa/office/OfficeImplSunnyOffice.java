package com.codecool.officeprepa.office;

import com.codecool.officeprepa.employee.Employee;
import com.codecool.officeprepa.employee.Leader;
import com.codecool.officeprepa.office.salary.SalaryCalculator;

import java.util.List;
import java.util.Map;

public class OfficeImplSunnyOffice extends Office{
    public OfficeImplSunnyOffice ( List<Employee> employees,
                                   SalaryCalculator salaryCalculator,
                                   Map<String, Leader> groups,
                                   String officeName) {
        super(employees, salaryCalculator, groups, officeName);
    }
}
