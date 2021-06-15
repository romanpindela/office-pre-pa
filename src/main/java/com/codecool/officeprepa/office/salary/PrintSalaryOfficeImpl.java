package com.codecool.officeprepa.office.salary;

import com.codecool.officeprepa.employee.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PrintSalaryOfficeImpl implements PrintSalaryOffice{
    @Override
    public String printYearSalaryOneEmployee ( SalaryCalculator sC, LocalDate date, Employee e ) {
        StringBuilder sb = new StringBuilder();
        Optional<List<EntrySalary>> maybeYearSalary = sC.getYearSalaryEntries(date, e);

        sb.append("----------------------------\n");
        sb.append("Employee's year salary: " + e.getName() + "\n");
        sb.append("----------------------------\n");

        if (maybeYearSalary.isPresent()){
            for (EntrySalary entry : maybeYearSalary.get()){
                sb.append(entry + "\n");
            }
        } else {
            sb.append("<< no records found >>> \n");
            sb.append("----------------------------\n");
        }
        return sb.toString();
    }


    @Override
    public String printYearSalaryByEmployees ( SalaryCalculator sC, LocalDate date ) {
        StringBuilder sb = new StringBuilder();
        Optional<List<EntrySalary>> maybeYearSalary = sC.getYearSalaryByEmployeesEntries(date);

        sb.append("----------------------------\n");
        sb.append("Year's salary by employee: \n");
        sb.append("----------------------------\n");

        if (maybeYearSalary.isPresent()){
            for (EntrySalary entry : maybeYearSalary.get()){
                sb.append(entry + "\n");
            }
        } else {
            sb.append("<< no records found >>> \n");
            sb.append("----------------------------\n");
        }

        return sb.toString();

    }
}
