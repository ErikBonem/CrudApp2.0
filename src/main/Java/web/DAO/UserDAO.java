package web.DAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Repository
@Component
public class UserDAO {
    @PersistenceContext
    private EntityManager em;

    public List<User> index() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    public User show(int id){
        return em.find(User.class,id);
    }
    @Transactional
    public void save(User user){

        em.persist(user);
    }
    @Transactional
    public void update (User user){
        em.merge(user);
    }
    @Transactional
    public void delete(int id){
        em.remove(show(id));
    }
}
