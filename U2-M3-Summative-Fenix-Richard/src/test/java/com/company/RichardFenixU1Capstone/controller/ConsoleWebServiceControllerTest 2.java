package com.company.RichardFenixU1Capstone.controller;

import com.company.RichardFenixU1Capstone.dto.Console;
import com.company.RichardFenixU1Capstone.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleWebServiceController.class)
public class ConsoleWebServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer service;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void getConsoleFromDB() throws Exception {
        Console console = new Console();
        console.setModel("PS4 Pro");
        console.setManufacturer("Sony");
        console.setMemoryAmount("1 TB");
        console.setProcessor("AMD Jaguar 8-core");
        console.setPrice(new BigDecimal("249.99"));
        console.setQuantity(30);
        console.setConsoleId(101);

        //Console returnVal = console;

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(console);

        // Mocking DAO response
        // This is another way to mock using mockito
        // same as doReturn(returnVal).when(repo).findById(8);
        // We could also set up our mocks in a separate method, if we so chose
        when(service.findConsole(101)).thenReturn(console);

        this.mockMvc.perform(get("/console/101"))
                .andDo(print())
                .andExpect(status().isOk())
                //use the objectmapper output with the json method
                .andExpect(content().json(outputJson));

    }

    @Test
    public void getConsolethatDoesNotExistReturns404() throws Exception {

        // Since findById returns an Optional, we create one. But this time without a value
        // as that would be the expected behavior if we searched for a non-existant id
        //Optional<Rsvp> returnVal = Optional.empty();

        int idForConsoleThatDoesNotExist = 100;

        this.mockMvc.perform(get("/console/" + idForConsoleThatDoesNotExist))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void addConsoleToDB() {
//        Console inputConsole = new Console();
//        inputConsole.setGuestName("Mock Gruber");
//        inputConsole.setTotalAttending(100);
//
//        //Object to JSON in String
//        String inputJson = mapper.writeValueAsString(inputConsole);
//
//        Console outputConsole = new Console();
//        outputConsole.setGuestName("Mock Gruber");
//        outputConsole.setTotalAttending(100);
//        outputConsole.setId(8);
//
//        //Object to JSON in String
//        String outputJson = mapper.writeValueAsString(outputConsole);
//
//        when(repo.save(inputConsole)).thenReturn(outputConsole);
//
//        this.mockMvc.perform(post("/console")
//                .content(inputJson)
//                .contentType(MediaType.APPLICATION_JSON)
//        ).andDo(print())
//                .andExpect(status().isCreated())
//                .andExpect(content().json(outputJson));

    }

    @Test
    public void deleteConsoleFromDB() {
    }

    @Test
    public void getConsoleListfromDB() {
    }


    @Test
    public void updateConsoleInDB() {
    }
}