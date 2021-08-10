package com.projectmanagement.service;

import com.projectmanagement.entities.Employee;
import com.projectmanagement.entities.Group;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IGroupManagementService {
    Group createGroup(Group group);
    Group getGroupDetails(Long gId);
    List<Group> getAllGroups();
    List<Employee> addMultipleEmployeesToTheGroup(List<Employee> list, Long gid);
    List<Employee> getAllEmployeesInAGroup(Long gId);
}
