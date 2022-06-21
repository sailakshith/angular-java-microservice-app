package com.capstone.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
@Data
public class ProjectEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    @SequenceGenerator(name = "project_seq", sequenceName = "PROJECT_SEQ", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private long id;
    private String name;
    private long managerId;

    @ManyToOne
    @JoinTable(name = "employee_project",
            joinColumns = @JoinColumn(
                    name = "project_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "employee_id",
                    referencedColumnName = "employeeId"
            ))
    EmployeeEntity employees;

}
