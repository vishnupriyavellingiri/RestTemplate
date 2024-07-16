package net.javaguides.employeeservice1.Controller;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice1.Dto.APIResponseDto;
import net.javaguides.employeeservice1.Dto.EmployeeDto;
import net.javaguides.employeeservice1.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController
{
    private EmployeeService employeeService;

    //BUILD save Employee Rest Api
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody  EmployeeDto employeeDto)
    {
        EmployeeDto savedEmployee=employeeService.saveEmployee(employeeDto);
        return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //BUID Get Employee Rest API
    @GetMapping("{id}")
    public  ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId)
    {
        APIResponseDto apiResponseDto=employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }
}
