package hw7.sevices;

import hw7.model.Student;
import hw7.repositories.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DatabaseFillerService {

    private final IStudentRepository studentRepository;

    private final StudentGeneratorService studentGeneratorService;

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabaseOnStartup() {
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            studentGeneratorService.InitStudent(student);
            studentRepository.save(student);
        }
    }

}
