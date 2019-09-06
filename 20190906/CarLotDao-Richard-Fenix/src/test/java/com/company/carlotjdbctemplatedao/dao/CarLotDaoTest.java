package com.company.carlotjdbctemplatedao.dao;

import com.company.carlotjdbctemplatedao.model.Car;
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
@SpringBootTest

public class CarLotDaoTest {

    // dao is the implementation interface that we want Spring to wire with the test class
    @Autowired
    //@Qualifier("This bean")
    protected CarLotDao dao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Car> mList = dao.getAllCars();
        mList.stream()
                .forEach(car -> dao.deleteCar(car.getId()));

    }

    // Triple Arrange, Act (call and retrieve), and Assert (comparing retrieved data with database)
    @Test
    public void addGetDeleteCar() {
        Car moto = new Car();
        moto.setMake("Honda");
        moto.setModel("Accord");
        moto.setYear("2019");
        moto.setColor("Black");

        // Creates car object
        moto = dao.addCar(moto);

        Car moto2 = dao.getCar((moto.getId()));

        assertEquals(moto, moto2);

        dao.deleteCar(moto.getId());

        moto2 = dao.getCar(moto.getId());

        assertNull(moto2);
    }

    @Test
    public void getAllCar(){
        Car moto = new Car();
        moto.setMake("Honda");
        moto.setModel("Accord");
        moto.setYear("2019");
        moto.setColor("Black");

        Car moto2 = new Car();
        moto2.setMake("Toyota");
        moto2.setModel("Camry");
        moto2.setYear("2020");
        moto2.setColor("Silver");

        // Creates moto object
        moto = dao.addCar(moto);

        // Creates moto2 object
        moto2 = dao.addCar(moto2);

        List<Car> mList = dao.getAllCars();

        int mListSize = mList.size();

        assertEquals(2, mListSize);

    }

    @Test
    public void updateCar(){

        Car moto = new Car();  // Create moto object.
        moto.setMake("Honda");
        moto.setModel("Accord");
        moto.setYear("2019");
        moto.setColor("Black");

        moto = dao.addCar(moto);

        // Java object is now changed from hereon. DB data not yet changed.
        moto.setMake("Honda");
        moto.setModel("Accord");
        moto.setYear("2020");
        moto.setColor("Silver");

        // Change Database data using update.
        dao.updateCar(moto);

        Car moto2 = dao.getCar(moto.getId());  // Create moto record or rows in the database.

        assertEquals(moto, moto2);

    }

    @Test
    public void getCarbyMake(){
        Car moto = new Car();  // Create moto object.
        moto.setMake("Honda");
        moto.setModel("Accord");
        moto.setYear("2019");
        moto.setColor("Silver");

        Car moto2 = new Car();  // Create moto2 object.
        moto2.setMake("Toyota");
        moto2.setModel("Genesis");
        moto2.setYear("2020");
        moto2.setColor("Silver");

        Car moto3 = new Car();  // Create moto2 object.
        moto3.setMake("Toyota");
        moto3.setModel("Elantra");
        moto3.setYear("2019");
        moto3.setColor("Gold");

        // Creates moto object
        moto = dao.addCar(moto);  // Create moto record or rows in the database.

        // Creates moto2 object
        moto2 = dao.addCar(moto2);  // Create moto2 record in the database.

        // Creates moto3 object
        moto3 = dao.addCar(moto3);  // Create moto2 record in the database.


        List<Car> mList = dao.getCarByMake("Toyota");
        assertEquals(2, mList.size());

    }

    @Test
    public void getCarbyColor(){
        Car moto = new Car();  // Create moto object.
        moto.setMake("Honda");
        moto.setModel("Accord");
        moto.setYear("2019");
        moto.setColor("Silver");

        Car moto2 = new Car();  // Create moto2 object.
        moto2.setMake("Toyota");
        moto2.setModel("Genesis");
        moto2.setYear("2020");
        moto2.setColor("Silver");

        Car moto3 = new Car();  // Create moto2 object.
        moto3.setMake("Toyota");
        moto3.setModel("Elantra");
        moto3.setYear("2019");
        moto3.setColor("Gold");

        // Creates moto object
        moto = dao.addCar(moto);  // Create moto record or rows in the database.

        // Creates moto2 object
        moto2 = dao.addCar(moto2);  // Create moto2 record in the database.

        // Creates moto3 object
        moto3 = dao.addCar(moto3);  // Create moto2 record in the database.


        List<Car> mList = dao.getCarByColor("Silver");
        assertEquals(2, mList.size());

    }

}
