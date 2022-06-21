package com.capstone.controller;

import com.capstone.controller.dto.response.EmployeeEditResponseDto;
import com.capstone.controller.dto.response.EmployeeResponseDto;
import com.capstone.controller.dto.request.LoginRequestDto;
import com.capstone.controller.dto.request.RegisterRequestDto;
import com.capstone.service.IEmployeeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
@Data
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/fetch")
    public EmployeeResponseDto getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/register")
    public EmployeeEditResponseDto register(@RequestBody RegisterRequestDto dto) {
        return employeeService.register(dto);
    }

    @PostMapping("/login")
    public EmployeeEditResponseDto login(@RequestBody LoginRequestDto dto) {
        System.out.println(dto.toString());
        return employeeService.login(dto);
    }

    @PostMapping("/logout")
    public EmployeeEditResponseDto logout(@RequestBody LoginRequestDto dto) {
        return employeeService.logout(dto);
    }
}


