package uz.module.commerce.inventory.service;

import uz.module.commerce.inventory.model.dto.UserTypeDto;

import java.util.List;

public interface UserTypeService {

    void createOrUpdateUserType(UserTypeDto userType) throws Exception;

    void deleteUserTypeById(Long id) throws Exception;

    List<UserTypeDto>  findAllUserTypes() throws Exception;

    UserTypeDto findUserTypeById(Long id) throws Exception;
}
