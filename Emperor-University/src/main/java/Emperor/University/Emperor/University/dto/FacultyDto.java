package Emperor.University.Emperor.University.dto;


import Emperor.University.Emperor.University.entity.Department;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class FacultyDto {

    private String facultyName;
    private String description;
    private List<Department> departments = new ArrayList<>();
}
