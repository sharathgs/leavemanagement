package com.leavemanagement.model;

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
public class Leaves {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int leavesId;
	private int employeeId;
	private int restrictedHoliday;
	private int companyHoliday;
	private int availedRestrictedHoliday;
	private int availedCompanyHoliday;
	
}
