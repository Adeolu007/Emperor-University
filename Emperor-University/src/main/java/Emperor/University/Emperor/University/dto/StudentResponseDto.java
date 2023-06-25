package Emperor.University.Emperor.University.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String departmentName;
}
