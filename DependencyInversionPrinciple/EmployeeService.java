package DependencyInversionPrinciple;

//Apply the Dependency Inversion Principle (DIP) by refactoring a set of classes
// Note: Also mention why this code violating DIP

public class EmployeeService {
    private Database database = new Database();

    public void saveEmployee(Employee employee) {
        database.save(employee);
    }
}

public class Database {
    public void save(Employee employee) {
        // Code to save employee to the database
    }
}

public class Employee {
    private String name;
    private String address;

    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getters and setters
}