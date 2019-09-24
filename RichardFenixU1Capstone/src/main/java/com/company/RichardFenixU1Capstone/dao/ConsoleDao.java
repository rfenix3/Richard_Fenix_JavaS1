package com.company.RichardFenixU1Capstone.dao;

import com.company.RichardFenixU1Capstone.dto.Console;

import java.util.List;

public interface ConsoleDao {
    Console addConsole(Console console);

    Console getConsole(int id);

    List<Console> getAllConsoles();

    void updateConsole(Console console);

    void deleteConsole(int id);

    List<Console> getConsolesByManufacturer(String manufacturer);

}
