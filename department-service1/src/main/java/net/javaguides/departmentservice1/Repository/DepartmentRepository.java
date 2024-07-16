package net.javaguides.departmentservice1.Repository;

import net.javaguides.departmentservice1.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DepartmentRepository extends JpaRepository<Department,Long>
{
        Department findByDepartmentCode(String departmentCode);
}
