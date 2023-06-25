package Emperor.University.Emperor.University.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
//    @OneToMany(mappedBy = "department")
//    @OneToMany(targetEntity = Student.class, cascade = CascadeType.ALL)

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "department", referencedColumnName = "id")
    private List<Student> students = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "department", referencedColumnName = "id")
    private List<Lecturers> lecturers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
}
