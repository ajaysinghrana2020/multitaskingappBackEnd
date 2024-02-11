package Repo;

//import Controller.UserController;

import Pom.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Integer> {
    Users findByemail(String email);
}
