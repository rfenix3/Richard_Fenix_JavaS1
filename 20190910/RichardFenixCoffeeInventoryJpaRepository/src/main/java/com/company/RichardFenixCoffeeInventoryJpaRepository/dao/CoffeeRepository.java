package com.company.RichardFenixCoffeeInventoryJpaRepository.dao;

import com.company.RichardFenixCoffeeInventoryJpaRepository.dto.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {

    //List<Coffee> findByRoasterId(Integer roaster_id);

    List<Coffee> findByType(String type);

    //List<Coffee> findByRoasterAndType(int roaster_id, String color);

}
