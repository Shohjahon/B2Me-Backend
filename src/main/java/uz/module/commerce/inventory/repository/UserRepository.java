package uz.module.commerce.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.module.commerce.inventory.model.User;

import java.util.Optional;

/**
 * Created by User on 22.01.2020.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByUsernameOrPhoneNumber(String username, String phoneNumber);


}
