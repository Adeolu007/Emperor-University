package Emperor.University.Emperor.University.dto;

import lombok.Data;

@Data
public class LecturerDto {
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
//    private String course;
private String[] allCourses;
    private Long departmentId;

}
