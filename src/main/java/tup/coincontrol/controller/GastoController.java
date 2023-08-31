package tup.coincontrol.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import tup.coincontrol.model.Gasto;

import tup.coincontrol.service.GastoService;
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
@RestController
@RequestMapping("/gastos")
public class GastoController {
    private final GastoService gastoService;

    @Autowired
    public GastoController(GastoService gastoService) {
        
        this.gastoService = gastoService;
    }
    
        @PostMapping("/crear")
    public void createUser(@RequestBody Gasto gasto)
    {
        gastoService.crearGasto(gasto);
    }
    /*GET ALL */
    @GetMapping("/all")
    public ResponseEntity<List<Gasto>>getAllGasto() {
        
        List<Gasto> gastos = gastoService.findAllGastos();
        return new ResponseEntity<>(gastos, HttpStatus.OK);
    }    


    /*Actualiza el nuevo valor en monto */
    @PutMapping("/update/{id}")
    public ResponseEntity<Gasto> updateExpense(@PathVariable Long id, @RequestBody Gasto updatedExpense) {
      Gasto gasto = gastoService.updateExpense(id, updatedExpense);
      return ResponseEntity.ok(gasto);
    }
  
}
