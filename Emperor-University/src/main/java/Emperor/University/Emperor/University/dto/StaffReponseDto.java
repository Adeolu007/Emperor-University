package Emperor.University.Emperor.University.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffReponseDto {

    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String jobDescription;
    private String staffType;
    private String facultyName;
}
