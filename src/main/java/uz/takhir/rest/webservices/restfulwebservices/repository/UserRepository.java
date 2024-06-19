package uz.takhir.rest.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.takhir.rest.webservices.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
