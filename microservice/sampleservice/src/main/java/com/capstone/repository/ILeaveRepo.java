package com.capstone.repository;

import com.capstone.model.EmployeeLeaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILeaveRepo extends JpaRepository<EmployeeLeaveEntity, Long> {
}
