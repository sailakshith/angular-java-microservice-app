package com.capstone.service;

import com.capstone.controller.dto.response.EmployeeEditResponseDto;
import com.capstone.controller.dto.response.EmployeeResponseDto;
import com.capstone.controller.dto.request.LoginRequestDto;
import com.capstone.controller.dto.request.RegisterRequestDto;

import java.util.List;

public interface IEmployeeService {

    public EmployeeResponseDto getEmployees();

    public EmployeeEditResponseDto register(RegisterRequestDto dto);

    public EmployeeEditResponseDto login(LoginRequestDto dto);

    public EmployeeEditResponseDto logout(LoginRequestDto dto);

}
