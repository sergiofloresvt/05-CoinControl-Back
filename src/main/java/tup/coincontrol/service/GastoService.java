package tup.coincontrol.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tup.coincontrol.model.Category;
import tup.coincontrol.model.Gasto;

import tup.coincontrol.repository.GastoRepository;

@Service
public class GastoService {

    @Autowired
    private final GastoRepository gastoRepository;
    
    
    
    public GastoService(GastoRepository gastoRepository) {
        
        this.gastoRepository = gastoRepository;
        
    }   

    public Gasto addGasto(Gasto gasto){
        
        return gastoRepository.save(gasto);
    }

    /*Obtener las los gastos de la misma Categoria */
    // public List<Gasto> getGastosByCategory(Category category){
    //     return gastoRepository.findByCategory(category);
    // }

    /*Metodo  Taer toas las categoria 
    existenes en los gastos
    Funcionando.*/

    public List<Long> getAllCaegoryId(){
        List<Gasto> gastos = gastoRepository.findAll();
        Set<Long> categoryId= gastos.stream()
        .map(gasto -> gasto.getCategory().getId())
        .collect(Collectors.toSet());
        return new ArrayList<>(categoryId);

    }
    /*Taer una categoria en particular de los gastos 
     * Funcionando.
    */
    public List<Gasto> findGastoByCategoryId(Long categoryId){
        return gastoRepository.findByCategory_Id(categoryId);
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

