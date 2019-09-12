package com.leavemanagement.service;

import org.springframework.stereotype.Service;

import com.leavemanagement.dto.LoginRequestDto;
import com.leavemanagement.dto.LoginResponseDto;

@Service
public interface LoginService {

	LoginResponseDto userLogin(LoginRequestDto loginRequestDto);

}
