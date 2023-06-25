package Emperor.University.Emperor.University.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LecturerResponseDto {
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String[] allCourses;
    private Long departmentId;
    private String departmentName;
}
