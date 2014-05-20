package it.uniroma3.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table (name = "order_line")
public class OrderLine {

    @Id 
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
   
    @Column
    private String item;
    
    @Column
    private int quantity;
    
    @Column
    private Float price;
    
    @OneToOne
    @JoinColumn (name="product_id")
    private Product product;
}
