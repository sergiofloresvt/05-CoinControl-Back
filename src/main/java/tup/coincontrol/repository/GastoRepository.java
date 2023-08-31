package tup.coincontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tup.coincontrol.model.Gasto;

public interface GastoRepository extends JpaRepository <Gasto, Long>{

    static Gasto orElseThrow(Object object) {
        return null;
    }
    
}
