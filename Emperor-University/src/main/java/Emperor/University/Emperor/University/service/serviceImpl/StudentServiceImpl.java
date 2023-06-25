package Emperor.University.Emperor.University.service.serviceImpl;

import Emperor.University.Emperor.University.dto.StudentDto;
import Emperor.University.Emperor.University.dto.StudentResponseDto;
import Emperor.University.Emperor.University.entity.Department;
import Emperor.University.Emperor.University.entity.Student;
import Emperor.University.Emperor.University.repository.DepartmentRepo;
import Emperor.University.Emperor.University.repository.StudentRepo;
import Emperor.University.Emperor.University.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    DepartmentRepo departmentRepo;
    @Override
    public Student registerStudent(StudentDto studentDto) {

//        Department department = departmentRepo.findById(departmentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Student newStudent = new Student();
        if(departmentRepo.existsById(studentDto.getDepartmentId())){
                    newStudent.setFirstName(studentDto.getFirstName());
        newStudent.setLastName(studentDto.getLastName());
        newStudent.setOtherName(studentDto.getOtherName());
        newStudent.setGender(studentDto.getGender());
        newStudent.setDepartment(departmentRepo.findById(studentDto.getDepartmentId()).get());
        studentRepo.save(newStudent);
        return newStudent;

        } return null;}

    @Override
    public List<StudentResponseDto> printAllStudent() {
        List<Student> studentList = studentRepo.findAll();
        return studentList.stream().map(student -> StudentResponseDto.builder()
                .firstName(student.getFirstName())
                .otherName(student.getOtherName())
                .lastName(student.getLastName())
                .gender(student.getGender())
                .departmentName(student.getDepartment() == null ? null : student.getDepartment().getName())
                .build()).collect(Collectors.toList());
    }

    @Override
    public StudentResponseDto updateStudent(long id, StudentDto studentDto) {
        if(studentRepo.existsById(id)){
            Student newStudent = studentRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
            newStudent.setFirstName(studentDto.getFirstName());
            newStudent.setLastName(studentDto.getLastName());
            newStudent.setOtherName(studentDto.getOtherName());
            newStudent.setGender(studentDto.getGender());
            newStudent.setDepartment(departmentRepo.findById(studentDto.getDepartmentId()).get());
            studentRepo.save(newStudent);

            return StudentResponseDto.builder()
                    .firstName(newStudent.getFirstName())
                    .lastName(newStudent.getLastName())
                    .otherName(newStudent.getOtherName())
                    .gender(newStudent.getGender())
                    .departmentName(newStudent.getDepartment().getName())
                    .build();


        }
        return null;
    }

    @Override
    public String deleteStudent(Long id) {
        if(studentRepo.existsById(id)){
            Student student = studentRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
            studentRepo.deleteById(id);
            return student.getFirstName() + " " + student.getLastName() + " has been deleted from our database";
        }

        return "The student does not exist";
    }


}
