package com.leavemanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.leavemanagement.model.Employee;

@Repository
public interface LoginRepository extends JpaRepository<Employee, Integer>{

	Optional<Employee> findByEmail(String userEmail);

}
