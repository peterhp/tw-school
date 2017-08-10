package repo;

import model.Courses;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Shli on 10/08/2017.
 */
public interface CoursesRepository extends CrudRepository<Courses, String> {

}
