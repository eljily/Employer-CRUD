package net.sidibrahim.Employer;

import net.sidibrahim.Employer.entites.Employer;
import net.sidibrahim.Employer.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class EmployerApplication implements CommandLineRunner {
	@Autowired
	private EmployerRepository employerRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employerRepository.save(new Employer(null,"Sidi","sidi@gmail.com",400440,new Date()));
		employerRepository.save(new Employer(null,"Zeineb","znb@gmail.com",440,new Date()));
		employerRepository.save(new Employer(null,"Khaled","khaled@gmail.com",900,new Date()));
		employerRepository.save(new Employer(null,"Oumar","oumar@gmail.com",690,new Date()));
	}
}
