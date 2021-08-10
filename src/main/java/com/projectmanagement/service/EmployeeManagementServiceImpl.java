package com.projectmanagement.service;

import com.projectmanagement.dao.EmployeeRepository;
import com.projectmanagement.entities.Employee;
import com.projectmanagement.entities.Group;
import com.projectmanagement.entities.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeManagementServiceImpl implements IEmployeeManagementService{

    private final EmployeeRepository employeeRepository;
    @Override
    public Task assignTaskToEmployee(Task t, Long eid) {

        Employee employee = employeeRepository.getById(eid);
        employee.setUniqueTask(t);
        Employee emp = employeeRepository.save(employee);
        return emp.getUniqueTask();
    }

    @Override
    public Employee createEmployee(Employee e) {
        Employee employee = employeeRepository.save(e);
        return employee;
    }

    @Override
    public Task getTaskForEmployee(Long eid) {
       Optional<Employee> employee = employeeRepository.findById(eid);
       if(employee.isPresent() && employee.get().getUniqueTask() != null) return employee.get().getUniqueTask();
       throw new RuntimeException("Employee does not exists or Task Not Created For Employee");
    }

    @Override
    public Employee getEmployee(Long eid) {
        Optional<Employee> employee = employeeRepository.findById(eid);
        return employee.orElseThrow(() -> new RuntimeException("Employee Does Not Exists"));
    }

    @Override
    public Group getGroup(Long eid) {
        Optional<Employee> employee = employeeRepository.findById(eid);
        if(employee.isPresent() && employee.get().getEmpGroup() != null) return employee.get().getEmpGroup();
        throw new RuntimeException("Employee does not exists or not a part of Group");
    }
    @Override
    @Transactional
    public Employee addEmployeeToTheGroup(Long eid, Long gid) {
        int isAdded = employeeRepository.updateGroupIdForEmployee(eid, gid);
        if(isAdded==1) return getEmployee(eid);
        throw new RuntimeException("Could not update employee");
    }

    @Override
    public List<Employee> createMultipleEmployees(List<Employee> list) {
        List<Employee> employees = employeeRepository.saveAll(list);
        return employees;
    }
}
