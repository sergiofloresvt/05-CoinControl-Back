package tup.coincontrol.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tup.coincontrol.model.Category;
import tup.coincontrol.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private final CategoryRepository categoryRepository;

    
    public CategoryService(CategoryRepository categoryRepository){

        this.categoryRepository = categoryRepository;
    }
    
    /*Metodo para agregar un nuevo registro */
    public Category addCategory(Category category){

    return categoryRepository.save(category);
    }

    /* Buscar Category por ID */
    public Category findCategoryById(Long id) {
        return categoryRepository.findCategoryById(id).orElse(null);

                
    }
}


