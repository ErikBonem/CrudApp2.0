package web.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.DAO.UserDAO;
import web.Model.User;

import java.util.List;
@Component
@Service
public class UserService {
    private UserDAO userDAO;

    public List<User> index() {
        return userDAO.index();
    }

    public User show(int id){
        return userDAO.show(id);
    }

    public void save(User user){

        userDAO.save(user);
    }

    public void update (User user){
        userDAO.update(user);
    }

    public void delete(int id){
        userDAO.delete(id);
    }
}
