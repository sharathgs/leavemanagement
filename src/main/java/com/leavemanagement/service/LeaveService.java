package com.leavemanagement.service;

import org.springframework.stereotype.Service;

import com.leavemanagement.dto.MyLeavesDto;

@Service
public interface LeaveService {

	public MyLeavesDto getMyLeaves(int employeeId);
	
}
