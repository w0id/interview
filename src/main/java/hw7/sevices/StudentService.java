package hw7.sevices;

import hw7.model.Student;
import hw7.repositories.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final IStudentRepository studentRepository;

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public Student addStudent(String name, Integer age) {
        Student student = new Student(name, age);
        studentRepository.save(student);
        return null;
    }

    public void delStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudent() {
        return studentRepository.findByOrderByIdAsc();
    }

    public void changeAge(final Long studentId, final Integer delta) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        student.setAge(student.getAge() + delta);
        studentRepository.save(student);
    }
}
