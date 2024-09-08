package com.lmsf.spring_batch.controller;

import java.time.LocalDateTime;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students/jobs") // <- Initial URL to access the controller
public class StudentController {
	
	@Autowired
	private JobLauncher jobLauncher; // <- Manages the jobs to execute
	
	@Autowired
	private Job job; // <- Set of steps that perform a specific action in an organized fashion
	
	
	
	// POST request where the job is executed:
	@PostMapping("/students-without-phone-number")
	public void getStudentsWithoutPhoneNumber() throws Exception  {
		// add a simple Job parameter:
		JobParameters params = new JobParametersBuilder()
						.addLocalDateTime("startedAt", LocalDateTime.now())
						.toJobParameters();
		
		try {
            jobLauncher.run(job, params);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e){
            e.printStackTrace();
        }
	}
}
