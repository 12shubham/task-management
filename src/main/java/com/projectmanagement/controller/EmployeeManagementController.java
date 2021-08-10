package com.projectmanagement.controller;

import com.projectmanagement.entities.Employee;
import com.projectmanagement.entities.Group;
import com.projectmanagement.entities.Task;
import com.projectmanagement.service.IEmployeeManagementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeManagementController {
    private final IEmployeeManagementService employeeManagementService;

    @PostMapping("assignTaskToEmployee/{eid}")
    public Task assignTaskToEmployee(@RequestBody Task t, @PathVariable("eid") Long eid){
        return employeeManagementService.assignTaskToEmployee(t,eid);
    }

    @PostMapping("createEmployee")
    public Employee createEmployee(@RequestBody Employee e){
        return employeeManagementService.createEmployee(e);
    }

    @GetMapping("getTaskForEmployee/{eid}")
    public Task getTaskForEmployee(@PathVariable("eid") Long eid){
        return employeeManagementService.getTaskForEmployee(eid);
    }

    @GetMapping("getEmployee")
    public Employee getEmployee(@RequestParam("eid") Long eid){
        return employeeManagementService.getEmployee(eid);
    }

    @GetMapping("getGroup/{eid}")
    public Group getGroup(@PathVariable("eid") Long eid){
        return employeeManagementService.getGroup(eid);
    }

    @PostMapping("createMultipleEmployees")
    public List<Employee> createMultipleEmployees(@RequestBody List<Employee> list){
        return employeeManagementService.createMultipleEmployees(list);
    }

    @PostMapping("addEmployeeToGroup/{eid}/{gid}")
    public Employee addEmployeeToTheGroup(@PathVariable("eid") Long eid, @PathVariable("gid") Long gid){
        return employeeManagementService.addEmployeeToTheGroup(eid,gid);
    }
}
