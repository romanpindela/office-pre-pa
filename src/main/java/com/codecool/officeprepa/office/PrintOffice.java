package com.codecool.officeprepa.office;

import com.codecool.officeprepa.employee.Employee;

import java.time.LocalDate;

public interface PrintOffice {
    String printEmployees(Office o);
    String printLeadersGroupsEmployees(Office o);

}
