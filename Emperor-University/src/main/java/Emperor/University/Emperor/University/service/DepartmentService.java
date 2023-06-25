package Emperor.University.Emperor.University.service;

import Emperor.University.Emperor.University.dto.DepartmentDto;
import Emperor.University.Emperor.University.dto.DepartmentNewRegisterResponseDto;
import Emperor.University.Emperor.University.entity.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentNewRegisterResponseDto registerDepartment (DepartmentDto department);
    Department updateDepartment (Long id, Department department);

    String deletedDepartment (Long id);

    List<DepartmentDto> listedDepartment ();
}
