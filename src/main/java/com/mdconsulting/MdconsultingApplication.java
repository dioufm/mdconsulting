package com.mdconsulting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.mdconsulting.controller" })
public class MdconsultingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdconsultingApplication.class, args);
	}

}
