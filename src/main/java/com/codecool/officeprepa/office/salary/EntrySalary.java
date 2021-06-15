package com.codecool.officeprepa.office.salary;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EntrySalary {
    LocalDate salaryDate;
    String employeeUniqueID;
    String employeeName;
    BigDecimal employeeCalculatedSalary;


    public EntrySalary ( LocalDate salaryDate, String employeeUniqueID, String employeeName, BigDecimal employeeCalculatedSalary ) {
        this.salaryDate = salaryDate;
        this.employeeUniqueID = employeeUniqueID;
        this.employeeName = employeeName;
        this.employeeCalculatedSalary = employeeCalculatedSalary;
    }

    public int getMonth(){
        return salaryDate.getMonth().getValue();
    }

    public int getYear(){
        return salaryDate.getYear();
    }

    @Override
    public String toString () {
        return "EntrySalary{" +
                "salaryDate=" + salaryDate +
                ", employeeName='" + employeeName + '\'' +
                ", employeeCalculatedSalary=" + employeeCalculatedSalary +
                ", employeeUniqueID='" + employeeUniqueID + '\'' +
                '}';
    }

    public LocalDate getSalaryDate () {
        return salaryDate;
    }

    public void setSalaryDate ( LocalDate salaryDate ) {
        this.salaryDate = salaryDate;
    }

    public String getEmployeeUniqueID () {
        return employeeUniqueID;
    }

    public void setEmployeeUniqueID ( String employeeUniqueID ) {
        this.employeeUniqueID = employeeUniqueID;
    }

    public String getEmployeeName () {
        return employeeName;
    }

    public void setEmployeeName ( String employeeName ) {
        this.employeeName = employeeName;
    }

    public BigDecimal getEmployeeCalculatedSalary () {
        return employeeCalculatedSalary;
    }

    public void setEmployeeCalculatedSalary ( BigDecimal employeeCalculatedSalary ) {
        this.employeeCalculatedSalary = employeeCalculatedSalary;
    }
}
