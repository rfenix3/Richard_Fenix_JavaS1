package com.company.RichardFenixCoffeeInventoryJpaRepository.dao;

import com.company.RichardFenixCoffeeInventoryJpaRepository.dto.Roaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoasterRepository extends JpaRepository<Roaster, Integer> {


}
