package com.mdconsulting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.mdconsulting"})
public class MdconsultingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdconsultingApplication.class, args);
	}

}
