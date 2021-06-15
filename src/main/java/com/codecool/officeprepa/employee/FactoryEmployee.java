package com.codecool.officeprepa.employee;

import java.math.BigDecimal;
import java.util.UUID;

public class FactoryEmployee {

    public static Employee getInstance( String typeOfEmployee, String name,
                                String groupName,
                                BigDecimal contractSalary ){
        return switch(typeOfEmployee.toLowerCase()){
            case "leader" ->
                    new Leader(name, UUID.randomUUID().toString(),groupName,contractSalary);
            case "salesperson" ->
                    new SalesPerson(name,UUID.randomUUID().toString(),groupName,contractSalary);
            case "officeworker" ->
                    new OfficeWorker(name, UUID.randomUUID().toString(), groupName, contractSalary);
            default -> throw new IllegalArgumentException("Wrong input for typeOfEmployee");
        };
    }
}
