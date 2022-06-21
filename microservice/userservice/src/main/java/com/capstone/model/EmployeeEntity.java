package com.capstone.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_seq")
    @SequenceGenerator(name = "employee_id_seq", sequenceName = "EMPL_ID_SEQ", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private long employeeId;

    private String username;
    private String password;
    private Role role;
    private String employeeName;
    private String managerId;

    @OneToMany(mappedBy = "employees")
    private List<ProjectEntity> projects;
}

