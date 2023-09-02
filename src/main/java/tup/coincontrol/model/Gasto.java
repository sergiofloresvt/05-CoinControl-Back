package tup.coincontrol.model;


import java.time.LocalDate;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Gasto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Long id;
    @Basic
    private Long monto;
    private String description;
    private LocalDate date;
   
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    
   
}
