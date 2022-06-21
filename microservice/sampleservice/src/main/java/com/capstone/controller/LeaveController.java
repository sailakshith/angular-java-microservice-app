package com.capstone.controller;

import com.capstone.controller.dto.LeaveDto;
import com.capstone.controller.dto.LeaveResponseDto;
import com.capstone.service.ILeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sample")
public class LeaveController {

    @Autowired
    private ILeaveService leaveService;

    @GetMapping("/leave/fetch/{userRole}")
    public LeaveResponseDto fetchLeaves(@PathVariable String userRole){
       return leaveService.fetchLeaves(userRole);
    }

    @PostMapping("/leave/apply")
    public void applyLeave(@RequestBody LeaveDto dto) {
        leaveService.applyLeave(dto);
    }

    @PutMapping("/leave/edit")
    public void editLeave(@RequestBody LeaveDto dto) {
        leaveService.applyLeave(dto);
    }
}
