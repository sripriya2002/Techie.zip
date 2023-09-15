package com.system.exception;

public class ProductAlreadyExistsException extends RuntimeException {

	public ProductAlreadyExistsException(String msg, Throwable ex) {
		super(msg, ex);
	}
}
