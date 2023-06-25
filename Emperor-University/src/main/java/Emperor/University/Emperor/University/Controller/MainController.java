package Emperor.University.Emperor.University.Controller;


import Emperor.University.Emperor.University.dto.*;
import Emperor.University.Emperor.University.entity.Department;
import Emperor.University.Emperor.University.entity.Faculty;
import Emperor.University.Emperor.University.entity.Student;
import Emperor.University.Emperor.University.repository.StaffRepo;
import Emperor.University.Emperor.University.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emperor")
public class MainController {

    @Autowired
    StudentService studentService;
    @Autowired
    DepartmentService departmentService;

    @Autowired
    FacultyService facultyService;

    @Autowired
    LecturesService lecturesService;
//    @Autowired
//    private StaffRepo staffRepo;

    @Autowired
    private StaffService staffService;


    @PostMapping("/newstudent")
    public Student registerStudent(@RequestBody StudentDto studentDto){
        return studentService.registerStudent(studentDto);
    }
    @GetMapping()
    public List<StudentResponseDto> getAllStudent(){
        return studentService.printAllStudent();
    }

    @PutMapping("/student/{id}")
    public StudentResponseDto updateStudent(@PathVariable(name = "id") long id, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(id,studentDto);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable(name = "id") Long id) {
        return studentService.deleteStudent(id);
    }

    @PostMapping("/newdepartment")
    public DepartmentNewRegisterResponseDto registerDepartment (@RequestBody DepartmentDto department){
        return departmentService.registerDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment (@PathVariable(name = "id") Long id, @RequestBody Department department){
        return departmentService.updateDepartment(id,department);
    }

    @DeleteMapping
    public String deletedDepartment (Long id){
        return departmentService.deletedDepartment(id);
    }

    @GetMapping("/get")
    public List<DepartmentDto> getDepartment(){
        return departmentService.listedDepartment();
    }



    //faculty
    @PostMapping("/newfaculty")
    public String registerFaculty(@RequestBody Faculty faculty) {
        return facultyService.registerFaculty(faculty);
    }

    @GetMapping("/newfaculty")
    public List<FacultyListResponseDto> listedFaculties(){
        return facultyService.listedFaculties();
    }

    //Lecturers

    @PostMapping("/newlecturer")
    public LecturerResponseDto registerLecturer(@RequestBody LecturerDto lecturerDto){
        return lecturesService.registerLecturer(lecturerDto);
    }
    @GetMapping("/newlecturer")
    public List<LecturerResponseDto> printAllLecturers(){
        return lecturesService.printAllLecturers();
    }

    @PutMapping("/newlecturer/{id}")
    public LecturerResponseDto updateLecturer(@PathVariable(name = "id") long id,@RequestBody LecturerResponseDto lecturerResponseDto){
        return lecturesService.updateLecturer(id,lecturerResponseDto);
    }

//    @DeleteMapping("/{id}")
//    public String deleteLecturer(@PathVariable(name = "id") Long id){
//        return lecturesService.deleteLecturer(id);
//    }
//
//

    //staff
    @PostMapping("/newstaff")
    public StaffReponseDto registerStaff(@RequestBody StaffDto staffDto){
        return staffService.registerStaff(staffDto);
    }
}
