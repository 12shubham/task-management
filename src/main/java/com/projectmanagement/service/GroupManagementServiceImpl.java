package com.projectmanagement.service;

import com.projectmanagement.dao.GroupRepository;
import com.projectmanagement.entities.Employee;
import com.projectmanagement.entities.Group;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupManagementServiceImpl implements IGroupManagementService{
    private final GroupRepository groupRepository;
    @Override
    public Group createGroup(Group group) {
        Group grp = groupRepository.save(group);
        return grp;
    }

    @Override
    public Group getGroupDetails(Long gId) {
        Group grp = groupRepository.getById(gId);
        return grp;
    }

    @Override
    public List<Group> getAllGroups() {
        List<Group> allGroups = groupRepository.findAll();
        return allGroups;
    }

    @Override
    public List<Employee> addMultipleEmployeesToTheGroup(List<Employee> list, Long gid) {
        Group grp = groupRepository.getById(gid);
        for(Employee e : list){
            e.setEmpGroup(grp);
        }
        List<Employee> currentEmployees = grp.getAllEmployeesInGroup();
        currentEmployees.addAll(list);
        Group newGroup = groupRepository.save(grp);
        return list;
    }

    @Override
    public List<Employee> getAllEmployeesInAGroup(Long gId) {
        Group grp = groupRepository.getById(gId);
        List<Employee> currentEmployees = grp.getAllEmployeesInGroup();
        return  currentEmployees;
    }
}
