package com.codecool.officeprepa.employee;

import java.math.BigDecimal;

public class OfficeWorker extends Employee {
    public OfficeWorker ( String name, String uniqueID, String groupName, BigDecimal contractSalary ) {
        super(name, uniqueID, groupName, contractSalary);
    }
}
