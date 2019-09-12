package com.leavemanagement.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
public class MyLeaves {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int myLeavesId;
	private int employeeId;
	private String status;
	private int noOfDays;
	private String leaveType;
	private LocalDate appliedDate;
	private LocalDate fromDate;
	private LocalDate toDate;

}
