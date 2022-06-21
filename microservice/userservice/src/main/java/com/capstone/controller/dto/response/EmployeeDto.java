package com.capstone.controller.dto.response;

import com.capstone.model.Role;
import lombok.Data;

@Data
public class EmployeeDto {
    private long employeeId;
    private String username;
    private Role role;
    private String employeeName;
    private String managerId;
}
