package aq.project.main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import aq.project.service.PlaneFinderService;

//@SpringBootTest
class PlaneFinderApplicationTests {

	@Test
	void listOfAircraftsIsnotEmpty() {
		PlaneFinderService service = new PlaneFinderService();
		assertThat(service.getAircraft().size()).isGreaterThan(0);
	}

}
