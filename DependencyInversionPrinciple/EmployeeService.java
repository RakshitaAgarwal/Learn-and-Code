package DependencyInversionPrinciple;

public class EmployeeService {
    private DatabaseAccess databaseAccess;

    public EmployeeService(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public void saveEmployee(Employee employee) {
        databaseAccess.save(employee);
    }
}