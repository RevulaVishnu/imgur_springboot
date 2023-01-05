package com.cognizant.userservice.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1558149957272449535L;
	private final int statusCode;
	private final HttpStatus status;
	private final String data;
}
