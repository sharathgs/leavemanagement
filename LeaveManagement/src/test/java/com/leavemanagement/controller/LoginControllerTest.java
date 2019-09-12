package com.leavemanagement.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.leavemanagement.dto.LoginRequestDto;
import com.leavemanagement.dto.LoginResponseDto;
import com.leavemanagement.model.Employee;
import com.leavemanagement.service.LoginServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@Mock
	LoginServiceImpl loginServiceImpl;

	@InjectMocks
	LoginController loginController;

	LoginRequestDto loginRequestDto = null;
	Employee emp = null;
	LoginResponseDto loginResponseDto = null;

	@Before
	public void setUp() {
		loginRequestDto = new LoginRequestDto();
		loginRequestDto.setEmail("mahi@hcl.com");
		loginRequestDto.setPassword("gowtham");
		
		emp = new Employee();
		emp.setEmail("mahi@hcl.com");
		emp.setPassword("gowtham");
		emp.setEmployeeId(1);
		emp.setLocation("Bangalore");
		emp.setName("Mahesh");
		emp.setPhone("99999");
		
		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setEmployeeId(emp.getEmployeeId());
		loginResponseDto.setName(emp.getName());
	}

	@Test
	public void testUserLogin() {

		Mockito.when(loginServiceImpl.userLogin(loginRequestDto)).thenReturn(loginResponseDto);
		ResponseEntity<LoginResponseDto> loginResponseDto1 = loginController.userLogin(loginRequestDto);
		assertEquals(emp.getName(), loginResponseDto1.getBody().getName());

	}

}
