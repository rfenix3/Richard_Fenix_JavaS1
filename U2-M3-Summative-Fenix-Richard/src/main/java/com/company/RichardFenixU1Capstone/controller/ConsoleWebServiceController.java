package com.company.RichardFenixU1Capstone.controller;

import com.company.RichardFenixU1Capstone.dto.Console;
import com.company.RichardFenixU1Capstone.exceptions.GameStoreNotFoundException;
import com.company.RichardFenixU1Capstone.service.ServiceLayer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
//@RequestMapping("console") // http://localhost:8080/console
public class ConsoleWebServiceController {
    // All DAOs for each model is created with ServiceLayer's contructor.
    private final ServiceLayer serviceLayer;

    public ConsoleWebServiceController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

//    Move this to a separate controller class.
//    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
//    public String loggedIn(Principal principal) {
//        return "Hello " + principal.getName() + "! Looks like you're logged in!";
//    }

    //@PostMapping
    @RequestMapping(value = "/console", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Console addConsoleToDB(@RequestBody @Valid Console console) {
        return serviceLayer.saveConsole(console);

    }

    //@DeleteMapping(path = "/{console_id}")
    @RequestMapping(value = "/console/{console_id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsoleFromDB(@PathVariable int console_id) {
        serviceLayer.removeConsole(console_id);
    }

    //@GetMapping
    @RequestMapping(value = "/console", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsoleListfromDB() {
        return serviceLayer.findAllConsoles();

    }

    //@GetMapping(path = "/{id}")
    @RequestMapping(value = "/console/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsoleFromDB(@PathVariable int id) throws Exception {
        Console console = serviceLayer.findConsole(id);
        if (console == null) {
            throw new GameStoreNotFoundException("Console not found.");
        }
        return console;

    }

    //@PutMapping
    @RequestMapping(value = "/console", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateConsoleInDB(@RequestBody @Valid Console console) {
        serviceLayer.updateConsole(console);

    }

    //@GetMapping(path = "manufacturer/{manufacturer}")
    @RequestMapping(value = "/console/manufacturer/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsolesByManufacturerfromDB(@PathVariable String manufacturer) throws Exception {
        List<Console> gList = serviceLayer.findConsolesByManufacturer(manufacturer);
        if (gList.size() == 0) {
            throw new GameStoreNotFoundException("No games found.");
        }
        return gList;
    }

//    Move this to a separate controller class.
//    @RequestMapping(value = "/allDone", method = RequestMethod.GET)
//    public String allDone() {
//        return "That's All Folks!";
//    }

}