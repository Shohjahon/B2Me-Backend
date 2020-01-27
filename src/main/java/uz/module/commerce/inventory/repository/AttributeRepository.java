package uz.module.commerce.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.module.commerce.inventory.model.Attribute;

import java.util.List;

/**
 * Created by User on 22.01.2020.
 */
@Repository
public interface AttributeRepository extends JpaRepository<Attribute,Long>{

    @Query(value = "select * from attributes where is_active = true", nativeQuery = true)
    List<Attribute> findActiveAttributes();
}
