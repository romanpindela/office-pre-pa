package com.codecool.officeprepa.office;

import com.codecool.officeprepa.employee.Employee;
import com.codecool.officeprepa.employee.Leader;
import com.codecool.officeprepa.office.salary.SalaryCalculator;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class Office {
    List<Employee> employees;


    Map<String, Leader> groups;
    SalaryCalculator salaryCalculator;

    String officeName;


    public Office ( List<Employee> employees,
                    SalaryCalculator salaryCalculator,
                    Map<String, Leader> groups,
                    String officeName) {
        this.employees = employees;
        this.salaryCalculator = salaryCalculator;
        this.groups = groups;
        this.officeName = officeName;
    }
    public List<Employee> getEmployees (){
        return this.employees;
    }

    public abstract boolean hireEmployee(Employee e);

    public void addGroup(String group, Leader leader){
        groups.put(group, leader);
    }

    public void removeGroup(String group){
        groups.remove(group);
    }
    public Map<String, Leader> getGroups () {
        return groups;
    }

    public SalaryCalculator getSalaryCalculator () {
        return salaryCalculator;
    }

    public void fireEmployee( Employee e){
        employees.remove(e);
    }

    @Override
    public String toString () {
        return "Office{" +
                "employees=" + employees +
                '}';
    }

}
