package com.capstone.service;

import com.capstone.controller.dto.LeaveDto;
import com.capstone.controller.dto.LeaveResponseDto;
import com.capstone.model.EmployeeLeaveEntity;

import java.util.List;

public interface ILeaveService {

    public void applyLeave(LeaveDto dto);

    LeaveResponseDto fetchLeaves(String userRole);
}
