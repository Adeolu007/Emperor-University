package Emperor.University.Emperor.University.service;

import Emperor.University.Emperor.University.dto.StaffDto;
import Emperor.University.Emperor.University.dto.StaffReponseDto;

import java.util.List;

public interface StaffService {
    StaffReponseDto registerStaff (StaffDto staffDto);
    List<StaffReponseDto> printAllStaff();
    StaffReponseDto updateStaff(long id, StaffDto staffDto);
    String deleteStaff (Long id);
}
