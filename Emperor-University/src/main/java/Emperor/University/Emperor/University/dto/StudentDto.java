package Emperor.University.Emperor.University.dto;

import Emperor.University.Emperor.University.entity.Department;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class StudentDto {

    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private Long departmentId;
}
