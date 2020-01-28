package uz.module.commerce.inventory.service;

import uz.module.commerce.inventory.model.Privilege;
import uz.module.commerce.inventory.model.dto.PrivilegeDto;

import java.util.List;

public interface PrivilegeService {

    void createOrUpdatePrivilege(PrivilegeDto privilege) throws Exception;

    void deletePrivilegeById(Long id) throws Exception;

    List<Privilege> findAllPrivileges() throws Exception;

    List<Privilege> findPrivilegesByUserTypeId(Long userTypeId) throws Exception;
}
