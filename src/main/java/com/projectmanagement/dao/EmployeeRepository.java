package com.projectmanagement.dao;

import com.projectmanagement.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {
    Optional<Employee> findById(Long eid);

    @Modifying
    @Query(value = "UPDATE EMPLOYEE_DETAILS SET GROUP_ID=?2 WHERE EMPLOYEE_ID=?1", nativeQuery = true)
    int updateGroupIdForEmployee(Long eid, Long gid);
}
