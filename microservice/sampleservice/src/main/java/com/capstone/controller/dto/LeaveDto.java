package com.capstone.controller.dto;

import com.capstone.model.LeaveStatus;
import lombok.Data;

import java.time.LocalDate;
@Data
public class LeaveDto {
    private String employeeId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String reason;
    private LeaveStatus status;
    private String comments;
}
