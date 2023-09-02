package tup.coincontrol.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tup.coincontrol.model.Category;
import tup.coincontrol.model.Gasto;

public interface GastoRepository extends JpaRepository <Gasto, Long>{

    List<Gasto> findByCategory(Category category);

    Optional<Gasto> findExpenseById(Long id);
    static Gasto orElseThrow(Object object) {
        return null;
    }
    
}
