package com.leavemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leavemanagement.dto.MyLeavesDto;
import com.leavemanagement.service.LeaveService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@Slf4j
public class LeaveController {
	
	/**
	 * @author Sharath
	 * @apiNote controller for rh and ch leave
	 * @return
	 */
	
	@Autowired
	LeaveService leaveService;
	
	@GetMapping("/leaves/{employeeId}")
	public ResponseEntity<MyLeavesDto> getMyLeavesAvailable(@PathVariable("employeeId") int employeeId)
	{
		log.info("controller event for ch and rh leaves");
		return new ResponseEntity<>(leaveService.getMyLeaves(employeeId),HttpStatus.OK);
	}

}
