package tup.coincontrol.controller;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tup.coincontrol.model.Category;
import tup.coincontrol.model.Gasto;
import tup.coincontrol.repository.CategoryRepository;
import tup.coincontrol.service.CategoryService;
import tup.coincontrol.service.GastoService;
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
@RestController
@RequestMapping("/gastos")
public class GastoController {
    private final GastoService gastoService;
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;
    @Autowired
    public GastoController(GastoService gastoService,
                        CategoryRepository categoryRepository,
                        CategoryService categoryService) {
        this.gastoService = gastoService;
        this.categoryRepository =categoryRepository;
        this.categoryService = categoryService;
    }
    
    // @PostMapping("/add")
    // public void createUser(@RequestBody Gasto gasto)
    // {
    //     gastoService.crearGasto(gasto);
    // }
    // @PostMapping("/add")
    // public ResponseEntity<Gasto> addGasto(
    //     @RequestParam Long monto,
    //     @RequestParam String descripcion,
    //     @RequestParam String date,
    //     @RequestParam Long category_id
    // ){
        
    //     Gasto newGasto = gastoService.addGasto(null, monto, descripcion, null, category_id);
    //     return ResponseEntity.ok(newGasto);
    // }
    @PostMapping("/add")
    public ResponseEntity<Gasto> addGastotoCategory(
        @RequestBody Gasto gasto,
        @RequestParam Long categoryId
    ){
        Category category = categoryRepository.findById(categoryId).orElse(null);
        gasto.setCategory(category);
        Gasto newGasto = gastoService.addGasto(gasto);
        return new ResponseEntity<>(newGasto, HttpStatus.CREATED);
    }
    

    /*GET ALL EXPENSE */
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
    
    // @GetMapping("/find/ByCategory/{categoryId}")
    //     public ResponseEntity<List<Gasto>> getGastosByCategory(@RequestBody Long categoryId){
    //         Category category = categoryService.findCategoryById(categoryId);

    //         if(category != null) {
    //             List<Gasto> gastos = gastoService.getGastosByCategory(category);
    //             return new ResponseEntity<>(gastos, HttpStatus.OK);

    //         }else {
    //             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //         }
    //     }
        /*Metodo 2 funcionando. All category de gastos*/
        @GetMapping("/find/categotyId")
        public List<Long> getCategoryId(){
            return gastoService.getAllCaegoryId();
        }
        
        /*Trae los gastos con la misma category */
        @GetMapping("/find/bycategory/{categoryId}")
        public List<Gasto> getGastoByCategory(
            @PathVariable Long categoryId){
            return gastoService.findGastoByCategoryId(categoryId);
        }
    }

