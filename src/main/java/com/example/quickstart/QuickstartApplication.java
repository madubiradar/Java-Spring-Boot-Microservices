package com.example.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class QuickstartApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickstartApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(){
		return "Hello Madu";
	}

	@PostMapping("/hello")
	public String returnName(@RequestBody String name){
		return "Hello "+ name;
	}

}
