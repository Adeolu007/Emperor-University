package Emperor.University.Emperor.University.dto;

import Emperor.University.Emperor.University.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyListResponseDto {

    private String facultyName;
    private String description;
    private List<String> departmentName;
}
