package com.codecool.officeprepa.employee;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public abstract class Employee {
    protected String name;
    protected String uniqueID;

    protected String groupName;

    protected BigDecimal contractSalary;


    public String createUniqueID(){
        return UUID.randomUUID().toString();
    }


    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Employee employee = (Employee) o;
        return uniqueID.equals(employee.uniqueID);
    }


    @Override
    public int hashCode () {
        return Objects.hash(uniqueID);
    }

    @Override
    public String toString () {
        return "Employee{" +
                "name='" + name + '\'' +
                ", uniqueID='" + uniqueID + '\'' +
                ", groupName='" + groupName + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName () {
        return name;
    }

    public String getUniqueID () {
        return uniqueID;
    }

    public String getGroupName () {
        return groupName;
    }

    public BigDecimal getContractSalary () {
        return contractSalary;
    }
}
