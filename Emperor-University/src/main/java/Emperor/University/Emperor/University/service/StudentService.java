package Emperor.University.Emperor.University.service;

import Emperor.University.Emperor.University.dto.StudentDto;
import Emperor.University.Emperor.University.dto.StudentResponseDto;
import Emperor.University.Emperor.University.entity.Student;

import java.util.List;

public interface StudentService {
    Student registerStudent (StudentDto studentDto);
    List<StudentResponseDto> printAllStudent();

    StudentResponseDto updateStudent (long id, StudentDto studentDto);

    String deleteStudent (Long id);
}
