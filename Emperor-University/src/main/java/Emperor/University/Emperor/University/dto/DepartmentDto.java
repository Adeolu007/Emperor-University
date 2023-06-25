package Emperor.University.Emperor.University.dto;

import Emperor.University.Emperor.University.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class DepartmentDto {

    private String name;
    private String description;
    private Long facultyId;
    private List<Student> students = new ArrayList<>();

}
