package com.codecool.officeprepa.office.salary;

import com.codecool.officeprepa.employee.Employee;
import com.codecool.officeprepa.office.Office;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public abstract class SalaryCalculator {
    List<EntrySalary> salaryCalculatorEntries;
    List<Employee> employees;

    public SalaryCalculator ( List<EntrySalary> sCalculator, List<Employee> employees ) {
        this.salaryCalculatorEntries = sCalculator;
        this.employees = employees;
    }



    public boolean calculateSalary (LocalDate date){
        for (Employee e : employees) {
            calculateSalaryForEmployee(date, e);
        }
        return false;
    }

    protected abstract void calculateSalaryForEmployee (LocalDate date, Employee e );
    public abstract Optional<List<EntrySalary>> getMonthSalaryEntries ( LocalDate date, Employee e);
    public abstract Optional<List<EntrySalary>> getYearSalaryEntries(LocalDate date, Employee e);
    public abstract Optional<List<EntrySalary>> getYearSalaryByEmployeesEntries(LocalDate date);

    public boolean deleteSalaryMonth ( LocalDate date){
        return salaryCalculatorEntries.removeIf(e -> e.getMonth() == date.getMonth().getValue());
    }

}
