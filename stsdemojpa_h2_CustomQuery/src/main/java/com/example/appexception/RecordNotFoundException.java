/**
 * 
 */
package com.example.appexception;

/**
 * @author sunil
 *
 */
public class RecordNotFoundException extends Exception {

	public RecordNotFoundException(String message) {
		super(message);
	}

	public RecordNotFoundException(String message, Throwable t) {
		super(message, t);
	}

}
