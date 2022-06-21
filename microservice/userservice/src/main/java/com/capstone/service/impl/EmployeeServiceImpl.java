package com.capstone.service.impl;

import com.capstone.controller.dto.response.EmployeeDto;
import com.capstone.controller.dto.response.EmployeeEditResponseDto;
import com.capstone.controller.dto.response.EmployeeResponseDto;
import com.capstone.controller.dto.request.LoginRequestDto;
import com.capstone.controller.dto.request.RegisterRequestDto;
import com.capstone.model.EmployeeEntity;
import com.capstone.repository.IEmployeeRepo;
import com.capstone.service.IEmployeeService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Data
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepo employeeRepo;

    @Override
    public EmployeeResponseDto getEmployees() {
        List<EmployeeEntity> entities = employeeRepo.findAll();
        List<EmployeeDto> employeeResponseDtos = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        for (EmployeeEntity entity : entities) {
            EmployeeDto empDto = mapper.map(entity, EmployeeDto.class);
            employeeResponseDtos.add(empDto);
        }
        EmployeeResponseDto responseDto = new EmployeeResponseDto();
        responseDto.setTimestamp(getTimestamp());
        responseDto.setMessageId(UUID.randomUUID().toString());
        responseDto.setMessageType("FETCH_EMPLOYEE_DATA");
        responseDto.setData(employeeResponseDtos);
        responseDto.setStatus("SUCCESS");
        return responseDto;
    }

    private String getTimestamp() {
        return new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date());
    }

    @Override
    public EmployeeEditResponseDto register(RegisterRequestDto dto) {
        ModelMapper mapper = new ModelMapper();
        EmployeeEntity entity = mapper.map(dto, EmployeeEntity.class);
        employeeRepo.save(entity);
        EmployeeEditResponseDto responseDto = new EmployeeEditResponseDto();
        responseDto.setTimestamp(getTimestamp());
        responseDto.setMessageId(UUID.randomUUID().toString());
        responseDto.setMessageType("REGISTER_EMPLOYEE");
        responseDto.setStatus("SUCCESS");
        return responseDto;
    }

    @Override
    public EmployeeEditResponseDto login(LoginRequestDto dto) {
        EmployeeEditResponseDto responseDto = new EmployeeEditResponseDto();
        responseDto.setTimestamp(getTimestamp());
        responseDto.setMessageId(UUID.randomUUID().toString());
        responseDto.setMessageType("EMPLOYEE_LOGIN");
        EmployeeEntity employeeEntity = employeeRepo.findByUsername(dto.getUsername());
        if (employeeEntity.getUsername().equalsIgnoreCase(dto.getUsername())
                && employeeEntity.getPassword().equalsIgnoreCase(dto.getPassword())) {
            responseDto.setStatus("SUCCESS");
            return responseDto;
        }
        responseDto.setStatus("INVALID_LOGIN");
        return responseDto;
    }

    @Override
    public EmployeeEditResponseDto logout(LoginRequestDto dto) {
        EmployeeEditResponseDto responseDto = new EmployeeEditResponseDto();
        responseDto.setTimestamp(getTimestamp());
        responseDto.setMessageId(UUID.randomUUID().toString());
        responseDto.setMessageType("EMPLOYEE_LOGOUT");
        responseDto.setStatus("SUCCESS");
        return responseDto;
    }
}
