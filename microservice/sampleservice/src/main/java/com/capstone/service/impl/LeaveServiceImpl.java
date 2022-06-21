package com.capstone.service.impl;

import com.capstone.controller.dto.LeaveDto;
import com.capstone.controller.dto.LeaveResponseDto;
import com.capstone.model.EmployeeLeaveEntity;
import com.capstone.repository.ILeaveRepo;
import com.capstone.service.ILeaveService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class LeaveServiceImpl implements ILeaveService {

    @Autowired
    private ILeaveRepo leaveRepo;

    @Override
    public void applyLeave(LeaveDto dto) {
        ModelMapper modelMapper = new ModelMapper();
        EmployeeLeaveEntity entity = modelMapper.map(dto,EmployeeLeaveEntity.class);
        leaveRepo.save(entity);
    }

    @Override
    public LeaveResponseDto fetchLeaves(String userRole) {

        List<EmployeeLeaveEntity> entities = leaveRepo.findAll();
        List<LeaveDto> leaves = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(EmployeeLeaveEntity entity:entities){
            LeaveDto dto = modelMapper.map(entity,LeaveDto.class);
            leaves.add(dto);
        }
        LeaveResponseDto responseDto = new LeaveResponseDto();
        responseDto.setTimestamp(getTimestamp());
        responseDto.setMessageId(UUID.randomUUID().toString());
        responseDto.setMessageType("FETCH_LEAVE_DATA");
        responseDto.setData(leaves);
        responseDto.setStatus("SUCCESS");
        return responseDto;
    }

    private String getTimestamp() {
        return new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date());
    }


}
