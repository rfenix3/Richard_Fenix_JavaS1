package com.company.RichardFenixU1Capstone.controller;

import com.company.RichardFenixU1Capstone.dto.Console;
import com.company.RichardFenixU1Capstone.exceptions.GameStoreNotFoundException;
import com.company.RichardFenixU1Capstone.service.ServiceLayer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("console") // http://localhost:8080/console
public class ConsoleWebServiceController {
    private final ServiceLayer serviceLayer;

    public ConsoleWebServiceController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Console addConsoleToDB(@RequestBody @Valid Console console) {
        return serviceLayer.saveConsole(console);

    }

    @DeleteMapping(path = "/{console_id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsoleFromDB(@PathVariable int console_id) {
        serviceLayer.removeConsole(console_id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsoleListfromDB() {
        return serviceLayer.findAllConsoles();

    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsoleFromDB(@PathVariable int id) throws Exception {
        Console console = serviceLayer.findConsole(id);
        if (console == null) {
            throw new GameStoreNotFoundException("Console not found.");
        }
        return console;

    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateConsoleInDB(@RequestBody @Valid Console console) {
        serviceLayer.updateConsole(console);

    }

    @GetMapping(path = "manufacturer/{manufacturer}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsolesByManufacturerfromDB(@PathVariable String manufacturer) throws Exception {
        List<Console> gList = serviceLayer.findConsolesByManufacturer(manufacturer);
        if (gList.size() == 0) {
            throw new GameStoreNotFoundException("No games found.");
        }
        return gList;
    }
}