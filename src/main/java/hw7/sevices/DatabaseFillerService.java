package hw7.sevices;

import hw7.api.IDatabaseFillerService;
import hw7.model.Student;
import hw7.repositories.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DatabaseFillerService implements IDatabaseFillerService {

    private final IStudentRepository studentRepository;

    private final StudentGeneratorService studentGeneratorService;

    @Override
    public void fillDatabaseOnStartup() {
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            studentGeneratorService.initStudent(student);
            studentRepository.save(student);
        }
    }

}
