package net.javaguides.employeeservice1.Service;

import net.javaguides.employeeservice1.Dto.APIResponseDto;
import net.javaguides.employeeservice1.Dto.EmployeeDto;

public interface EmployeeService
{
       EmployeeDto saveEmployee(EmployeeDto employeeDto);

       APIResponseDto getEmployeeById(Long employeeIds);
}
