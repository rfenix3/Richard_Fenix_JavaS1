package com.company.RichardFenixCarLotJpaRepository;

import com.company.RichardFenixCarLotJpaRepository.dao.CarLotRepository;
import com.company.RichardFenixCarLotJpaRepository.dto.CarLot;
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
public class RichardFenixCarLotJpaRepositoryApplicationTests {

	@Autowired
	CarLotRepository carLotRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void addGetDeleteTest(){
		carLotRepo.deleteAll();

		CarLot carLot = new CarLot();
		carLot.setMake("Honda");
		carLot.setModel("CRV");
		carLot.setYear("2015");
		carLot.setColor("Silver");

		// add to repo
		carLot = carLotRepo.save(carLot);

		// Now, object should have the database-generated carLot id
		// get copy from repo
		CarLot carLot1 = carLotRepo.findOne(carLot.getId());

		// get and add test
		assertEquals(carLot1, carLot);

		// Test if only 1 record was created in the db
		List<CarLot> carLotList = carLotRepo.findAll();
		assertEquals(1, carLotList.size());

		carLotRepo.delete(carLot);

		// Get the deleted object from db
		carLot = carLotRepo.findOne(carLot.getId());

		// deleteRoaster test
		assertNull(carLot);

		// Test if no record is left in the db
		carLotList = carLotRepo.findAll();
		assertEquals(0, carLotList.size());

	}

	@Test
	public void updateTest(){
		carLotRepo.deleteAll();

		CarLot carLot = new CarLot();
		carLot.setMake("Honda");
		carLot.setModel("CRV");
		carLot.setYear("2015");
		carLot.setColor("Silver");

		carLot = carLotRepo.save(carLot);

		// Update Year and Color
		carLot.setYear("2019");
		carLot.setColor("Blue");

		carLot = carLotRepo.save(carLot);

		// Create carLot1 info from the database through dao and compare with java coffee object.
		CarLot carLot1 = carLotRepo.findOne(carLot.getId());
		assertEquals(carLot1, carLot);
	}

	@Test
	public void findByMakeTest(){
		carLotRepo.deleteAll();

		CarLot carLot = new CarLot();
		carLot.setMake("Honda");
		carLot.setModel("CRV");
		carLot.setYear("2015");
		carLot.setColor("Silver");

		carLotRepo.save(carLot);

		carLot = new CarLot();
		carLot.setMake("Honda");
		carLot.setModel("Accord");
		carLot.setYear("2019");
		carLot.setColor("Gold");

		carLotRepo.save(carLot);

		carLot = new CarLot();
		carLot.setMake("Toyota");
		carLot.setModel("Camry");
		carLot.setYear("2018");
		carLot.setColor("Silver");

		carLotRepo.save(carLot);

		List<CarLot> carLotHonda = carLotRepo.findByMake("Honda");

		assertEquals(2, carLotHonda.size());
	}

	@Test
	public void findByColorTest(){
		carLotRepo.deleteAll();

		CarLot carLot = new CarLot();
		carLot.setMake("Honda");
		carLot.setModel("CRV");
		carLot.setYear("2015");
		carLot.setColor("Silver");

		carLotRepo.save(carLot);

		carLot = new CarLot();
		carLot.setMake("Honda");
		carLot.setModel("Accord");
		carLot.setYear("2019");
		carLot.setColor("Gold");

		carLotRepo.save(carLot);

		carLot = new CarLot();
		carLot.setMake("Toyota");
		carLot.setModel("Camry");
		carLot.setYear("2018");
		carLot.setColor("Silver");

		carLotRepo.save(carLot);

		List<CarLot> carLotSilver = carLotRepo.findByColor("Silver");

		assertEquals(2, carLotSilver.size());

	}

	@Test
	public void findByMakeAndColorTest(){
		carLotRepo.deleteAll();

		CarLot carLot = new CarLot();
		carLot.setMake("Honda");
		carLot.setModel("CRV");
		carLot.setYear("2015");
		carLot.setColor("Silver");

		carLotRepo.save(carLot);

		carLot = new CarLot();
		carLot.setMake("Honda");
		carLot.setModel("Accord");
		carLot.setYear("2019");
		carLot.setColor("Gold");

		carLotRepo.save(carLot);

		carLot = new CarLot();
		carLot.setMake("Toyota");
		carLot.setModel("Camry");
		carLot.setYear("2018");
		carLot.setColor("Silver");

		carLotRepo.save(carLot);

		carLot = new CarLot();
		carLot.setMake("Honda");
		carLot.setModel("Civic");
		carLot.setYear("2017");
		carLot.setColor("Silver");

		carLotRepo.save(carLot);

		carLot = new CarLot();
		carLot.setMake("Honda");
		carLot.setModel("Civic");
		carLot.setYear("2017");
		carLot.setColor("Red");

		carLotRepo.save(carLot);

		List<CarLot> carLotHondaSilver = carLotRepo.findByMakeAndColor("Honda","Silver");

		assertEquals(2, carLotHondaSilver.size());

	}

}
