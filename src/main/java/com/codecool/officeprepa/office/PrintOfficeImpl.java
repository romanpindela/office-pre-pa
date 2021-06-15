package com.codecool.officeprepa.office;

import com.codecool.officeprepa.employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PrintOfficeImpl implements PrintOffice {

    @Override
    public String printEmployees ( Office o ) {
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------------\n");
        sb.append("Office employees: \n");
        sb.append("----------------------------\n");
        int employeeCounter = 0;
        for (Employee e : o.getEmployees()){
            sb.append(++employeeCounter + ". " + e + "\n");
        }
        sb.append("----------------------------\n");
        sb.append("all emplyees: " + employeeCounter);
        return sb.toString();
    }

    @Override
    public String printLeadersGroupsEmployees ( Office o ) {
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------------\n");
        sb.append("Groups' employees: \n");
        sb.append("----------------------------\n");
        for (String group : o.groups.keySet()){
            int employeeCounter = 0;
            sb.append(">> group: " + group + " \n");

            for (Employee e : o.getEmployees()){
                if (e.getGroupName() == group){
                    sb.append(++employeeCounter + ". " + e + "\n");
                }
            }
        }
        sb.append("----------------------------\n");
        sb.append("all groups: " + o.groups.keySet().size());
        return sb.toString();
    }


}
