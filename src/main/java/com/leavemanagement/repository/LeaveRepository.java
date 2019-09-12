package com.leavemanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leavemanagement.model.Leaves;

@Repository
public interface LeaveRepository extends JpaRepository<Leaves, Integer> {

	public Optional<Leaves> findByemployeeId(int employeeId);
	
}
