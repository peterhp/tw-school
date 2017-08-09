package service;

import model.Klass;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shli on 09/08/2017.
 */
@Service
public class StudentService implements IStudentService {
    private Klass klass = new Klass();

    private ISidGeneratorService sidGenerator;

    @Autowired
    public void setSidGenerator(ISidGeneratorService sidGenerator) {
        this.sidGenerator = sidGenerator;
    }

    public boolean addStudent(Student student) {
        student.setSid(sidGenerator.getAvailableSid());
        return klass.addStudent(student);
    }

    @Override
    public List<Student> findStudents(List<String> ids) {
        return klass.getStudents(ids);
    }

    @Override
    public List<Student> getAllStudents() {
        return klass.getAllStudents();
    }
}
