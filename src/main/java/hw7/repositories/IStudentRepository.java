package hw7.repositories;

import hw7.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Serializable> {
    public List<Student> findByOrderByIdAsc();
}
