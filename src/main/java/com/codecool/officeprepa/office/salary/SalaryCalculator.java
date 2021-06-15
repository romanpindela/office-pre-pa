package com.codecool.officeprepa.office.salary;

import com.codecool.officeprepa.employee.Employee;
import com.codecool.officeprepa.employee.Leader;
import com.codecool.officeprepa.employee.OfficeWorker;
import com.codecool.officeprepa.employee.SalesPerson;
import com.codecool.officeprepa.office.Office;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class SalaryCalculator {
    List<EntrySalary> salaryCalculatorEntries;
    List<Employee> employees;
    Map<String, Leader> groups;

    public SalaryCalculator ( List<EntrySalary> sCalculator, List<Employee> employees, Map<String, Leader> groups) {

        this.salaryCalculatorEntries = sCalculator;
        this.employees = employees;
        this.groups = groups;
    }



    public abstract List<EntrySalary> calculateSalaryForGivenMonth ( LocalDate date );

    public boolean addCalculatedSalaryOfMonth (List<EntrySalary> monthSalary){
        return this.salaryCalculatorEntries.addAll(monthSalary);
    }

    public abstract Optional<List<EntrySalary>> getMonthSalaryEntries ( LocalDate date, Employee e);
    public abstract Optional<List<EntrySalary>> getYearSalaryEntries(LocalDate date, Employee e);
    public abstract Optional<List<EntrySalary>> getYearSalaryByEmployeesEntries(LocalDate date);

    public boolean deleteSalaryMonth ( LocalDate date){
        return salaryCalculatorEntries.removeIf(e -> e.getMonth() == date.getMonth().getValue());
    }

}
