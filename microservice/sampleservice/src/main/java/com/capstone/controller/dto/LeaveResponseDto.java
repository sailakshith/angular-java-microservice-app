package com.capstone.controller.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LeaveResponseDto {
    private String messageId;
    private String messageType;
    private String timestamp;
    private String status;
    private List<LeaveDto> data = new ArrayList<>();
}
