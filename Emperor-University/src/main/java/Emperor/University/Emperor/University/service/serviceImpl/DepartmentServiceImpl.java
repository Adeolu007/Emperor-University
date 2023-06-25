package Emperor.University.Emperor.University.service.serviceImpl;

import Emperor.University.Emperor.University.dto.DepartmentDto;
import Emperor.University.Emperor.University.dto.DepartmentNewRegisterResponseDto;
import Emperor.University.Emperor.University.entity.Department;
import Emperor.University.Emperor.University.entity.Faculty;
import Emperor.University.Emperor.University.repository.DepartmentRepo;
import Emperor.University.Emperor.University.repository.FacultyRepo;
import Emperor.University.Emperor.University.repository.StudentRepo;
import Emperor.University.Emperor.University.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    FacultyRepo facultyRepo;

    @Override
    public DepartmentNewRegisterResponseDto registerDepartment(DepartmentDto department) {
        Department newDepartment = new Department();
        newDepartment.setName(department.getName());
        newDepartment.setDescription(department.getDescription());
        newDepartment.setFaculty(facultyRepo.findById(department.getFacultyId()).get());
//        newDepartment.setFaculty(facultyRepo.findById(department.getFacultyId()).get());
//        newDepartment.setStudents(department.getStudents());
        departmentRepo.save(newDepartment);

        DepartmentNewRegisterResponseDto newDto = new DepartmentNewRegisterResponseDto();

        return newDto.builder()
                .name(newDepartment.getName())
                .description(newDepartment.getDescription())
                .facultyName(newDepartment.getFaculty().getFacultyName())
                .build();
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        if(departmentRepo.existsById(id)){
            Department newDepartment = new Department();
            newDepartment.setName(department.getName());
            newDepartment.setDescription(department.getDescription());
            departmentRepo.save(newDepartment);
            return newDepartment;
        }

        return null;
    }

    @Override
    public String deletedDepartment(Long id) {
        if(departmentRepo.existsById(id)){
            departmentRepo.deleteById(id);
            return  "The department has been deleted";
        }
        return "Department has been deleted.";
    }

    @Override
    public List<DepartmentDto> listedDepartment() {


        List<Department> allDepartment =  departmentRepo.findAll();

        return allDepartment.stream().map(department -> DepartmentDto.builder()
                 .name(department.getName())
                 .description(department.getDescription())
                 .students(studentRepo.findStudentByDepartment(department.getId()))
                 .build()).collect(Collectors.toList());

//        for(Department newDepartment: allDepartment){
//            Department department = new Department();
//            department.setName(newDepartment.getName());
//            department.setDescription(newDepartment.getDescription());
//            department.setStudents(studentRepo.findStudentByDepartment(newDepartment.getId()));
//            departmentRepo.save(department);
////            allDepartment.add(department);
//        }
//        return allDepartment;
    }
}
