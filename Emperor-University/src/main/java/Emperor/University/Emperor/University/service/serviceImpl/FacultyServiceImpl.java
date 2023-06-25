package Emperor.University.Emperor.University.service.serviceImpl;

import Emperor.University.Emperor.University.dto.FacultyListResponseDto;
import Emperor.University.Emperor.University.entity.Department;
import Emperor.University.Emperor.University.entity.Faculty;
import Emperor.University.Emperor.University.repository.DepartmentRepo;
import Emperor.University.Emperor.University.repository.FacultyRepo;
import Emperor.University.Emperor.University.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepo facultyRepo;
    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public String registerFaculty(Faculty faculty) {
        Faculty newFaculty = new Faculty();
        newFaculty.setFacultyName(faculty.getFacultyName());
        newFaculty.setDescription(faculty.getDescription());
        facultyRepo.save(newFaculty);
        return newFaculty.getFacultyName() + " has been created";
    }

    @Override
    public List<FacultyListResponseDto> listedFaculties() {
        List<Faculty> allFaculties = facultyRepo.findAll();
//        List<FacultyDto> allFacultiesDto= new ArrayList<>();
//       List<FacultyListResponseDto> responseList = new ArrayList<>();
        return allFaculties.stream().map((faculty -> FacultyListResponseDto.builder()
                .facultyName(faculty.getFacultyName())
                .description(faculty.getDescription())
                .departmentName(getDepartmentByFaculty(faculty.getId()))
                .build())).collect(Collectors.toList());
//        for(Faculty fac : allFaculties){
//            FacultyListResponseDto faculty = new FacultyListResponseDto();
//            faculty.setFacultyName(fac.getFacultyName());
//            faculty.setDescription(fac.getDescription());
//            faculty.setDepartmentName(departmentRepo.findDepartmentByFaculty(fac));
//            dto.add(faculty);
//        }
    }

    private List<String> getDepartmentByFaculty(Long id) {

        List<Department> departments = departmentRepo.findByFacultyId(id);
        return departments.stream().map(Department::getName).collect(Collectors.toList());
    }
}
