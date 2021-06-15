package com.codecool.officeprepa.office.salary;

import com.codecool.officeprepa.employee.Employee;
import com.codecool.officeprepa.employee.Leader;
import com.codecool.officeprepa.employee.OfficeWorker;
import com.codecool.officeprepa.employee.SalesPerson;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalaryCalculatorSunnyOffice extends SalaryCalculator{


    private static final BigDecimal BONUS_AMOUNT_FOR_TEAM_MEMBER = BigDecimal.valueOf(200);

    public SalaryCalculatorSunnyOffice ( List<EntrySalary> salaryEntries, List<Employee> employees, Map<String, Leader> groups ) {
        super(salaryEntries, employees, groups);
    }

    @Override
    public List<EntrySalary> calculateSalaryForGivenMonth ( LocalDate date ) {
        List<EntrySalary> calculatedSalaryEntries = new ArrayList<>();
        BigDecimal calculatedSalary;
        for (Employee e : employees) {
            if (e instanceof OfficeWorker || e instanceof SalesPerson ){
                calculatedSalary = e.getContractSalary();
            } else if (e instanceof Leader) {
                int salaryBonusFactorLeader = findNumberOfEmployeesAssignedToLeaderGroup((Leader)e);

                calculatedSalary =
                        BONUS_AMOUNT_FOR_TEAM_MEMBER.multiply(BigDecimal.valueOf(salaryBonusFactorLeader));
                calculatedSalary = calculatedSalary.add(e.getContractSalary());

            } else { calculatedSalary = BigDecimal.valueOf(0); }
            calculatedSalaryEntries.add(new EntrySalary(
                    date,
                    e.getUniqueID(),
                    e.getName(),
                    calculatedSalary ));
        }
        return calculatedSalaryEntries;
    }

    private int findNumberOfEmployeesAssignedToLeaderGroup (Leader l) {
        int foundNumberOfEmployeesAssignedToLeaderinGroups = 0;
        for (Map.Entry<String, Leader> entryGroup : groups.entrySet()){
            if (entryGroup.getValue() == l) {
                for (Employee e : employees){
                    if (e.getGroupName().equals(entryGroup.getKey())){
                        foundNumberOfEmployeesAssignedToLeaderinGroups++;
                    }
                }
            }
        }
        return foundNumberOfEmployeesAssignedToLeaderinGroups;
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
