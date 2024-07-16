package net.javaguides.departmentservice1.Controller;

import net.javaguides.departmentservice1.Dto.DepartmentDto;
import net.javaguides.departmentservice1.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController
{
    @Autowired
    private DepartmentService departmentService;

    //Build save department Rest API
     @PostMapping
      public ResponseEntity<DepartmentDto> savedDepartment(@RequestBody DepartmentDto departmentDto)
      {
          DepartmentDto savedDepartment=departmentService.saveDepartment(departmentDto);
          return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
      }

      //Build get department rest Api
      @GetMapping("{department-code}")
      public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode)
      {
          DepartmentDto departmentDto=departmentService.getDepartmentbyCode(departmentCode);
          return new ResponseEntity<>(departmentDto,HttpStatus.OK);
      }
}
