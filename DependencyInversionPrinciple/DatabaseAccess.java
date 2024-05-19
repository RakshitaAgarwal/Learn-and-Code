package DependencyInversionPrinciple;

import DependencyInversionPrinciple.model.Employee;

public interface DatabaseAccess {
    public void save(Employee employee);   
}