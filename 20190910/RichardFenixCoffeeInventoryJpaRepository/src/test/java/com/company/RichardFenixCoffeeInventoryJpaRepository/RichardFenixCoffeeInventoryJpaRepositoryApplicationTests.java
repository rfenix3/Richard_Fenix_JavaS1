package com.company.RichardFenixCoffeeInventoryJpaRepository;

import com.company.RichardFenixCoffeeInventoryJpaRepository.dao.CoffeeRepository;
import com.company.RichardFenixCoffeeInventoryJpaRepository.dao.RoasterRepository;
import com.company.RichardFenixCoffeeInventoryJpaRepository.dto.Roaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RichardFenixCoffeeInventoryJpaRepositoryApplicationTests {
	@Autowired
	CoffeeRepository coffeeRepo;
	@Autowired
	RoasterRepository roasterRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void addGetDeleteRoaster(){
		coffeeRepo.deleteAll();
		roasterRepo.deleteAll();

		Roaster roaster = new Roaster();
		roaster.setName("Nescafe");
		roaster.setStreet("90210 Ashford Dunwoody");
		roaster.setCity("Atlanta");
		roaster.setState("GA");
		roaster.setPostal_code("30346");
		roaster.setPhone("(404)123-4567");
		roaster.setEmail("nescafe@gmail.com");
		//Note is not a required field so we can skip adding it.
		roaster.setNote("Note about nescafe");

		// add to repo
		roaster = roasterRepo.save(roaster);

		// Now, object should have the database-generated roaster id
		// get copy from repo
//		Roaster roaster1 = roasterRepo.findOne(roaster.getRoaster_id());

		// get and add test
//		assertEquals(roaster1, roaster);

		// Test if only 1 record was created in the db
		List<Roaster> roasterList = roasterRepo.findAll();
		assertEquals(1, roasterList.size());

		roasterRepo.delete(roaster);

		// Get the deleted object from db
		roaster = roasterRepo.findOne(roaster.getRoaster_id());

		// deleteRoaster test
		assertNull(roaster);

		// Test if no record is left in the db
		roasterList = roasterRepo.findAll();
		assertEquals(0, roasterList.size());
	}

	@Test
	public void updateTest(){
		coffeeRepo.deleteAll();
		roasterRepo.deleteAll();

		Roaster roaster = new Roaster();
		roaster.setName("Nescafe");
		roaster.setStreet("90210 Ashford Dunwoody");
		roaster.setCity("Atlanta");
		roaster.setState("GA");
		roaster.setPostal_code("30346");
		roaster.setPhone("(404)123-4567");
		roaster.setEmail("nescafe@gmail.com");
		//Note is not a required field so we can skip adding it.
		roaster.setNote("Note about nescafe");

		// object added to the database
		roaster = roasterRepo.save(roaster);

		// Update the address data
		roaster.setStreet("1 Ravinia Drive");
		roaster.setCity("Dekalb");
		roaster.setState("GA");

		roaster = roasterRepo.save(roaster);

		// Create roaster1 info from the database through dao and compare with java coffee object.
		Roaster roaster1 = roasterRepo.findOne(roaster.getRoaster_id());
		assertEquals(roaster1.getStreet(), roaster.getState());
	}

}
