package com.leavemanagement.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.leavemanagement.dto.MyLeavesDto;
import com.leavemanagement.exception.LeaveException;
import com.leavemanagement.model.Employee;
import com.leavemanagement.model.Leaves;
import com.leavemanagement.repository.EmployeeRepository;
import com.leavemanagement.repository.LeaveRepository;
import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class LeaveServiceTest {

	@InjectMocks
	LeaveServiceImpl leaveService;
	
	@Mock
	LeaveRepository leaveRepository;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	public Employee getEmployee()
	{
		Employee employee = new Employee();
		employee.setEmail("sharathgs777@gmail.com");
		employee.setEmployeeId(1);
		employee.setLocation("Bangalore");
		employee.setName("Sharath");
		employee.setPassword("test@123");
		employee.setPhone("9738129042");
		return employee;
	}
	
	public Leaves getLeaves()
	{
		Leaves leave = new Leaves();
		leave.setAvailedCompanyHoliday(10);
		leave.setAvailedRestrictedHoliday(5);
		leave.setCompanyHoliday(10);
		leave.setEmployeeId(1);
		leave.setLeavesId(1);
		leave.setRestrictedHoliday(10);
		return leave;
	}
	
	@Test
	public void getMyLeavesTest()
	{			
		Mockito.when(leaveRepository.findByemployeeId(Mockito.anyInt())).thenReturn(Optional.of(getLeaves()));
		Mockito.when(employeeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(getEmployee()));
		MyLeavesDto myDto = leaveService.getMyLeaves(Mockito.anyInt());
		Assert.assertEquals("Sharath", myDto.getName());		
	}
	
	
	@Test(expected = LeaveException.class)
	public void getMyLeavesTestForEmployeeNotFound()
	{
		
		Mockito.when(employeeRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		Mockito.when(leaveRepository.findByemployeeId(Mockito.anyInt())).thenReturn(Optional.of(getLeaves()));
		MyLeavesDto myDto = leaveService.getMyLeaves(Mockito.anyInt());
		Assert.assertEquals(404, myDto.getStatusCode());		
	}
	
	
	@Test(expected = LeaveException.class)
	public void getMyLeavesTestForLeavesNotFound()
	{
		
		Mockito.when(employeeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(getEmployee()));
		Mockito.when(leaveRepository.findByemployeeId(Mockito.anyInt())).thenReturn(Optional.empty());
		MyLeavesDto myDto = leaveService.getMyLeaves(Mockito.anyInt());
		Assert.assertEquals(404, myDto.getStatusCode());		
	}
	
}
