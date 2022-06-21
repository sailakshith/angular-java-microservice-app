package com.capstone.repository;

import com.capstone.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity findByUsername(String username);
}
