package com.capstone.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employee_leave")
@Data
public class EmployeeLeaveEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_leave_seq")
    @SequenceGenerator(name = "employee_leave_seq", sequenceName = "EMPL_LEAVE_SEQ", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private long id;
    private int leaves;
    private String employeeId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String reason;
    private LeaveStatus status;
    private String comments;
}
