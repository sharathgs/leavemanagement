package com.leavemanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyLeavesDto {

	private int employeeId;
	private String name;
	private int restrictedHoliday;
	private int companyHoliday;
	private int availedRestrictedHoliday;
	private int availedCompanyHoliday;
	private String message;
	private int statusCode;
	
}