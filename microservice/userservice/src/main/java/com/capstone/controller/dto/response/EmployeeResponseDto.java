package com.capstone.controller.dto.response;

import com.capstone.model.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeResponseDto {
    private String messageId;
    private String messageType;
    private String timestamp;
    private String status;
    private List<EmployeeDto> data = new ArrayList<>();
}
