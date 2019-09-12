package com.leavemanagement.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.leavemanagement.dto.LoginRequestDto;
import com.leavemanagement.dto.LoginResponseDto;
import com.leavemanagement.exception.LoginException;
import com.leavemanagement.model.Employee;
import com.leavemanagement.repository.LoginRepository;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {
	
	@Mock
	LoginRepository loginRepository;
	
	@InjectMocks
	LoginServiceImpl loginServiceImpl;
	
	LoginRequestDto loginRequestDto = null;
	Employee emp = null;
	Employee emp1 = null;
	LoginResponseDto loginResponseDto = null;
	LoginResponseDto loginResponseDto1 = null;
	
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
		
		loginResponseDto1 = new LoginResponseDto();
		loginResponseDto1.setStatusCode(HttpStatus.NOT_FOUND.value());
	}
	@Test
	public void testUserLogin() {
		
		Mockito.when(loginRepository.findByEmail(loginRequestDto.getEmail())).thenReturn(Optional.of(emp));
		LoginResponseDto loginResponseDto2 = loginServiceImpl.userLogin(loginRequestDto);
		assertEquals(emp.getName(), loginResponseDto2.getName());
		
	}
	
	@Test(expected=LoginException.class)
	public void testUserLoginNotFound() {
		
		Mockito.when(loginRepository.findByEmail(loginRequestDto.getEmail())).thenReturn(Optional.empty());
		LoginResponseDto loginResponseDto2 = loginServiceImpl.userLogin(loginRequestDto);
		assertEquals(loginResponseDto1.getStatusCode(),loginResponseDto2.getStatusCode());
	}
}
