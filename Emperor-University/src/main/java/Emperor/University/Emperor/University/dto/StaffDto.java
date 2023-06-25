package Emperor.University.Emperor.University.dto;

import lombok.Data;

@Data
public class StaffDto {
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String jobDescription;
    private String staffType;
    private Long facultyId;
}
