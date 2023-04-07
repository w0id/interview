package hw7.api;

import hw7.model.Student;

import java.util.List;

public interface IStudentService {
    Student getStudent(Long id);
    Student addStudent(String name, Integer age);
    void delStudent(Long id);
    List<Student> getStudent();
    void changeAge(final Long studentId, final Integer delta);
}
