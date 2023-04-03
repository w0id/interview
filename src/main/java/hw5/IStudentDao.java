package hw5;

import java.util.List;

public interface IStudentDao {
    Student findById(Long id);
    List<Student> findAll();
    void persist(Student entity);
    void update(Student entity);
    void delete(Student entity);
    void deleteAll();
}
