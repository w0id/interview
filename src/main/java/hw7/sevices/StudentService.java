package hw7.sevices;

import hw7.api.IStudentService;
import hw7.model.Student;
import hw7.repositories.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final IStudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public Student addStudent(String name, Integer age) {
        Student student = new Student(name, age);
        studentRepository.save(student);
        return null;
    }

    @Override
    public void delStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudent() {
        return studentRepository.findByOrderByIdAsc();
    }

    @Override
    public void changeAge(final Long studentId, final Integer delta) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        student.setAge(student.getAge() + delta);
        studentRepository.save(student);
    }
}
