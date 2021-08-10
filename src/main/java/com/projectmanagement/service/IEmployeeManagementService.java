package com.projectmanagement.service;

import com.projectmanagement.entities.Employee;
import com.projectmanagement.entities.Group;
import com.projectmanagement.entities.Task;

import java.util.List;

public interface IEmployeeManagementService {
    Task assignTaskToEmployee(Task t, Long eid);
    Employee createEmployee(Employee e);
    Task getTaskForEmployee(Long eid);
    Employee getEmployee(Long eid);
    Group getGroup(Long eid);
    List<Employee> createMultipleEmployees(List<Employee> list);
    Employee addEmployeeToTheGroup(Long eid, Long gid);
}
