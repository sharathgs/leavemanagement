package com.leavemanagement.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.leavemanagement.dto.MyLeavesDto;
import com.leavemanagement.service.LeaveService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class LeaveControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	LeaveController leaveController;
	
	@Mock
	LeaveService leaveService;
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(leaveController).build();
    }
	
	public MyLeavesDto getLeaves()
	{
		MyLeavesDto myLeaves = new MyLeavesDto();
		myLeaves.setAvailedCompanyHoliday(10);
		myLeaves.setAvailedRestrictedHoliday(10);
		myLeaves.setCompanyHoliday(5);
		myLeaves.setEmployeeId(1);
		myLeaves.setName("Sharath");
		myLeaves.setRestrictedHoliday(5);
		myLeaves.setStatusCode(200);
		myLeaves.setMessage("available leaves are showing");
		return myLeaves;
	}
	
	@Test
	public void getBalanceController()
	{
		ResponseEntity<MyLeavesDto> expResult = new ResponseEntity<>(getLeaves(), HttpStatus.OK);
		when(leaveService.getMyLeaves(Mockito.anyInt())).thenReturn(getLeaves());
		ResponseEntity<MyLeavesDto> actResult = leaveController.getMyLeavesAvailable(Mockito.anyInt());
		assertEquals(expResult.getStatusCode(), actResult.getStatusCode());
	}
	
	
}
