package com.leavemanagement.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.leavemanagement.dto.MyLeavesDto;
import com.leavemanagement.exception.LeaveException;
import com.leavemanagement.model.Employee;
import com.leavemanagement.model.Leaves;
import com.leavemanagement.repository.EmployeeRepository;
import com.leavemanagement.repository.LeaveRepository;
import com.leavemanagement.util.LeaveUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LeaveServiceImpl implements LeaveService {

	
	/**
	 * @author Sharath
	 * Leave Service for rh and ch
	 */

	
	@Autowired
	LeaveRepository leaveRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public MyLeavesDto getMyLeaves(int employeeId) {
		log.info("service for getting or showing rh and ch leaves");
		
		MyLeavesDto myLeaves = new MyLeavesDto();
		
		Optional<Employee> employeeDetails = employeeRepository.findById(employeeId);
		Optional<Leaves> leaveDetails = leaveRepository.findByemployeeId(employeeId);
				
		if(employeeDetails.isPresent() && leaveDetails.isPresent())
		{
			myLeaves.setName(employeeDetails.get().getName());
			BeanUtils.copyProperties(leaveDetails.get(), myLeaves);
			myLeaves.setMessage(LeaveUtil.AVAILABLE_LEAVES);
			myLeaves.setStatusCode(HttpStatus.FOUND.value());			
			return myLeaves;
		}else
		{
			throw new LeaveException(LeaveUtil.NO_AVAILABLE_LEAVES);
		}
	}

}
