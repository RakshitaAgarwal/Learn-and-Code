package DependencyInversionPrinciple;

import DependencyInversionPrinciple.model.Employee;

public class EmployeeService {
    private DatabaseAccess databaseAccess;

    public EmployeeService(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public void saveEmployee(Employee employee) {
        databaseAccess.save(employee);
    }
}