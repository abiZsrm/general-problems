package com.generalproblems.dynamicTaskScheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = "com.generalproblems")
public class DynamicTaskSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicTaskSchedulerApplication.class, args);
	}
}
