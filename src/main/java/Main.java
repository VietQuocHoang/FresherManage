import com.group.FresherManagement.dao.CourseDAO;
import com.group.FresherManagement.entities.Courses;

public class Main {

    public static void main(String[] args) {
        CourseDAO courseDAO = new CourseDAO(Courses.class);
        courseDAO.findAll();
        return;
    }
}
