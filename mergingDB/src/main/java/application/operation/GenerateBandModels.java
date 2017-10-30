package application.operation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class GenerateBandModels implements CommandLineRunner {

	/**
	 * Creates an band from each of the Entities in the Musiccrux database
	 * 
	 * @return void
	 */
	private void constructBandFromEntity() {

	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
