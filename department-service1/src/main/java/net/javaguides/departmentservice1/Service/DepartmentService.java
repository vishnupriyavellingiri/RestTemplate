package net.javaguides.departmentservice1.Service;

import net.javaguides.departmentservice1.Dto.DepartmentDto;

public interface DepartmentService {
       DepartmentDto saveDepartment(DepartmentDto departmentDto);

       DepartmentDto getDepartmentbyCode(String code);
}
