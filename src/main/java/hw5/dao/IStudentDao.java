package hw5.dao;

import hw5.model.Student;

import java.util.List;

public interface IStudentDao {
    Student findById(Long id);
    List<Student> findAll();
    void persist(Student entity);
    void update(Student entity);
    void delete(Student entity);
    void deleteAll();
}
