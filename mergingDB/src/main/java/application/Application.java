package application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application{
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		// fetch all customers
//				System.out.println("Customers found with findAll():");
//				System.out.println("-------------------------------");
//				for (Entity customer : repository.findAll()) {
//					System.out.println(customer);
//				}
//	}
}