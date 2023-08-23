package tup.coincontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tup.coincontrol.model.Category;

public interface CategoryRepository extends JpaRepository <Category, Long> {
    
}
