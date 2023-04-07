package hw5;

import hw5.dao.IStudentDao;
import hw5.model.Student;
import hw5.utils.SessionFactoryUtils;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor
public class StudentDaoImpl implements IStudentDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public StudentDaoImpl(final SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Student findById(final Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public List<Student> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Student> students = (List<Student>) session.createQuery("from Student").list();
            session.getTransaction().commit();
            return students;
        }
    }

    @Override
    public void persist(Student entity) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        }
    }
    @Override
    public void update(Student entity) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        }
    }

    public void delete(Student entity) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }
    }

    public void deleteAll() {
        List<Student> entityList = findAll();
        for (Student entity : entityList) {
            delete(entity);
        }
    }
}
