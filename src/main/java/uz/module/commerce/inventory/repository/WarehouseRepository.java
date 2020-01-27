package uz.module.commerce.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.module.commerce.inventory.model.Warehouse;

import java.util.List;
import java.util.Optional;

/**
 * Created by User on 24.01.2020.
 */
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse,Long>{

    Optional<Warehouse> findWarehouseByBarcode(String barcode);

    List<Warehouse> findWarehousesByProductId(Long productId);
}
