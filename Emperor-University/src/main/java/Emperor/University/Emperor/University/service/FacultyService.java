package Emperor.University.Emperor.University.service;

import Emperor.University.Emperor.University.dto.DepartmentDto;
import Emperor.University.Emperor.University.dto.FacultyDto;
import Emperor.University.Emperor.University.dto.FacultyListResponseDto;
import Emperor.University.Emperor.University.entity.Faculty;

import java.util.List;

public interface FacultyService {

    String registerFaculty(Faculty faculty);
    List<FacultyListResponseDto> listedFaculties ();
}
