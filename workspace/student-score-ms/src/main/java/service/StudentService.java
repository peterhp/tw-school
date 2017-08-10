package service;

import exception.UnexistedStudentException;
import model.Courses;
import dc.StudentMemoryStorage;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shli on 09/08/2017.
 */
@Service
public class StudentService implements IStudentService {
    private StudentMemoryStorage studentStorage = new StudentMemoryStorage();

    private ISidGeneratorService sidGenerator;

    @Autowired
    public void setSidGenerator(ISidGeneratorService sidGenerator) {
        this.sidGenerator = sidGenerator;
    }

    public boolean addStudent(Student student) {
        student.setSid(sidGenerator.getAvailableSid());
        return studentStorage.addStudent(student);
    }

    @Override
    public List<Student> findStudents(List<String> ids) {
        return studentStorage.getStudents(ids);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentStorage.getAllStudents();
    }

    @Override
    public Courses getStudentScores(String sid) throws UnexistedStudentException {
        if (!studentStorage.contains(sid)) {
            throw new UnexistedStudentException();
        }

        return studentStorage.getStudent(sid).getCourses();
    }

    @Override
    public void updateStudentScores(String sid, Courses courses) throws UnexistedStudentException {
        if (!studentStorage.contains(sid)) {
            throw new UnexistedStudentException();
        }

        studentStorage.updateStudentCourses(sid, courses);
    }
}
