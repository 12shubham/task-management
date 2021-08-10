package com.projectmanagement.controller;

import com.projectmanagement.entities.Employee;
import com.projectmanagement.entities.Group;
import com.projectmanagement.service.IGroupManagementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@AllArgsConstructor
public class GroupManagementController {
    private final IGroupManagementService groupManagementService;

    @PostMapping("createGroup")
    public Group createGroup(@RequestBody Group group){
        return groupManagementService.createGroup(group);
    }

    @GetMapping("getGroupDetails/{id}")
    public Group getGroupDetails(@PathVariable("id") Long id){
        return groupManagementService.getGroupDetails(id);
    }
    @GetMapping("getAllGroups")
    public List<Group> getAllGroups(){
        return  groupManagementService.getAllGroups();
    }

    @PostMapping("addMultiple/{gid}")
    public List<Employee> addMultipleEmployeesToTheGroup(@RequestBody List<Employee> list, @PathVariable("gid") Long gid){
        return groupManagementService.addMultipleEmployeesToTheGroup(list,gid);
    }
    @GetMapping("getAllEmployeesInGroup")
    public List<Employee> getAllEmployeesInAGroup(@RequestParam("gId") Long gId){
        return groupManagementService.getAllEmployeesInAGroup(gId);
    }
}
