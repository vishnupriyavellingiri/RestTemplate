package net.javaguides.employeeservice1.Service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice1.Dto.APIResponseDto;
import net.javaguides.employeeservice1.Dto.DepartmentDto;
import net.javaguides.employeeservice1.Dto.EmployeeDto;
import net.javaguides.employeeservice1.Entity.Employee;
import net.javaguides.employeeservice1.Repository.EmployeeRepository;
import net.javaguides.employeeservice1.Service.APIClient;
import net.javaguides.employeeservice1.Service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
  // private RestTemplate restTemplate;
   private WebClient webClient;


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto)
    {
      Employee employee= modelMapper.map(employeeDto, Employee.class);
      Employee savedEmployee=employeeRepository.save(employee);
      EmployeeDto savedEmployeeDto=modelMapper.map(savedEmployee,EmployeeDto.class);
        return savedEmployeeDto;
    }
    @Override
    public APIResponseDto getEmployeeById(Long employeeIds)
    {
        Employee employee= employeeRepository.findById(employeeIds).get();

        //Rest Template
//       ResponseEntity<DepartmentDto> responseEntity=
//               restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),
//               DepartmentDto.class);
//       DepartmentDto departmentDto= responseEntity.getBody();

        //web client
       DepartmentDto departmentDto= webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
                 .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();    //block used to make that api synchronous



      EmployeeDto employeeDto= modelMapper.map(employee,EmployeeDto.class);
        APIResponseDto apiResponseDto=new APIResponseDto();
                       apiResponseDto.setEmployee(employeeDto);
                       apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

}
