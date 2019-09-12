package com.leavemanagement.dto;

import com.leavemanagement.util.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {

	private String message;
	private int statusCode;
	private Status status;
	private String name;
	private int employeeId;
}
