package pl.marcelbaumgardt.naukaspringbootjpa.dao;


import org.springframework.stereotype.Repository;
import pl.marcelbaumgardt.naukaspringbootjpa.model.UserProfile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserProfileDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(UserProfile userProfile){
        entityManager.persist(userProfile);
    }

    public UserProfile get(Long id){
        return entityManager.find(UserProfile.class, id);
    }

    public void update(UserProfile userProfile){
        entityManager.merge(userProfile);
    }

    public void remove(UserProfile userProfile){
        entityManager.remove(userProfile);
    }



}
