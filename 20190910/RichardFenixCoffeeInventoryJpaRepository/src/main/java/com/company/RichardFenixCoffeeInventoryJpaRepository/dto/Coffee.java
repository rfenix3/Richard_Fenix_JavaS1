package com.company.RichardFenixCoffeeInventoryJpaRepository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="coffee")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer coffee_id;
    private Integer roaster_id;
    private String name;
    private Integer count;
    private BigDecimal unit_price;
    private String description;
    private String type;

    public Integer getCoffee_id() {
        return coffee_id;
    }

    public void setCoffee_id(Integer coffee_id) {
        this.coffee_id = coffee_id;
    }

    public Integer getRoaster_id() {
        return roaster_id;
    }

    public void setRoaster_id(Integer roaster_id) {
        this.roaster_id = roaster_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return getCoffee_id().equals(coffee.getCoffee_id()) &&
                getRoaster_id().equals(coffee.getRoaster_id()) &&
                getName().equals(coffee.getName()) &&
                getCount().equals(coffee.getCount()) &&
                getUnit_price().equals(coffee.getUnit_price()) &&
                Objects.equals(getDescription(), coffee.getDescription()) &&
                Objects.equals(getType(), coffee.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoffee_id(), getRoaster_id(), getName(), getCount(), getUnit_price(), getDescription(), getType());
    }
}
