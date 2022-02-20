/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernateherencia;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author a20armandocb
 */
@Entity
@Table(name = "Ventas")
public class Venta {

    @Id
    @GeneratedValue
    private Long id;

    LocalDate fechaVenta;
    LocalDateTime hora;
    String codigoArticulo;
    int numeroUnidades;
    float importe;

     @ManyToMany(
            cascade = {CascadeType.ALL},
            mappedBy = "ventas", //nombre de la variable en el otro pojo
            fetch = FetchType.EAGER)
    private Set<Temporal> temporales = new HashSet();
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
