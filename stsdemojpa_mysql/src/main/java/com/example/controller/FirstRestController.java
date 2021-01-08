/**
 * 
 */
package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunil
 *
 */
@RestController
public class FirstRestController {

	@GetMapping("/")
	public String sayHello() {
		return "Welcome to spring boot";
	}
}
