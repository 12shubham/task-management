package com.projectmanagement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMPLOYEE_DETAILS")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private long empId;
    @Column(name = "EMPLOYEE_NAME")
    private String empName;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "GROUP_ID")
    private Group empGroup;

    @JoinColumn(name = "TASK_ID")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne
    private Task uniqueTask;
}
