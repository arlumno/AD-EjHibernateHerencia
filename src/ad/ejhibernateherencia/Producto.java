/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernateherencia;

import javax.persistence.Entity;
import javax.persistence.*;


/**
 *
 * @author a20armandocb
 */
@Entity
@Table(name = "productos")
public class Producto {
    
    @Id
    String codigo;
    
    int stockActualAlmacen;
    
    final int stockMinimo = 30;
    float precioUnidad;

}
