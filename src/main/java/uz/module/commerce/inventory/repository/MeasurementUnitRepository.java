package uz.module.commerce.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.module.commerce.inventory.model.MeasurementUnit;

/**
 * Created by User on 24.01.2020.
 */
@Repository
public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnit,Long>{
}
