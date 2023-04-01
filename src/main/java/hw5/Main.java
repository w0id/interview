package hw5;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            IStudentDao userDao = new StudentDaoImpl(sessionFactoryUtils);

            Random random = new Random();

            for (int i = 0; i < 1000; i++) {
                userDao.persist(new Student("Student" + i, random.nextLong(2,5)));
            }

            System.out.println("Добавили 1000 студнтов\n" + userDao.findAll().toString() + "\n");
            Student student = userDao.findById(2L);
            student.setMark(1L);
            userDao.update(student);
            System.out.println("Меняем значение mark для студента с id = 2" + userDao.findById(2L).toString() + "\n");
            userDao.delete(student);
            System.out.println("Удаляем студента с id = 2\n" + userDao.findAll().toString() + "\n");
            userDao.deleteAll();
            System.out.println("Удаляем все записи в таблице student\n" + userDao.findAll().toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
