package com.company.CoffeeInventoryDaoRichardFenix.dao;

import com.company.CoffeeInventoryDaoRichardFenix.model.Coffee;
import com.company.CoffeeInventoryDaoRichardFenix.model.Roaster;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RoasterDaoTest {
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
    public void addGetDeleteRoaster() {
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

        // Now, object should have the database-generated roaster_id (must be programmed in RoasterDaoJdbcTemplateImpl)
        // Run the getRoaster() method here as well
        Roaster roaster1 = roasterDao.getRoaster(roaster.getRoaster_id());

        // addRoaster() test
        assertEquals(roaster1, roaster);

        roasterDao.deleteRoaster(roaster.getRoaster_id());

        // Get the object reference
        roaster1 = roasterDao.getRoaster(roaster.getRoaster_id());

        // deleteRoaster test
        assertNull(roaster1);
    }


    @Test
    public void getAllRoaster() {
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

        roaster = new Roaster();
        roaster.setName("Maxwell");
        roaster.setStreet("999 Roswell Rd");
        roaster.setCity("Marietta");
        roaster.setState("GA");
        roaster.setPostal_code("30067");
        roaster.setPhone("(678)404-9999");
        roaster.setEmail("maxwell@gmail.com");
        //Note is not a required field so we can skip adding it.
        roaster.setNote("Note about maxwell");

        // Object added to the database
        roaster = roasterDao.addRoaster(roaster);

        List<Roaster> cList = roasterDao.getAllRoaster();
        assertEquals(cList.size(), 2);
    }

    @Test
    public void updateRoaster() {
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

        // Update the address data
        roaster.setStreet("1 Ravinia Drive");
        roaster.setCity("Dekalb");
        roaster.setState("GA");

        roasterDao.updateRoaster(roaster);

        // Get the reference of the updated roaster
        Roaster roaster1 = roasterDao.getRoaster(roaster.getRoaster_id());

        assertEquals(roaster1, roaster);
    }

}