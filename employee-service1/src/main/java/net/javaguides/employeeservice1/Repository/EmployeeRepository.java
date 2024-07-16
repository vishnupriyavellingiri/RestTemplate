package net.javaguides.employeeservice1.Repository;

import net.javaguides.employeeservice1.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
}
