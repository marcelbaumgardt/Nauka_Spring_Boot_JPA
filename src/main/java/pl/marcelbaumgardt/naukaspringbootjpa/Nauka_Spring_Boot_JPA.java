package pl.marcelbaumgardt.naukaspringbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.marcelbaumgardt.naukaspringbootjpa.dao.UserDao;
import pl.marcelbaumgardt.naukaspringbootjpa.model.User;
import pl.marcelbaumgardt.naukaspringbootjpa.model.UserProfile;

@SpringBootApplication
public class Nauka_Spring_Boot_JPA {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Nauka_Spring_Boot_JPA.class, args);
        UserDao userDao = context.getBean(UserDao.class);
        User user = new User();
        user.setAge(10);
        user.setSecondName("Baumgradt");
        user.setFirstName("Marcel");

        UserProfile userProfile = new UserProfile("cosmo123","marcedit1994@gmail.com");
        user.setUserProfile(userProfile);
        userDao.save(user);

        User user1 = new User("paweł", "wroński", 24);
        UserProfile userProfile1 = new UserProfile("wronski123","wronski1994@gmail.com");
        user1.setUserProfile(userProfile1);


        userDao.get(1L);

        System.out.println(userDao.get(1L));

        context.close();
    }
}
