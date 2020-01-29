package uz.module.commerce.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.module.commerce.inventory.model.Privilege;
import uz.module.commerce.inventory.model.UserType;

import java.util.List;

/**
 * Created by User on 22.01.2020.
 */
@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long>{

    List<Privilege> findPrivilegesByUserTypesIn(List<UserType> userTypes);

}
