package tup.coincontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tup.coincontrol.model.Gasto;
import tup.coincontrol.repository.GastoRepository;

@Service
public class GastoService {

    @Autowired
    private final GastoRepository gastoRepository;
    
    
    public GastoService(GastoRepository gastoRepository) {
        
        this.gastoRepository = gastoRepository;
    }

    
    public void crearGasto(Gasto gasto){
        
        gastoRepository.save(gasto);
    }
    
    /*Metodo para traer todas los Gastos */
    public List<Gasto> findAllGastos() {
        return gastoRepository.findAll();
    }
    public Gasto updateExpense(Long id, Gasto updatedExpense) {
        Gasto gasto = gastoRepository.findById(id).orElseGet(null);
         
        if(gasto !=null){
             gasto.setMonto(updatedExpense.getMonto());
             return gastoRepository.save(gasto);
        } else{

            throw new RuntimeException("Expense not found with id " + id);
        }  
      }
    }

