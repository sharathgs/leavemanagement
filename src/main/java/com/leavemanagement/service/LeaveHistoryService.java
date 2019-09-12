package com.leavemanagement.service;

import java.util.List;

import com.leavemanagement.dto.LeaveHistoryResponseDTO;

public interface LeaveHistoryService {

	List<LeaveHistoryResponseDTO> getAllLeaveHistory(int employeeId, Integer months, String fromDate, String toDate);

}
