package uz.module.commerce.inventory.model.dto;

import java.util.Set;

public class PrivilegeDto {
    private Long id;
    private String method;
    private String methodCode;
    private String description;

    public PrivilegeDto(Long id, String method, String methodCode, String description) {
        this.id = id;
        this.method = method;
        this.methodCode = methodCode;
        this.description = description;
    }

    public PrivilegeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethodCode() {
        return methodCode;
    }

    public void setMethodCode(String methodCode) {
        this.methodCode = methodCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PrivilegeDto{" +
                "id=" + id +
                ", method='" + method + '\'' +
                ", methodCode='" + methodCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
