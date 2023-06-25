package Emperor.University.Emperor.University.service.serviceImpl;

import Emperor.University.Emperor.University.dto.LecturerDto;
import Emperor.University.Emperor.University.dto.LecturerResponseDto;
import Emperor.University.Emperor.University.entity.Lecturers;
import Emperor.University.Emperor.University.repository.DepartmentRepo;
import Emperor.University.Emperor.University.repository.LecturerRepo;
import Emperor.University.Emperor.University.service.LecturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LecturerServiceImpl implements LecturesService {

    @Autowired
    LecturerRepo lecturerRepo;
    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public LecturerResponseDto registerLecturer(LecturerDto lecturerDto) {
        Lecturers newLecturer = new Lecturers();
        newLecturer.setFirstName(lecturerDto.getFirstName());
        newLecturer.setLastName(lecturerDto.getLastName());
        newLecturer.setOtherName(lecturerDto.getOtherName());
        newLecturer.setGender(lecturerDto.getGender());
//        newLecturer.setCourse(lecturerDto.getCourse());
        newLecturer.setAllCourses(lecturerDto.getAllCourses());
        newLecturer.setDepartment(departmentRepo.findById(lecturerDto.getDepartmentId()).get());
        lecturerRepo.save(newLecturer);

        return LecturerResponseDto.builder()
                .firstName(newLecturer.getFirstName())
                .lastName(newLecturer.getLastName())
                .otherName(newLecturer.getOtherName())
                .gender(newLecturer.getGender())
                .allCourses(newLecturer.getAllCourses())
                .departmentName(newLecturer.getDepartment().getName())
                .build();
    }

    @Override
    public List<LecturerResponseDto> printAllLecturers() {
       List<Lecturers> allLecturers = lecturerRepo.findAll();
       List<LecturerResponseDto> allLecturerResponseDto = new ArrayList<>();

       return allLecturers.stream().map((lecturer)->
           LecturerResponseDto.builder()
                   .firstName(lecturer.getFirstName())
                   .lastName(lecturer.getLastName())
                   .otherName(lecturer.getOtherName())
                   .gender(lecturer.getGender())
                   .allCourses(lecturer.getAllCourses())
                   .departmentName(departmentRepo.findById(lecturer.getId()).get().getName())
                   .build()).collect(Collectors.toList());
    }

    @Override
    public LecturerResponseDto updateLecturer(long id, LecturerResponseDto lecturerResponseDto) {
        if(lecturerRepo.existsById(id)){
            Lecturers lecturer = new Lecturers();
            lecturer.setFirstName(lecturerResponseDto.getFirstName());
            lecturer.setLastName(lecturerResponseDto.getLastName());
            lecturer.setOtherName(lecturerResponseDto.getOtherName());
            lecturer.setGender(lecturerResponseDto.getGender());
            lecturer.setAllCourses(lecturerResponseDto.getAllCourses());
            lecturer.setDepartment(departmentRepo.findById(lecturerResponseDto.getDepartmentId()).get());
            lecturerRepo.save(lecturer);

            return lecturerResponseDto.builder()
                    .firstName(lecturer.getFirstName())
                    .lastName(lecturer.getLastName())
                    .otherName(lecturer.getOtherName())
                    .gender(lecturer.getGender())
                    .departmentName(lecturer.getDepartment().getName())
                    .allCourses(lecturer.getAllCourses())
                    .build();

        }
        return null;

    }

    @Override
    public String deleteLecturer(Long id) {

        if (lecturerRepo.existsById(id)){
             lecturerRepo.deleteById(id);
             return "Lecturer has been deleted from the database";
        }
        return "lecturer does not exist";
    }
}
