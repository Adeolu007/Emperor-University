package Emperor.University.Emperor.University.repository;

import Emperor.University.Emperor.University.entity.Department;
import Emperor.University.Emperor.University.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
    @Query("select d from Department d where d.id = ?1")
    List<Department> findDepartmentByFaculty(Long id);

    @Query("select d from Department d where d.faculty.id = ?1")
    List<Department> findByFacultyId(Long id);

    @Query("select d from Department d where d.faculty.id = ?1")
    List<Department> testingFindBy(Long id);




}
