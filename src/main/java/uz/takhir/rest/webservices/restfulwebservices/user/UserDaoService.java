package uz.takhir.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"Tohir", LocalDate.now().minusYears(30)));
        users.add(new User(2,"Bahodir", LocalDate.now().minusYears(25)));
        users.add(new User(3,"Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }



}
