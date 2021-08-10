package com.projectmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TASK_DETAILS")
public class Task {
    @Id @GeneratedValue
    @Column(name = "TASK_ID")
    private long taskId;
    @Column(name = "TASK_DESCRIPTION")
    private String taskDescription;

    @OneToOne(mappedBy = "uniqueTask")
    private Employee employee;
}
