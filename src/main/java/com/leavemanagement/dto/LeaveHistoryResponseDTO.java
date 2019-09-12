package com.leavemanagement.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LeaveHistoryResponseDTO {

	private int myLeavesId;
	private int employeeId;
	private String status;
	private int noOfDays;
	private String leaveType;
	private LocalDate appliedDate;
	private LocalDate fromDate;
	private LocalDate toDate;

}
