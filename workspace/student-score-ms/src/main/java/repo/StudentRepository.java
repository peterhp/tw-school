package repo;

import model.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Shli on 10/08/2017.
 */
public interface StudentRepository extends CrudRepository<Student, String> {

}
