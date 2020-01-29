package uz.module.commerce.inventory.model.dto;

import java.util.Set;

public class UserTypeDto {
    private Long id;
    private String userType;
    private String description;
    private Set<PrivilegeDto> privileges;

    public UserTypeDto(Long id, String userType, String description, Set<PrivilegeDto> privileges) {
        this.id = id;
        this.userType = userType;
        this.description = description;
        this.privileges = privileges;
    }

    public UserTypeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<PrivilegeDto> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<PrivilegeDto> privileges) {
        this.privileges = privileges;
    }

    @Override
    public String toString() {
        return "UserTypeDto{" +
                "id=" + id +
                ", userType='" + userType + '\'' +
                ", description='" + description + '\'' +
                ", privileges=" + privileges +
                '}';
    }
}
