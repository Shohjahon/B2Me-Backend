package uz.module.commerce.inventory.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import uz.awesome.java.validation.StringValidation;
import uz.module.commerce.inventory.exception.CustomException;
import uz.module.commerce.inventory.model.Privilege;
import uz.module.commerce.inventory.model.UserType;
import uz.module.commerce.inventory.model.dto.PrivilegeDto;
import uz.module.commerce.inventory.repository.PrivilegeRepository;
import uz.module.commerce.inventory.repository.UserTypeRepository;
import uz.module.commerce.inventory.service.PrivilegeService;

import java.util.Collections;
import java.util.List;

@Service
public class PrivilegeServiceImpl implements PrivilegeService{
    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Autowired
    private UserTypeRepository userTypeRepository;
    @Autowired
    private Environment env;
    @Autowired
    private ModelMapper modelMapper;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void createOrUpdatePrivilege(PrivilegeDto dto) throws Exception {
        logger.info("CreateOrUpdatePrivilege -> dto: {}", dto);

        if (StringValidation.isEmptyOrNull(dto.getMethod()) ||
                StringValidation.isEmptyOrNull(dto.getMethodCode())){

            throw new CustomException(env.getProperty("code_1000", Integer.class),
                    env.getProperty("message_1000"));

        }

        Privilege privilege = modelMapper.map(dto, Privilege.class);

        logger.info("CreateOrUpdatePrivilege -> privilege: {}", privilege);

        privilegeRepository.save(privilege);

    }

    @Override
    public void deletePrivilegeById(Long id) throws Exception {
        logger.info("deletePrivilegeById -> id: {}", id);

        privilegeRepository.deleteById(id);
    }

    @Override
    public List<Privilege> findAllPrivileges() throws Exception {
        logger.info("findAllPrivileges -> start");

        return privilegeRepository.findAll();
    }

    @Override
    public List<Privilege> findPrivilegesByUserTypeId(Long userTypeId) throws Exception {
        logger.info("findAllPrivileges -> findPrivilegesByUserTypeId -> userTypeId: {}", userTypeId);

        UserType userType = userTypeRepository.findUserTypeById(userTypeId).
                orElseThrow(() -> new CustomException(env.getProperty("code_1001", Integer.class),
                        env.getProperty("message_1001")));

        return privilegeRepository.findPrivilegesByUserTypesIn(Collections.singletonList(userType));
    }
}
