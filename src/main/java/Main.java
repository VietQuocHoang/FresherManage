import com.group.FresherManagement.dao.UserDAO;
import com.group.FresherManagement.entities.User;

public class Main {

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO(User.class);
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        userDAO.insert(user);
        return;
    }
}
