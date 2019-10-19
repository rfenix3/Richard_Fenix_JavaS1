package com.company.RichardFenixU1Capstone.dto;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Console {
    private int consoleId;
    @Size(max = 50)
    private String model;
    @Size(max = 50)
    private String manufacturer;
    // memoryAmount can be null;
    @Size(max = 20)
    private String memoryAmount;
    // processor can be null;
    @Size(max = 20)
    private String processor;
    private BigDecimal price;
    private int quantity;

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return getConsoleId() == console.getConsoleId() &&
                getQuantity() == console.getQuantity() &&
                getModel().equals(console.getModel()) &&
                getManufacturer().equals(console.getManufacturer()) &&
                Objects.equals(getMemoryAmount(), console.getMemoryAmount()) &&
                Objects.equals(getProcessor(), console.getProcessor()) &&
                getPrice().equals(console.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConsoleId(), getModel(), getManufacturer(), getMemoryAmount(), getProcessor(), getPrice(), getQuantity());
    }
}
