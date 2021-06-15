package com.codecool.officeprepa.office.salary;

import com.codecool.officeprepa.employee.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalaryCalculatorSunnyOffice extends SalaryCalculator{

    public SalaryCalculatorSunnyOffice ( List<EntrySalary> sCalculator, List<Employee> employees ) {
        super(sCalculator, employees);
    }

    @Override
    protected void calculateSalaryForEmployee ( LocalDate date, Employee e ) {

    }

    @Override
    public Optional<List<EntrySalary>> getMonthSalaryEntries ( LocalDate date, Employee e) {
        List<EntrySalary> maybeResults
                = salaryCalculatorEntries.stream()
                .filter(entry -> entry.employeeUniqueID.equals(e.getUniqueID()))
                .filter(entry -> {
                    return entry.salaryDate.getYear() == date.getYear() &&
                            entry.salaryDate.getMonthValue() == date.getMonthValue();
                    }
                ).collect(Collectors.toList());
        return Optional.of(maybeResults);
    }

    @Override
    public Optional<List<EntrySalary>> getYearSalaryEntries ( LocalDate date, Employee e) {
        List<EntrySalary> employeeSalaryEntriesWholeYear = new ArrayList<EntrySalary>();

        for (int monthCount = 1; monthCount <= 12; monthCount++) {
            LocalDate currentDate = LocalDate.of(date.getYear(), monthCount, 1);
            Optional<List<EntrySalary>> maybeCurrentMonthSalary =
                    getMonthSalaryEntries(currentDate, e);
            if (maybeCurrentMonthSalary.isPresent()){
                employeeSalaryEntriesWholeYear.addAll(maybeCurrentMonthSalary.get());
            }
        }
        return Optional.of(employeeSalaryEntriesWholeYear);
    }

    @Override
    public Optional<List<EntrySalary>> getYearSalaryByEmployeesEntries ( LocalDate date ) {
        List<EntrySalary> employeesSalaryEntriesWholeYearByEmployee = new ArrayList<EntrySalary>();
        for (Employee e : employees){
            Optional<List<EntrySalary>> maybeSalaryYearEmployee =
                    getYearSalaryEntries(date , e);
            if (maybeSalaryYearEmployee.isPresent()){
                employeesSalaryEntriesWholeYearByEmployee.addAll(maybeSalaryYearEmployee.get());
            }
        }
        return Optional.of(employeesSalaryEntriesWholeYearByEmployee);
    }

}
