package Emperor.University.Emperor.University.service;

import Emperor.University.Emperor.University.dto.LecturerDto;
import Emperor.University.Emperor.University.dto.LecturerResponseDto;

import Emperor.University.Emperor.University.entity.Lecturers;


import java.util.List;

public interface LecturesService {

    LecturerResponseDto registerLecturer (LecturerDto lecturerDto);
    List<LecturerResponseDto> printAllLecturers();

    LecturerResponseDto updateLecturer (long id, LecturerResponseDto lecturerResponseDto);

    String deleteLecturer (Long id);
}
