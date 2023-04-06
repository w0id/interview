package hw7.sevices;

import hw7.model.Student;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StudentGeneratorService {
    public void InitStudent(Student student) {
        Random random = new Random();
        student.setName("Student" + random.nextInt(99));
        student.setAge(random.nextInt(18, 23));
    }
}
