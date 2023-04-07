package hw7.controllers;

import hw7.model.Student;
import hw7.sevices.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudent();
    }

    @PostMapping
    public Student addStudent(@RequestParam String name, @RequestParam Integer age) {
        return studentService.addStudent(name, age);
    }

    @GetMapping("/delete/{id}")
    public void delStudent(@PathVariable Long id) {
        studentService.delStudent(id);
    }

    @PostMapping("/change_age")
    public void changeAge(@RequestParam Long studentId, @RequestParam Integer delta) {
        studentService.changeAge(studentId, delta);
    }
}
