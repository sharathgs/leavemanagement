package com.leavemanagement.exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	public ErrorResponse(LocalDate localDate, String message2, String description) {
	}

	private LocalDate timestamp;
	private String message;
	private String details;

}
