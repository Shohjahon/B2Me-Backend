package uz.module.commerce.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.module.commerce.inventory.model.ActionList;

import java.util.List;

/**
 * Created by User on 22.01.2020.
 */
@Repository
public interface ActionListRepository extends JpaRepository<ActionList,Long>{

    List<ActionList> findActionListByUserId(Long userId);
}
