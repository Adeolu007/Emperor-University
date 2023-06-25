package Emperor.University.Emperor.University.repository;

import Emperor.University.Emperor.University.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Long> {
    @Query("select s from Student s where s.department.id = ?1")
    List<Student> findStudentByDepartment(Long id);

    @Query("select s from Student s where s.department.id = ?1")
    List<Student> fetchStudentsInADepartment(Long id);



}
