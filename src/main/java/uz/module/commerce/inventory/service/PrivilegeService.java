package uz.module.commerce.inventory.service;

import uz.module.commerce.inventory.model.dto.PrivilegeDto;

import java.util.List;

public interface PrivilegeService {

    void createOrUpdatePrivilege(PrivilegeDto privilege) throws Exception;

    void deletePrivilegeById(Long id) throws Exception;

    List<PrivilegeDto> findAllPrivileges() throws Exception;

    List<PrivilegeDto> findPrivilegesByUserTypeId(Long userTypeId) throws Exception;
}
