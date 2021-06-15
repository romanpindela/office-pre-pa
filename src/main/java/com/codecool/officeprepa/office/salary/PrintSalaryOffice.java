package com.codecool.officeprepa.office.salary;

import com.codecool.officeprepa.employee.Employee;
import com.codecool.officeprepa.office.Office;

import java.time.LocalDate;

public interface PrintSalaryOffice {
    String  printYearSalaryOneEmployee(SalaryCalculator sC, LocalDate date, Employee e);
    String printYearSalaryByEmployees( SalaryCalculator sC, LocalDate date );
}
