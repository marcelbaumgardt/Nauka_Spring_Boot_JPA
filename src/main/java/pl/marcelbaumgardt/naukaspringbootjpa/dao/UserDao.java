package pl.marcelbaumgardt.naukaspringbootjpa.dao;

import org.springframework.stereotype.Repository;
import pl.marcelbaumgardt.naukaspringbootjpa.model.User;
import pl.marcelbaumgardt.naukaspringbootjpa.model.UserProfile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
@Transactional
public class UserDao {

    @PersistenceContext // @Autowired
    EntityManager entityManager;

    public User get(Long id){
        return entityManager.find(User.class, id);
    }

    public void save(User user){
        UserProfile userProfile=user.getUserProfile();
        if (userProfile!=null) {

            entityManager.persist(userProfile);
        }
        entityManager.persist(user);
    }

    public void update(User user){
        UserProfile userProfileFromDao = user.getUserProfile();
        if (userProfileFromDao!=null) {
            entityManager.merge(userProfileFromDao);
            user.setUserProfile(userProfileFromDao);
        }
        entityManager.merge(user);
    }

    public void delete(User user){
        User userToDelete=entityManager.merge(user);
        entityManager.remove(userToDelete.getUserProfile());
        entityManager.remove(userToDelete);
    }
    //DELETE

    //UserProfileDao -> GET, SAVE ->test wiązania dwukierunkowego
}
