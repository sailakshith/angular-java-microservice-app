package com.capstone.controller.dto.request;

import com.capstone.model.Role;
import lombok.Data;

@Data
public class RegisterRequestDto {
    private String username;
    private String password;
    private Role role;
    private String employeeName;
}
