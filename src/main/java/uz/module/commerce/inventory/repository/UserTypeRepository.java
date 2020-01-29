package uz.module.commerce.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.module.commerce.inventory.model.User;
import uz.module.commerce.inventory.model.UserType;

import java.util.List;
import java.util.Optional;

/**
 * Created by User on 22.01.2020.
 */
@Repository
public interface UserTypeRepository extends JpaRepository<UserType,Long> {

    Optional<UserType> findUserTypeById(Long id);

}
