package uz.module.commerce.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.module.commerce.inventory.model.Product;

import java.util.List;

/**
 * Created by User on 24.01.2020.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findProductsByProductTypeId(Long productTypeId);

}
