package com.leavemanagement.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagement.dto.LeaveHistoryResponseDTO;
import com.leavemanagement.model.MyLeaves;
import com.leavemanagement.repository.LeaveHistoryRepository;

@Service
public class LeaveHistoryServiceImpl implements LeaveHistoryService {

	@Autowired
	LeaveHistoryRepository leaveHistoryRepository;

	public List<LeaveHistoryResponseDTO> getAllLeaveHistory(int employeeId, Integer months, String fromDate,
			String toDate) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate currentdate = LocalDate.now();
		List<LeaveHistoryResponseDTO> leaveHistoryResponse = new ArrayList<>();
		List<MyLeaves> myLeaves = new ArrayList<>();

		if (months == 3) {
			LocalDate threeMonth = LocalDate.now().minusMonths(3);
			myLeaves = leaveHistoryRepository.findByBetweenDate(employeeId, threeMonth, currentdate);
		} else if (months == 1) {
			LocalDate currentMonth = LocalDate.now().minusMonths(1);
			myLeaves = leaveHistoryRepository.findByBetweenDate(employeeId, currentMonth, currentdate);
		} else if (fromDate != null && toDate != null) {
			myLeaves = leaveHistoryRepository.findByBetweenDate(employeeId, LocalDate.parse(fromDate, formatter),
					LocalDate.parse(toDate, formatter));
		}

		if (!myLeaves.isEmpty()) {
			myLeaves.stream().forEach(myleave -> {
				LeaveHistoryResponseDTO leavesDto = new LeaveHistoryResponseDTO();
				BeanUtils.copyProperties(myleave, leavesDto);
				leaveHistoryResponse.add(leavesDto);
			});
		}

		return leaveHistoryResponse;
	}

}
