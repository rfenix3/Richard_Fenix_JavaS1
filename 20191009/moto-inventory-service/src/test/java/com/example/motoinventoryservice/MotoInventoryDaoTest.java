package com.example.motoinventoryservice;

import com.example.motoinventoryservice.dao.MotoInventoryDao;
import com.example.motoinventoryservice.model.Motorcycle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
/**
 * Integrating our test with Spring.
 * Applies 'Dependency Injection' means Spring will do the instantiation of the class that the test will need.
 */
@SpringBootTest
public class MotoInventoryDaoTest {

    // dao is the implementation interface that we want Spring to wire with the test class
    @Autowired
    //@Qualifier("This bean")
    protected MotoInventoryDao dao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Motorcycle> mList = dao.getAllMotorcycles();
        mList.stream()
                .forEach(motorcycle -> dao.deleteMotorcycle(motorcycle.getId()));

    }

    // Triple Arrange, Act (call and retrieve), and Assert (comparing retrieved data with database)
    @Test
    public void addGetDeleteMotorcycle() {
        Motorcycle moto = new Motorcycle();
        moto.setVin("12345");
        moto.setMake("Honda");
        moto.setModel("Africa Twin");
        moto.setYear("2019");
        moto.setColor("Black");

        // Creates moto object
        moto = dao.addMotorcycle(moto);

        Motorcycle moto2 = dao.getMotorcycle((moto.getId()));

        assertEquals(moto, moto2);

        dao.deleteMotorcycle(moto.getId());

        moto2 = dao.getMotorcycle(moto.getId());

        assertNull(moto2);
    }

    @Test
    public void getAllMotorcycle(){
        Motorcycle moto = new Motorcycle();
        moto.setVin("12345");
        moto.setMake("Honda");
        moto.setModel("Africa Twin");
        moto.setYear("2019");
        moto.setColor("Black");

        Motorcycle moto2 = new Motorcycle();
        moto2.setVin("67890");
        moto2.setMake("Yamaha");
        moto2.setModel("American Triplets");
        moto2.setYear("2020");
        moto2.setColor("Silver");

        // Creates moto object
        moto = dao.addMotorcycle(moto);

        // Creates moto2 object
        moto2 = dao.addMotorcycle(moto2);

        List<Motorcycle> mList = dao.getAllMotorcycles();

        int mListSize = mList.size();

        assertEquals(2, mListSize);

    }

    @Test
    public void updateMotorcycle(){

        Motorcycle moto = new Motorcycle();  // Create moto object.
        moto.setVin("12345");
        moto.setMake("Honda");
        moto.setModel("Africa Twin");
        moto.setYear("2019");
        moto.setColor("Black");

        moto = dao.addMotorcycle(moto);

        // Java object is now changed from hereon. DB data not yet changed.
        moto.setVin("99999");
        moto.setMake("Honda");
        moto.setModel("Africa Triple");
        moto.setYear("2019");
        moto.setColor("Silver");

        // Change Database data using update.
        dao.updateMotorcycle(moto);

        Motorcycle moto2 = dao.getMotorcycle(moto.getId());  // Create moto record or rows in the database.

        assertEquals(moto, moto2);

    }

//    @Test
//    public void getMotorcyclebyMake(){
//        Motorcycle moto = new Motorcycle();  // Create moto object.
//        moto.setVin("12345");
//        moto.setMake("Honda");
//        moto.setModel("Africa Twin");
//        moto.setYear("2019");
//        moto.setColor("Black");
//
//        Motorcycle moto2 = new Motorcycle();  // Create moto2 object.
//        moto2.setVin("67890");
//        moto2.setMake("Suzuki");
//        moto2.setModel("American Triplets");
//        moto2.setYear("2020");
//        moto2.setColor("Silver");
//
//        Motorcycle moto3 = new Motorcycle();  // Create moto2 object.
//        moto3.setVin("99999");
//        moto3.setMake("Suzuki");
//        moto3.setModel("American Twin");
//        moto3.setYear("2019");
//        moto3.setColor("Gold");
//
//        // Creates moto object
//        moto = dao.addMotorcycle(moto);  // Create moto record or rows in the database.
//
//        // Creates moto2 object
//        moto2 = dao.addMotorcycle(moto2);  // Create moto2 record in the database.
//
//        // Creates moto3 object
//        moto3 = dao.addMotorcycle(moto3);  // Create moto2 record in the database.
//
//
//        List<Motorcycle> mList = dao.getMotorcycleByMake("Suzuki");
//        assertEquals(2, mList.size());
//
//    }


}