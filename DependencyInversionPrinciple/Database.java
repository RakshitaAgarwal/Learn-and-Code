package DependencyInversionPrinciple;

public class Database implements DatabaseAccess{

    @Override
    public void save(Employee employee) {
        // Code to save employee to the database
    }

}