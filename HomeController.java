/**
 * 
 */
package com.resturant.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 */
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String goToHome() {
		return "index";
	}

}
