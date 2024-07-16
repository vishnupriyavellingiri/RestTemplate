package net.javaguides.departmentservice1.Service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice1.Dto.DepartmentDto;
import net.javaguides.departmentservice1.Entity.Department;
import net.javaguides.departmentservice1.Repository.DepartmentRepository;
import net.javaguides.departmentservice1.Service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto)
    {
       Department department= modelMapper.map(departmentDto,Department.class);
       Department savedDepartment=departmentRepository.save(department);
       DepartmentDto savedDepartmentDto=modelMapper.map(savedDepartment,DepartmentDto.class);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentbyCode(String departmentcode)
    {
        Department department=departmentRepository.findByDepartmentCode(departmentcode);
        DepartmentDto departmentDto=modelMapper.map(department,DepartmentDto.class);
        return departmentDto;
    }
}
