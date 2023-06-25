package Emperor.University.Emperor.University.service.serviceImpl;

import Emperor.University.Emperor.University.dto.StaffDto;
import Emperor.University.Emperor.University.dto.StaffReponseDto;
import Emperor.University.Emperor.University.entity.Staff;
import Emperor.University.Emperor.University.repository.FacultyRepo;
import Emperor.University.Emperor.University.repository.StaffRepo;
import Emperor.University.Emperor.University.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffRepo staffRepo;
    @Autowired
    FacultyRepo facultyRepo;
    @Override
    public StaffReponseDto registerStaff(StaffDto staffDto) {
        Staff staff = new Staff();
        staff.setFirstName(staffDto.getFirstName());
        staff.setLastName(staffDto.getLastName());
        staff.setOtherName(staffDto.getOtherName());
        staff.setJobDescription(staffDto.getJobDescription());
        staff.setFaculty(facultyRepo.findById(staffDto.getFacultyId()).get());
        staffRepo.save(staff);

        return StaffReponseDto.builder()
                .firstName(staff.getFirstName())
                .lastName(staff.getLastName())
                .otherName(staff.getOtherName())
                .gender(staff.getGender())
                .jobDescription(staff.getJobDescription())
                .staffType(staff.getStaffType())
                .facultyName(facultyRepo.findById(staffDto.getFacultyId()).get().getFacultyName())
                .build();
    }

    @Override
    public List<StaffReponseDto> printAllStaff() {
        return null;
    }

    @Override
    public StaffReponseDto updateStaff(long id, StaffDto staffDto) {
        return null;
    }

    @Override
    public String deleteStaff(Long id) {
        return null;
    }
}
