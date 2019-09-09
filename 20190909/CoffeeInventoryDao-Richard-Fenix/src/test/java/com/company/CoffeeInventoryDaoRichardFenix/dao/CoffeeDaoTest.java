package com.company.CoffeeInventoryDaoRichardFenix.dao;

import com.company.CoffeeInventoryDaoRichardFenix.model.Coffee;
import com.company.CoffeeInventoryDaoRichardFenix.model.Roaster;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CoffeeDaoTest {
    @Autowired
    RoasterDao roasterDao;
    @Autowired
    CoffeeDao coffeeDao;

    @Before
    public void setUp() throws Exception {
        // Clean up the test db
        // Note: Coffee table should be deleted first since Coffee table has foreign keys to Roaster table.
        List<Coffee> cList = coffeeDao.getAllCoffee();
        for (Coffee c : cList) {
            coffeeDao.deleteCoffee(c.getCoffee_id());
        }

        List<Roaster> rList = roasterDao.getAllRoaster();
        for (Roaster r : rList) {
            roasterDao.deleteRoaster(r.getRoaster_id());
        }
    }

    @Test
    public void addGetDeleteCoffee() {
        //========= Coffee data dependency creation starts here ===================

        // Creating the Roaster primary key data for Coffee table
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
        roaster = roasterDao.addRoaster(roaster);

        //========= Coffee data dependency creation ends here =====================

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Nescafe Light");
        coffee.setCount(50);
        coffee.setUnit_price(12.75);
        coffee.setDescription("Nescafe Decaffinated coffee.");
        coffee.setType("Decaf");

        // Coffee object added to the database
        coffee = coffeeDao.addCoffee(coffee);

        // Now, Coffee object should have the database-generated coffee_id (must be programmed in CoffeeDaoJdbcTemplateImpl)
        // Run the getCoffee() method here as well
        Coffee coffee1 = coffeeDao.getCoffee(coffee.getCoffee_id());

        // addConsole() test
        assertEquals(coffee1, coffee);

        coffeeDao.deleteCoffee(coffee.getCoffee_id());

        // Get the object reference
        coffee1 = coffeeDao.getCoffee(coffee.getCoffee_id());

        // deleteCoffee test
        assertNull(coffee1);
    }

    @Test(expected  = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException() {

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(99);
        coffee.setName("Arabica");
        coffee.setCount(12);
        coffee.setUnit_price(6.99);
        coffee.setDescription("Arabica coffee from Batangas, Philippines");
        coffee.setType("Dark");

        coffee = coffeeDao.addCoffee(coffee);
    }


    @Test
    public void getAllCoffee() {
        //========= Coffee data dependency creation starts here ===================

        // Creating the Roaster primary key data for Coffee table
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
        roaster = roasterDao.addRoaster(roaster);

        // Add second Roaster for creating multiple Coffee rows
        Roaster roaster2 = new Roaster();
        roaster2.setName("Maxwell");
        roaster2.setStreet("999 Roswell Rd");
        roaster2.setCity("Marietta");
        roaster2.setState("GA");
        roaster2.setPostal_code("30067");
        roaster2.setPhone("(678)404-9999");
        roaster2.setEmail("maxwell@gmail.com");
        //Note is not a required field so we can skip adding it.
        //roaster2.setNote("Note about Maxwell");

        // Object added to the database
        roaster2 = roasterDao.addRoaster(roaster2);

        //========= Coffee data dependency creation ends here =====================

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Nescafe Light");
        coffee.setCount(50);
        coffee.setUnit_price(12.75);
        coffee.setDescription("Nescafe Decaffinated coffee.");
        coffee.setType("Decaf");

        // Coffee object added to the database
        coffee = coffeeDao.addCoffee(coffee);

        // code below is added for clarity (but not needed) to show  that we are using same roaster
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Arabica");
        coffee.setCount(12);
        coffee.setUnit_price(6.99);
        coffee.setDescription("Arabica coffee from Batangas, Philippines");
        coffee.setType("Dark");

        // Coffee object added to the database
        coffee = coffeeDao.addCoffee(coffee);

        // Create a third coffee data but this time using roaster2 roaster_id
        coffee.setRoaster_id(roaster2.getRoaster_id());
        coffee.setName("Maxwell Zero");
        coffee.setCount(24);
        coffee.setUnit_price(18.75);
        coffee.setDescription("Maxell light Decaffinated coffee.");
        coffee.setType("Decaf");

        // Coffee object added to the database
        coffee = coffeeDao.addCoffee(coffee);

        List<Coffee> cList = coffeeDao.getAllCoffee();

        assertEquals(3, cList.size());
    }

    @Test
    public void updateCoffee() {
        //========= Coffee data dependency creation starts here ===================

        // Creating the Roaster primary key data for Coffee table
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
        roaster = roasterDao.addRoaster(roaster);

        // Add second Roaster for creating multiple Coffee rows
        Roaster roaster2 = new Roaster();
        roaster2.setName("Maxwell");
        roaster2.setStreet("999 Roswell Rd");
        roaster2.setCity("Marietta");
        roaster2.setState("GA");
        roaster2.setPostal_code("30067");
        roaster2.setPhone("(678)404-9999");
        roaster2.setEmail("maxwell@gmail.com");
        //Note is not a required field so we can skip adding it.
        //roaster2.setNote("Note about Maxwell");

        // Object added to the database
        roaster2 = roasterDao.addRoaster(roaster2);

        //========= Coffee data dependency creation ends here =====================

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Nescafe Light");
        coffee.setCount(50);
        coffee.setUnit_price(12.75);
        coffee.setDescription("Nescafe Decaffinated coffee.");
        coffee.setType("Decaf");

        // Coffee object added to the database
        coffee = coffeeDao.addCoffee(coffee);

        // Update price
        coffee.setUnit_price(10.25);

        coffeeDao.updateCoffee(coffee);

        // Create coffee1 info from the database through dao and compare with java coffee object.
        Coffee coffee1 = coffeeDao.getCoffee(coffee.getCoffee_id());
        assertEquals(coffee1, coffee);

    }

//    @Test
//    public void coffeeByRoster() {
//    }
//
//    @Test
//    public void coffeeByType() {
//    }
}