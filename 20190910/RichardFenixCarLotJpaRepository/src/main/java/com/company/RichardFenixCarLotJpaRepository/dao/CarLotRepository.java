package com.company.RichardFenixCarLotJpaRepository.dao;

import com.company.RichardFenixCarLotJpaRepository.dto.CarLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarLotRepository extends JpaRepository<CarLot, Integer> {

    List<CarLot> findByMake(String make);

    List<CarLot> findByColor(String color);

    List<CarLot> findByMakeAndColor(String make, String color);
}
